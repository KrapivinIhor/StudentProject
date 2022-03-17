package edu.javacourse.studentorder.validator;

import edu.javacourse.studentorder.domain.*;
import edu.javacourse.studentorder.exeptiom.CityRegisterExсeption;
import edu.javacourse.studentorder.exeptiom.TransportException;

import java.util.List;

public class CityRegisterValidator {
    public static final String IN_CODE = "NO_GRN";
    private CityRegisterChecker personChecker;

    public CityRegisterValidator() {
        personChecker = new FakeCityRegisterChecker();
    }

    public AnswerCityRegister checkCityRegister(StudentOrder studentOrder) {
        AnswerCityRegister ans = new AnswerCityRegister();

        ans.addItem(checkPerson(studentOrder.getHusband()));
        ans.addItem(checkPerson(studentOrder.getWife()));
            for (Child c : studentOrder.getChildren()) {
                ans.addItem(checkPerson(c));
            }

        return ans;
    }

    private AnswerCityRegisterItem checkPerson(Person person){
        AnswerCityRegisterItem.CityStatus status = null;
        AnswerCityRegisterItem.CityError error = null;

        try {
           CityRegisterResponse tmp = personChecker.checkPerson(person);
           status = tmp.isExisting() ?
                    AnswerCityRegisterItem.CityStatus.YES :
                    AnswerCityRegisterItem.CityStatus.NO;
        } catch (CityRegisterExсeption ex){
            ex.printStackTrace(System.out);
            status = AnswerCityRegisterItem.CityStatus.ERROR;
            error = new AnswerCityRegisterItem.CityError(ex.getCode(), ex.getMessage());
        } catch (TransportException ex){
            ex.printStackTrace(System.out);
            status = AnswerCityRegisterItem.CityStatus.ERROR;
            error = new AnswerCityRegisterItem.CityError(IN_CODE, ex.getMessage());
        } catch (Exception ex){
            ex.printStackTrace(System.out);
            status = AnswerCityRegisterItem.CityStatus.ERROR;
            error = new AnswerCityRegisterItem.CityError(IN_CODE, ex.getMessage());
        }
        AnswerCityRegisterItem ans = new AnswerCityRegisterItem(person, status, error);
        return ans;
    }
}
