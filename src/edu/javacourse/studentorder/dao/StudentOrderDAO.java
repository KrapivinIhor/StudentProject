package edu.javacourse.studentorder.dao;

import edu.javacourse.studentorder.domain.StudentOrder;
import edu.javacourse.studentorder.exception.DaoException;

import java.util.List;

public interface StudentOrderDAO {
    Long saveStudentOrder(StudentOrder st) throws DaoException;

    List<StudentOrder> getStudentOrders() throws DaoException;
}


