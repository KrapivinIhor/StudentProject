package edu.javacourse.studentorder.domain;

public class University {
    private Long universityID;
    private String universityName;

    public University() {
    }

    public University(Long universityID, String universityName) {
        this.universityID = universityID;
        this.universityName = universityName;
    }

    public Long getUniversityID() {
        return universityID;
    }

    public void setUniversityID(Long universityID) {
        this.universityID = universityID;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }
}
