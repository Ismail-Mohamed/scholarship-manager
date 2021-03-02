package com.models;

public class Demand {
    private String id;
    private String beneficiary;
    private String fullNameAr;
    private String fullNameFr;
    private String dob;
    private String gender;
    private String grade;
    private long duration;
    private String beginDate;
    private String endDate;
    private String hostCountry;
    private String hostLaboratory;
    private String domain;
    private String scholarshipType;
    private String budget;
    private String ticketPrice;
    private String financialYear;
    private String faculty;

    public Demand(String id, String beneficiary, String fullNameAr, String fullNameFr, String dob, String gender, String grade, long duration, String beginDate, String endDate, String hostCountry, String hostLaboratory, String domain, String scholarshipType, String budget, String ticketPrice, String financialYear, String faculty) {
        this.id = id;
        this.beneficiary = beneficiary;
        this.fullNameAr = fullNameAr;
        this.fullNameFr = fullNameFr;
        this.dob = dob;
        this.gender = gender;
        this.grade = grade;
        this.duration = duration;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.hostCountry = hostCountry;
        this.hostLaboratory = hostLaboratory;
        this.domain = domain;
        this.scholarshipType = scholarshipType;
        this.budget = budget;
        this.ticketPrice = ticketPrice;
        this.financialYear = financialYear;
        this.faculty = faculty;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBeneficiary() {
        return beneficiary;
    }

    public void setBeneficiary(String beneficiary) {
        this.beneficiary = beneficiary;
    }

    public String getFullNameAr() {
        return fullNameAr;
    }

    public void setFullNameAr(String fullNameAr) {
        this.fullNameAr = fullNameAr;
    }

    public String getFullNameFr() {
        return fullNameFr;
    }

    public void setFullNameFr(String fullNameFr) {
        this.fullNameFr = fullNameFr;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public String getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getHostCountry() {
        return hostCountry;
    }

    public void setHostCountry(String hostCountry) {
        this.hostCountry = hostCountry;
    }

    public String getHostLaboratory() {
        return hostLaboratory;
    }

    public void setHostLaboratory(String hostLaboratory) {
        this.hostLaboratory = hostLaboratory;
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

    public String getBudget() {
        return budget;
    }

    public void setBudget(String budget) {
        this.budget = budget;
    }

    public String getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(String ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public String getFinancialYear() {
        return financialYear;
    }

    public void setFinancialYear(String financialYear) {
        this.financialYear = financialYear;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }
}
