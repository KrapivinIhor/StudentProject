package edu.javacourse.studentorder.domain;

public class Street {
    private Long streetCode;
    private String streetName;

    public Street() {
    }

    public Street(Long streetCOde, String streetName) {
        this.streetCode = streetCOde;
        this.streetName = streetName;
    }

    public Long getStreetCode() {
        return streetCode;
    }

    public void setStreetCode(Long streetCode) {
        this.streetCode = streetCode;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }
}
