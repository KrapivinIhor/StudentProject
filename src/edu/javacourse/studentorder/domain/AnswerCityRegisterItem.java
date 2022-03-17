package edu.javacourse.studentorder.domain;

public class AnswerCityRegisterItem {
    private Person person;
    private CityStatus status;
    private CityError error;

    public enum CityStatus {
       YES, NO, ERROR;
    }

    public static class CityError{
        private String code;
        private String test;

        public CityError(String code, String test) {
            this.code = code;
            this.test = test;
        }

        public String getCode() {
            return code;
        }

        public String getTest() {
            return test;
        }
    }

    public Person getPerson() {
        return person;
    }

    public CityStatus getStatus() {
        return status;
    }

    public CityError getError() {
        return error;
    }

    public AnswerCityRegisterItem(Person person, CityStatus status, CityError error) {
        this.person = person;
        this.status = status;
        this.error = error;
    }

    public AnswerCityRegisterItem(Person person, CityStatus status) {
        this.person = person;
        this.status = status;
    }
}
