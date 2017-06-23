package com.kunalherkal.paperwork.models.dto;

public class Person {
    private String fullName;
    private int age;
    private String gender;
    private String occupation;
    private String phoneNumber;
    private String email;
    private String adhaarCardNumber;
    private String panCardNumber;
    private Address address;

    public Person() {
    }

    public Person(String fullName, int age, String gender, String occupation, String phoneNumber, String email,
                  String adhaarCardNumber, String panCardNumber, Address address) {
        this.fullName = fullName;
        this.age = age;
        this.gender = gender;
        this.occupation = occupation;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.adhaarCardNumber = adhaarCardNumber;
        this.panCardNumber = panCardNumber;
        this.address = address;
    }

    public String getFullName() {
        return fullName;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getOccupation() {
        return occupation;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAdhaarCardNumber() {
        return adhaarCardNumber;
    }

    public String getPanCardNumber() {
        return panCardNumber;
    }

    public Address getAddress() {
        return address;
    }
}
