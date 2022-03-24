package edu.javacourse.studentorder.dao;

import edu.javacourse.studentorder.config.Config;
import edu.javacourse.studentorder.domain.*;
import edu.javacourse.studentorder.exception.DaoException;

import java.sql.*;
import java.time.LocalDateTime;

public class StudentOrderDAOImpl implements StudentOrderDAO{

    public static final String INSERT_ORDER = "INSERT INTO jc_student_order(\n" +
            "student_order_status, student_order_date, h_sur_name, h_given_name, h_patronymic, h_date_of_birth," +
            " h_passport_seria, h_passport_number, h_passport_date, h_passport_office_id, h_post_index, h_street_code, h_building, " +
            "h_extension, h_apartment, w_sur_name, w_given_name, w_patronymic, w_date_of_birth, w_passport_seria, w_passport_number, " +
            "w_passport_date, w_passport_office_id, w_post_index, w_street_code, w_building, w_extension, w_apartment, certificate_id, " +
            "register_office_id, marriage_date)\n" +
            "\tVALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

    public static final String INSERT_CHILD = "INSERT INTO jc_student_child(\n" +
            "student_order_id, \"с_sur_name\", \"с_given_name\", \"с_patronymic\", " +
            "\"с_date_of_birth\", \"с_certificate_number\", \"с_certificate_date\", c_register_office_id, \"с_post_index\"," +
            "\"с_street_code\", \"с_building\", \"с_extension\", \"с_apartment\")\n" +
            "\tVALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

    // TODO refactoring - make one method
    private Connection getConnection() throws SQLException {
        Connection connection = DriverManager
                .getConnection(Config.getProperty(Config.DB_URL),
                        Config.getProperty(Config.DB_LOGIN),
                        Config.getProperty(Config.DB_PASSWORD));
        return connection;
    }

    @Override
    public Long saveStudentOrder(StudentOrder so) throws DaoException {
        Long result = -1L;

        try (Connection con = getConnection();
             PreparedStatement stmt = con.prepareStatement(INSERT_ORDER, new String[]{"student_order_id"})) {

            con.setAutoCommit(false);
            try {
                // Header
                stmt.setInt(1, StudentOrderStatus.START.ordinal());
                stmt.setTimestamp(2, java.sql.Timestamp.valueOf(LocalDateTime.now()));

                // Husband and Wife
                setParamsForAdult(stmt, 3, so.getHusband());
                setParamsForAdult(stmt, 16, so.getWife());

                // Marriage
                stmt.setString(29, so.getMarriageCertificateId());
                stmt.setLong(30, so.getMarriageOffice().getOfficeId());
                stmt.setDate(31, java.sql.Date.valueOf(so.getMarriageDate()));

                stmt.executeUpdate();

                ResultSet gkRs = stmt.getGeneratedKeys();
                if (gkRs.next()) {
                    result = gkRs.getLong(1);
                }
                gkRs.close();

                saveChildren(con, so, result);

                con.commit();

            } catch (SQLException ex) {
                con.rollback();
                throw ex;
            }

        } catch (SQLException ex) {
            throw new DaoException(ex);
        }

        return result;
    }

    private void saveChildren(Connection con, StudentOrder so, Long soID) throws SQLException{
        try(PreparedStatement stmt = con.prepareStatement(INSERT_CHILD)) {
                        for (Child child : so.getChildren()) {
                stmt.setLong(1, soID);
                setParamsForChild(child, stmt);
                stmt.addBatch();
            }
            stmt.executeBatch();
        }
    }

    private void setParamsForAdult(PreparedStatement stmt, int start, Adult adult) throws SQLException {
        setParamsForPerson(stmt, start, adult);
        stmt.setString(start +4, adult.getPassportSeria());
        stmt.setString(start +5, adult.getPassportNumber());
        stmt.setDate(start +6, java.sql.Date.valueOf(adult.getIssueDate()));
        stmt.setLong(start +7, adult.getIssueDepartment().getOfficeId());
        setParamsForAddress(stmt, start + 8, adult);
    }

        private void setParamsForPerson(PreparedStatement stmt, int start, Person adult) throws SQLException {
        stmt.setString(start, adult.getSurName());
        stmt.setString(start +1, adult.getGivenName());
        stmt.setString(start +2, adult.getPatronymic());
        stmt.setDate(start +3, java.sql.Date.valueOf(adult.getDateOfBirth()));
    }

    private void setParamsForAddress(PreparedStatement stmt, int start, Person person) throws SQLException {
        Address adult_address = person.getAddress();
        stmt.setString(start , adult_address.getPostCode());
        stmt.setLong(start +1, adult_address.getStreet().getStreetCode());
        stmt.setString(start +2, adult_address.getBuilding());
        stmt.setString(start +3, adult_address.getExtension());
        stmt.setString(start +4, adult_address.getApartment());
    }

    private void setParamsForChild(Child child, PreparedStatement stmt) throws SQLException {
        setParamsForPerson(stmt,2,child);
        stmt.setString(6, child.getCertificateNumber());
        stmt.setDate(7, java.sql.Date.valueOf(child.getIssueDate()));
        stmt.setLong(8, child.getIssueDepartment().getOfficeId());
        setParamsForAddress(stmt, 9, child);
    }

}
