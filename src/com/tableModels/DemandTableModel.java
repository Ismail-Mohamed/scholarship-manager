package com.tableModels;

public class DemandTableModel {
    private String id;
    private String fullNameFr;
    private String grade;
    private String beginDate;
    private String hostCountry;
    private String faculty;
    private String financialYear;

    public DemandTableModel(String id, String fullNameFr, String grade, String beginDate, String hostCountry, String faculty, String financialYear) {
        this.id = id;
        this.fullNameFr = fullNameFr;
        this.grade = grade;
        this.beginDate = beginDate;
        this.hostCountry = hostCountry;
        this.faculty = faculty;
        this.financialYear = financialYear;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullNameFr() {
        return fullNameFr;
    }

    public void setFullNameFr(String fullNameFr) {
        this.fullNameFr = fullNameFr;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    public String getHostCountry() {
        return hostCountry;
    }

    public void setHostCountry(String hostCountry) {
        this.hostCountry = hostCountry;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getFinancialYear() {
        return financialYear;
    }

    public void setFinancialYear(String financialYear) {
        this.financialYear = financialYear;
    }
}