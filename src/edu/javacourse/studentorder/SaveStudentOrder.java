package edu.javacourse.studentorder;

import edu.javacourse.studentorder.dao.DictionaryDAOImpl;
import edu.javacourse.studentorder.dao.StudentOrderDAO;
import edu.javacourse.studentorder.dao.StudentOrderDAOImpl;
import edu.javacourse.studentorder.domain.*;
import edu.javacourse.studentorder.exception.DaoException;

import java.time.LocalDate;
import java.util.List;

public class SaveStudentOrder
{
    public static void main(String[] args) throws Exception{

//        List<Street> d = new DictionaryDAOImpl().findStreets("про");
//        for (Street s : d) {
//            System.out.println(s.getStreetName());
//        }
//        List<PassportOffice> po = new DictionaryDAOImpl().findPassportOffices("010020000000");
//        for (PassportOffice p : po) {
//            System.out.println(p.getOfficeName());
//        }
//        List<RegisterOffice> ro = new DictionaryDAOImpl().findRegisterOffices("010010000000");
//        for (RegisterOffice r : ro) {
//            System.out.println(r.getOfficeName());
//        }

//        List<CountryArea> ca1 = new DictionaryDAOImpl().findAreas("");
//        for (CountryArea c : ca1) {
//            System.out.println(c.getAreaID() + ":" + c.getAreaName());
//        }
//        System.out.println("---->");
//        List<CountryArea> ca2 = new DictionaryDAOImpl().findAreas("020000000000");
//        for (CountryArea c : ca2) {
//            System.out.println(c.getAreaID() + ":" + c.getAreaName());
//        }
//        System.out.println("---->");
//        List<CountryArea> ca3 = new DictionaryDAOImpl().findAreas("020010000000");
//        for (CountryArea c : ca3) {
//            System.out.println(c.getAreaID() + ":" + c.getAreaName());
//        }
//
//        System.out.println("---->");
//        List<CountryArea> ca4 = new DictionaryDAOImpl().findAreas("020010010000");
//        for (CountryArea c : ca4) {
//            System.out.println(c.getAreaID() + ":" + c.getAreaName());
//        }

//        StudentOrder s = buildStudentOrder(10);
          StudentOrderDAO dao = new StudentOrderDAOImpl();
//        Long id = dao.saveStudentOrder(s);
//        System.out.println(id);

         List<StudentOrder> soList = dao.getStudentOrders();
         for(StudentOrder so : soList){
             System.out.println(so.getStudentOrderId());
         }
    }

    static long saveStudentOrder(StudentOrder studentOrder) {
        long answer = 199;
        System.out.println("saveStudentOrder");

        return answer;
    }

    public static StudentOrder buildStudentOrder(long id) {
        StudentOrder so = new StudentOrder();
        so.setStudentOrderId(id);
        so.setMarriageCertificateId("" + (123456000 + id));
        so.setMarriageDate(LocalDate.of(2016, 7, 4));
        RegisterOffice ro = new RegisterOffice(1L,"","");
        so.setMarriageOffice(ro);

        Street street = new Street(1L, "First STREET");

        Address address = new Address("195000", street, "12", "", "142");

        // Муж
        Adult husband = new Adult("Петров", "Виктор", "Сергеевич", LocalDate.of(1997, 8, 24));
        husband.setPassportSeria("" + (1000 + id));
        husband.setPassportNumber("" + (100000 + id));
        husband.setIssueDate(LocalDate.of(2017, 9, 15));
        PassportOffice po1 = new PassportOffice(1L,"","");
        husband.setIssueDepartment(po1);
        husband.setStudentID("" + (100000 + id));
        husband.setAddress(address);
        husband.setUniversity(new University(2l,""));
        husband.setStudentID("HH12345");
        // Жена
        Adult wife = new Adult("Петрова", "Вероника", "Алекссевна", LocalDate.of(1998, 3, 12));
        wife.setPassportSeria("" + (2000 + id));
        wife.setPassportNumber("" + (200000 + id));
        wife.setIssueDate(LocalDate.of(2018, 4, 5));
        PassportOffice po2 = new PassportOffice(2L,"","");
        wife.setIssueDepartment(po2);
        wife.setStudentID("" + (200000 + id));
        wife.setAddress(address);
        wife.setUniversity(new University(1L,""));
        wife.setStudentID("WW12345");

        // Ребенок 1
        Child child1 = new Child("Петрова", "Ирина", "Викторовна", LocalDate.of(2018, 6, 29));
        child1.setCertificateNumber("" + (300000 + id));
        child1.setIssueDate(LocalDate.of(2018, 6, 11));
        RegisterOffice ro2 = new RegisterOffice(2L,"","");
        child1.setIssueDepartment(ro2);
        child1.setAddress(address);

        // Ребенок 2
        Child child2 = new Child("Петрова", "Evgeniy", "Викторовна", LocalDate.of(2018, 6, 29));
        child2.setCertificateNumber("" + (400000 + id));
        child2.setIssueDate(LocalDate.of(2018, 7, 19));
        RegisterOffice ro3 = new RegisterOffice(3L,"","");
        child2.setIssueDepartment(ro3);
        child2.setAddress(address);

        so.setHusband(husband);
        so.setWife(wife);
        so.addChild(child1);
        so.addChild(child2);

        return so;
    }
}