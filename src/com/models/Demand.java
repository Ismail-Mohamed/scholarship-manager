package com.models;

public class Demand {
    private int id;
    private String firstName;
    private String firstNameAr;
    private String lastName;
    private String lastNameAr;
    private String gender;
    private String dob;//date of birth
    private String dobLocation;
    private String scholarshipBeginDate;
    private String scholarshipEndDate;
    private String address;
    private String email;
    private String phoneNumberOne;
    private String phoneNumberTow;
    private String scholarshipCountry;
    private String scholarshipLaboratory;
    private String domain;
    private String scholarshipType;
    private String scholarshipAmount;//TODO: chek typography of this word
    private String ticketPrice;
    private String faculty;//TODO: chek typography of this word
    private String year;
    private String department;
    private boolean acknowledgement;

    public Demand(int id, String firstName, String firstNameAr, String lastName, String lastNameAr, String gender, String dob, String dobLocation, String scholarshipBeginDate, String scholarshipEndDate, String address, String email, String phoneNumberOne, String phoneNumberTow, String scholarshipCountry, String scholarshipLaboratory, String domain, String scholarshipType, String scholarshipAmount, String ticketPrice, String faculty, String year, String department, boolean acknowledgement) {
        this.id = id;
        this.firstName = firstName;
        this.firstNameAr = firstNameAr;
        this.lastName = lastName;
        this.lastNameAr = lastNameAr;
        this.gender = gender;
        this.dob = dob;
        this.dobLocation = dobLocation;
        this.scholarshipBeginDate = scholarshipBeginDate;
        this.scholarshipEndDate = scholarshipEndDate;
        this.address = address;
        this.email = email;
        this.phoneNumberOne = phoneNumberOne;
        this.phoneNumberTow = phoneNumberTow;
        this.scholarshipCountry = scholarshipCountry;
        this.scholarshipLaboratory = scholarshipLaboratory;
        this.domain = domain;
        this.scholarshipType = scholarshipType;
        this.scholarshipAmount = scholarshipAmount;
        this.ticketPrice = ticketPrice;
        this.faculty = faculty;
        this.year = year;
        this.department = department;
        this.acknowledgement = acknowledgement;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstNameAr() {
        return firstNameAr;
    }

    public void setFirstNameAr(String firstNameAr) {
        this.firstNameAr = firstNameAr;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastNameAr() {
        return lastNameAr;
    }

    public void setLastNameAr(String lastNameAr) {
        this.lastNameAr = lastNameAr;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getDobLocation() {
        return dobLocation;
    }

    public void setDobLocation(String dobLocation) {
        this.dobLocation = dobLocation;
    }

    public String getScholarshipBeginDate() {
        return scholarshipBeginDate;
    }

    public void setScholarshipBeginDate(String scholarshipBeginDate) {
        this.scholarshipBeginDate = scholarshipBeginDate;
    }

    public String getScholarshipEndDate() {
        return scholarshipEndDate;
    }

    public void setScholarshipEndDate(String scholarshipEndDate) {
        this.scholarshipEndDate = scholarshipEndDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumberOne() {
        return phoneNumberOne;
    }

    public void setPhoneNumberOne(String phoneNumberOne) {
        this.phoneNumberOne = phoneNumberOne;
    }

    public String getPhoneNumberTow() {
        return phoneNumberTow;
    }

    public void setPhoneNumberTow(String phoneNumberTow) {
        this.phoneNumberTow = phoneNumberTow;
    }

    public String getScholarshipCountry() {
        return scholarshipCountry;
    }

    public void setScholarshipCountry(String scholarshipCountry) {
        this.scholarshipCountry = scholarshipCountry;
    }

    public String getScholarshipLaboratory() {
        return scholarshipLaboratory;
    }

    public void setScholarshipLaboratory(String scholarshipLaboratory) {
        this.scholarshipLaboratory = scholarshipLaboratory;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getScholarshipType() {
        return scholarshipType;
    }

    public void setScholarshipType(String scholarshipType) {
        this.scholarshipType = scholarshipType;
    }

    public String getScholarshipAmount() {
        return scholarshipAmount;
    }

    public void setScholarshipAmount(String scholarshipAmount) {
        this.scholarshipAmount = scholarshipAmount;
    }

    public String getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(String ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public boolean isAcknowledgement() {
        return acknowledgement;
    }

    public void setAcknowledgement(boolean acknowledgement) {
        this.acknowledgement = acknowledgement;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
