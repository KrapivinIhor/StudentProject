package edu.javacourse.studentorder;

import edu.javacourse.studentorder.domain.*;
import edu.javacourse.studentorder.mail.MailSender;
import edu.javacourse.studentorder.validator.ChildrenRegisterValidator;
import edu.javacourse.studentorder.validator.CityRegisterValidator;
import edu.javacourse.studentorder.validator.StudentRegisterValidator;
import edu.javacourse.studentorder.validator.WeddingRegisterValidator;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class StudentOrderValidator {

    private CityRegisterValidator cityRegisterVal;
    private WeddingRegisterValidator weddingRegisterVal;
    private ChildrenRegisterValidator childrenRegisterVal;
    private StudentRegisterValidator studentRegisterVal;
    private MailSender mailSender;

    public StudentOrderValidator(){
        cityRegisterVal = new CityRegisterValidator();
        weddingRegisterVal = new WeddingRegisterValidator();
        childrenRegisterVal = new ChildrenRegisterValidator();
        studentRegisterVal = new StudentRegisterValidator();
        mailSender = new MailSender();
    }

    public static void main(String[] args) {
       StudentOrderValidator studentOrderValidator = new StudentOrderValidator();
       studentOrderValidator.checkAll();
    }

    public void checkAll(){
            List<StudentOrder> soList = readStudentOrders();
        for (StudentOrder so :soList) {
            checkOneOrder(so);
        }

    }

    public void checkOneOrder(StudentOrder so) {
        AnswerCityRegister cityRegister = checkCityRegister(so);
//        AnswerChildren answerChildren = checkChildren(so);
//        AnswerStudent answerStudent = checkStudent(so);
//        AnswerWedding answerWedding = checkWedding(so);
//          sendMail(so);
    }

    public void sendMail(StudentOrder so) {
        mailSender.sendMail(so);
    }

    public List<StudentOrder> readStudentOrders(){
       List<StudentOrder> soList = new LinkedList<>();
        for (int i = 0; i < 5 ; i++) {
            StudentOrder so = SaveStudentOrder.buildStudentOrder(i);
            soList.add(so);
        }
        return soList;
    }

    public AnswerCityRegister checkCityRegister(StudentOrder studentOrder){
        return cityRegisterVal.checkCityRegister(studentOrder);

    }

    public AnswerWedding checkWedding(StudentOrder studentOrder){
        return weddingRegisterVal.checkWedding(studentOrder);
    }
    
    public AnswerChildren checkChildren(StudentOrder studentOrder){
        return childrenRegisterVal.checkChildren(studentOrder);
    }

    public AnswerStudent checkStudent(StudentOrder studentOrder){
        return studentRegisterVal.checkStudent(studentOrder);
    }
}
