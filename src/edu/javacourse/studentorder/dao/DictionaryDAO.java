package edu.javacourse.studentorder.dao;

import edu.javacourse.studentorder.domain.CountryArea;
import edu.javacourse.studentorder.domain.PassportOffice;
import edu.javacourse.studentorder.domain.RegisterOffice;
import edu.javacourse.studentorder.domain.Street;
import edu.javacourse.studentorder.exception.DaoException;

import java.sql.SQLException;
import java.util.List;

public interface DictionaryDAO {
    List<Street> findStreets(String pattern) throws DaoException;
    List<PassportOffice> findPassportOffices(String areaID) throws DaoException;
    List<RegisterOffice> findRegisterOffices(String areaID) throws DaoException;
    List<CountryArea> findAreas(String areaID) throws DaoException;
}
