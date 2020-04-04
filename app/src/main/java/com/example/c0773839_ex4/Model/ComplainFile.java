package com.example.c0773839_ex4.Model;

import java.io.Serializable;

public class ComplainFile implements Serializable {

    private String suffix;
    private String firstName;
    private String lastName;
    private String employementType;
    private String designation;
    private String unitNo;
    private String streetNo;
    private String streetName;
    private String city,province,country,postalCode,email,countryCode,phoneNumber,issueDate,issueType,description;
    private Float sevRating;

    public ComplainFile(String suffix, String firstName, String lastName, String employementType, String designation, String unitNo, String streetNo, String streetName, String city, String province, String country, String postalCode, String email, String countryCode, String phoneNumber, String issueDate, String issueType, String description, Float sevRating) {
        this.suffix = suffix;
        this.firstName = firstName;
        this.lastName = lastName;
        this.employementType = employementType;
        this.designation = designation;
        this.unitNo = unitNo;
        this.streetNo = streetNo;
        this.streetName = streetName;
        this.city = city;
        this.province = province;
        this.country = country;
        this.postalCode = postalCode;
        this.email = email;
        this.countryCode = countryCode;
        this.phoneNumber = phoneNumber;
        this.issueDate = issueDate;
        this.issueType = issueType;
        this.description = description;
        this.sevRating = sevRating;
    }

    public  ComplainFile(){

    }

    public String getSuffix() {
        return suffix;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmployementType() {
        return employementType;
    }

    public String getDesignation() {
        return designation;
    }

    public String getUnitNo() {
        return unitNo;
    }

    public String getStreetNo() {
        return streetNo;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getCity() {
        return city;
    }

    public String getProvince() {
        return province;
    }

    public String getCountry() {
        return country;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getEmail() {
        return email;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public String getIssueType() {
        return issueType;
    }

    public String getDescription() {
        return description;
    }

    public Float getSevRating() {
        return sevRating;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmployementType(String employementType) {
        this.employementType = employementType;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public void setUnitNo(String unitNo) {
        this.unitNo = unitNo;
    }

    public void setStreetNo(String streetNo) {
        this.streetNo = streetNo;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

    public void setIssueType(String issueType) {
        this.issueType = issueType;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setSevRating(Float sevRating) {
        this.sevRating = sevRating;
    }
}
