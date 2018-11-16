package com.example.tommy.assignment2;

public class Child {

    public static final Child[] CHILDREN = {
            new Child(1, "a1", "b1", "c1", "d1", "City1", "BC", "V555555", "CANADA", 111, 111, true, "05Sept2018"),
            new Child(2, "a2", "b2", "c2", "d2", "City2", "BC", "V555555", "CANADA", 222, 222, true, "05Sept2028"),
            new Child(3, "a3", "b3", "c3", "d3", "City3", "BC", "V555555", "CANADA", 333, 333, true, "05Sept2038"),
            new Child(4, "a4", "b4", "c4", "d4", "City4", "BC", "V555555", "CANADA", 444, 444, true, "05Sept2048"),
            new Child(5, "a5", "b5", "c5", "d5", "City5", "BC", "V555555", "CANADA", 555, 555, true, "05Sept2058"),
        };

    private int id;
    private String firstName;
    private String lastName;
    private String birthDate;
    private String street;

    public Child(int id, String firstName, String lastName, String birthDate, String street, String city, String province, String postalCode, String country, int latitude, int longitude, boolean isNaughty, String dateCreated) {
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

    private String province;
    private String postalCode;
    private String country;
    private int latitude;
    private int longitude;
    private boolean isNaughty;
    private String dateCreated;

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

    public int getLatitude() {
        return latitude;
    }

    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }

    public int getLongitude() {
        return longitude;
    }

    public void setLongitude(int longitude) {
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
