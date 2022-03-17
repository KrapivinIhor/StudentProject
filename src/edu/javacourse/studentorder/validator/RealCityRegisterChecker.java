package edu.javacourse.studentorder.validator;

import edu.javacourse.studentorder.domain.CityRegisterResponse;
import edu.javacourse.studentorder.domain.Person;
import edu.javacourse.studentorder.exeptiom.CityRegisterExсeption;
import edu.javacourse.studentorder.exeptiom.TransportException;

public class RealCityRegisterChecker implements CityRegisterChecker {
    public CityRegisterResponse checkPerson(Person person)
            throws CityRegisterExсeption, TransportException {
        return null;
    }
}
