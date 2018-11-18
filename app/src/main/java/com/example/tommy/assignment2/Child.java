package com.example.tommy.assignment2;

public class Child {

    public static final Child[] CHILDREN = {
            new Child(1, "Tommy", "Yeh", "May 2018", "2222th street", "Vancouver", "BC", "V555555", "CANADA", 11.1, 11.1, false, "05Sept2018"),
            new Child(2, "Job", "Emu", "June 2017", "4444th street", "City2", "BC", "V555555", "CANADA", 222, 222, false, "05Sept2028"),
            new Child(3, "Elon", "Musk", "June 2017", "d3", "City3", "BC", "V555555", "CANADA", 333, 333, true, "05Sept2038"),
            new Child(4, "Micro", "Soft", "June 2017", "d4", "City4", "BC", "V555555", "CANADA", 444, 444, false, "05Sept2048"),
            new Child(5, "Burce", "Lee", "June 2017", "d5", "City5", "BC", "V555555", "CANADA", 555, 555, false, "05Sept2058"),
    };

    private int id;
    private String firstName;
    private String lastName;
    private String birthDate;
    private String street;
    private String province;
    private String postalCode;
    private String country;
    private double latitude;
    private double longitude;
    private boolean isNaughty;
    private String dateCreated;

    public Child(int id, String firstName, String lastName, String birthDate, String street, String city, String province, String postalCode, String country, double latitude, double longitude, boolean isNaughty, String dateCreated) {
        this.id=id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.street = street;
        this.city = city;
        this.province = province;
        this.postalCode = postalCode;
        this.country = country;
        this.latitude = latitude;
        this.longitude = longitude;
        this.isNaughty = isNaughty;
        this.dateCreated = dateCreated;
    }

    private String city;

    @Override
    public String toString() {
        return "Child{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", province='" + province + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", country='" + country + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", isNaughty=" + isNaughty +
                ", dateCreated='" + dateCreated + '\'' +
                '}';
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public boolean getIsNaughty() {
        return isNaughty;
    }

    public void setIsNaughty(boolean naughty) {
        isNaughty = naughty;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
