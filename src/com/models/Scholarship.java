package com.models;

public class Scholarship {
    String startingDate;
    String endingDate;
    String scientificDomain;
    String supervisor;
    String supervisorDegree;
    String minPrice;
    String maxDateResponse;

    public Scholarship(String startingDate, String endingDate, String scientificDomain, String supervisor, String supervisorDegree, String minPrice, String maxDateResponse) {
        this.startingDate = startingDate;
        this.endingDate = endingDate;
        this.scientificDomain = scientificDomain;
        this.supervisor = supervisor;
        this.supervisorDegree = supervisorDegree;
        this.minPrice = minPrice;
        this.maxDateResponse = maxDateResponse;
    }

    public String getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(String startingDate) {
        this.startingDate = startingDate;
    }

    public String getEndingDate() {
        return endingDate;
    }

    public void setEndingDate(String endingDate) {
        this.endingDate = endingDate;
    }

    public String getScientificDomain() {
        return scientificDomain;
    }

    public void setScientificDomain(String scientificDomain) {
        this.scientificDomain = scientificDomain;
    }

    public String getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }

    public String getSupervisorDegree() {
        return supervisorDegree;
    }

    public void setSupervisorDegree(String supervisorDegree) {
        this.supervisorDegree = supervisorDegree;
    }

    public String getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(String minPrice) {
        this.minPrice = minPrice;
    }

    public String getMaxDateResponse() {
        return maxDateResponse;
    }

    public void setMaxDateResponse(String maxDateResponse) {
        this.maxDateResponse = maxDateResponse;
    }
}
