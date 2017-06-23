package com.kunalherkal.paperwork.models.dto;


public class Address {
    private String line1;
    private String line2;
    private String city;
    private String state;
    private String pincode;

    public Address() {
    }

    public Address(String line1, String line2, String city, String state, String pincode) {
        this.line1 = line1;
        this.line2 = line2;
        this.city = city;
        this.state = state;
        this.pincode = pincode;
    }

    public String getLine1() {
        return line1;
    }

    public String getLine2() {
        return line2;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getPincode() {
        return pincode;
    }
}
