package com.kunalherkal.paperwork.models.dto;

public class Property {
    private String type;
    private double area;
    private String usage;
    private String buildingName;
    private String number;
    private Address address;

    public Property() {
    }

    public Property(String type, double area, String usage, String buildingName, String number, Address address) {
        this.type = type;
        this.area = area;
        this.usage = usage;
        this.buildingName = buildingName;
        this.number = number;
        this.address = address;
    }

    public String getType() {
        return type;
    }

    public double getArea() {
        return area;
    }

    public String getUsage() {
        return usage;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public String getNumber() {
        return number;
    }

    public Address getAddress() {
        return address;
    }
}
