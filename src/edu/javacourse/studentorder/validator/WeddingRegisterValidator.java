package edu.javacourse.studentorder.validator;

import edu.javacourse.studentorder.domain.AnswerWedding;
import edu.javacourse.studentorder.domain.StudentOrder;

public class WeddingRegisterValidator {
     public AnswerWedding checkWedding(StudentOrder studentOrder){
        System.out.println("Wedding is run ");
        return new AnswerWedding();
    }

}
