package edu.javacourse.studentorder.domain;

public class Street {
    private Long streetCOde;
    private String streetName;

    public Street() {
    }

    public Street(Long streetCOde, String streetName) {
        this.streetCOde = streetCOde;
        this.streetName = streetName;
    }

    public Long getStreetCOde() {
        return streetCOde;
    }

    public void setStreetCOde(Long streetCOde) {
        this.streetCOde = streetCOde;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }
}
