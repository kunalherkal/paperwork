package com.kunalherkal.paperwork.models.dto;

import java.util.List;

public class RentAgreement {
    private String executionDate;
    private String executionCity;
    private int duration;
    private String startingFrom;
    private int deposit;
    private int rent;
    private int lockInPeriod;
    private List<Person> owners;
    private List<Person> tenants;
    private List<Person> witnesses;
    private Property property;

    public RentAgreement(){

    }

    public RentAgreement(String executionDate, String executionCity, int duration, String startingFrom,
                         int deposit, int rent, int lockInPeriod, List<Person> owners, List<Person> tenants,
                         List<Person> witnesses, Property property) {
        this.executionDate = executionDate;
        this.executionCity = executionCity;
        this.duration = duration;
        this.startingFrom = startingFrom;
        this.deposit = deposit;
        this.rent = rent;
        this.lockInPeriod = lockInPeriod;
        this.owners = owners;
        this.tenants = tenants;
        this.witnesses = witnesses;
        this.property = property;
    }

    public String getExecutionDate() {
        return executionDate;
    }

    public String getExecutionCity() {
        return executionCity;
    }

    public int getDuration() {
        return duration;
    }

    public String getStartingFrom() {
        return startingFrom;
    }

    public int getDeposit() {
        return deposit;
    }

    public int getRent() {
        return rent;
    }

    public int getLockInPeriod() {
        return lockInPeriod;
    }

    public List<Person> getOwners() {
        return owners;
    }

    public List<Person> getTenants() {
        return tenants;
    }

    public List<Person> getWitnesses() {
        return witnesses;
    }

    public Property getProperty() {
        return property;
    }

    @Override
    public String toString() {
        return "RentAgreement{" +
                "executionDate='" + executionDate + '\'' +
                ", executionCity='" + executionCity + '\'' +
                ", duration=" + duration +
                ", startingFrom='" + startingFrom + '\'' +
                ", deposit=" + deposit +
                ", rent=" + rent +
                ", lockInPeriod=" + lockInPeriod +
                ", owners=" + owners +
                ", tenants=" + tenants +
                ", witnesses=" + witnesses +
                ", property=" + property +
                '}';
    }
}
