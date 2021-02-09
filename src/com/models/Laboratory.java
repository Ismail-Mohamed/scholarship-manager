package com.models;

public class Laboratory {
    private String id;
    private String name;
    private String region;
    private String country;
    private String town;
    private String city;
    private String zipCode;
    private String address;
    private String phone;
    private String email;
    private String website;

    public Laboratory(String id, String name, String region, String country, String town, String city, String zipCode, String address, String phone, String email, String website) {
        this.id = id;
        this.name = name;
        this.region = region;
        this.country = country;
        this.town = town;
        this.city = city;
        this.zipCode = zipCode;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.website = website;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getTow() {
        return town;
    }

    public void setTow(String town) {
        this.town = town;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

