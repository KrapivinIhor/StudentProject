package edu.javacourse.studentorder.validator;

import edu.javacourse.studentorder.domain.CityRegisterResponse;
import edu.javacourse.studentorder.domain.Person;
import edu.javacourse.studentorder.exeptiom.CityRegisterExсeption;
import edu.javacourse.studentorder.exeptiom.TransportException;

public interface CityRegisterChecker {
    CityRegisterResponse checkPerson(Person person) throws CityRegisterExсeption, TransportException;
}
