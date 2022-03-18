package edu.javacourse.studentorder.validator;

import edu.javacourse.studentorder.domain.CityRegisterResponse;
import edu.javacourse.studentorder.domain.Person;
import edu.javacourse.studentorder.exception.CityRegisterExсeption;
import edu.javacourse.studentorder.exception.TransportException;

public interface CityRegisterChecker {
    CityRegisterResponse checkPerson(Person person) throws CityRegisterExсeption, TransportException;
}
