package edu.javacourse.studentorder.dao;

import edu.javacourse.studentorder.domain.Street;
import edu.javacourse.studentorder.exception.DaoException;

import java.util.List;

public interface DictionaryDAO {
    List<Street> findStreets(String pattern) throws DaoException;
}
