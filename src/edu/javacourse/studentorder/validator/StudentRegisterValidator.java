package edu.javacourse.studentorder.validator;

import edu.javacourse.studentorder.domain.AnswerStudent;
import edu.javacourse.studentorder.domain.StudentOrder;

public class StudentRegisterValidator {
    String candidateName;
    String candidateLastName;
    String candidateAge;

    public AnswerStudent checkStudent(StudentOrder studentOrder){
        System.out.println("Students are running:"
                + candidateName + "," + candidateLastName + "," + candidateAge) ;
        return new AnswerStudent();
    }
}
