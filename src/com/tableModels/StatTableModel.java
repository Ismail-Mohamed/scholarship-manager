package com.tableModels;

public class StatTableModel {
    private String entity;
    private int year5;
    private int year4;
    private int year3;
    private int year2;
    private int year1;
    private int total;

    public StatTableModel(String entity, int year5, int year4, int year3, int year2, int year1, int total) {
        this.entity = entity;
        this.year5 = year5;
        this.year4 = year4;
        this.year3 = year3;
        this.year2 = year2;
        this.year1 = year1;
        this.total = total;
    }

    public String getEntity() {
        return entity;
    }

    public void setEntity(String entity) {
        this.entity = entity;
    }

    public int getYear5() {
        return year5;
    }

    public void setYear5(int year5) {
        this.year5 = year5;
    }

    public int getYear4() {
        return year4;
    }

    public void setYear4(int year4) {
        this.year4 = year4;
    }

    public int getYear3() {
        return year3;
    }

    public void setYear3(int year3) {
        this.year3 = year3;
    }

    public int getYear2() {
        return year2;
    }

    public void setYear2(int year2) {
        this.year2 = year2;
    }

    public int getYear1() {
        return year1;
    }

    public void setYear1(int year1) {
        this.year1 = year1;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

}
