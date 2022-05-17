package com.axonactive.programmingChallenges.chapter6;

public class Patient {
    private String firstName, middleName, lastName,
            address, city, state, zip,
            phoneNumb,
            nameInEmergency, phoneInEmergency;

    public Patient(String firstName, String middleName, String lastName) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }

    public Patient(String address, String city, String state, String zip) {
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    public Patient(String phone) {
        this.phoneNumb = phone;
    }

    public Patient(String nameInEmergency, String phoneInEmergency) {
        this.nameInEmergency = nameInEmergency;
        this.phoneInEmergency = phoneInEmergency;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public void setPhoneNumb(String phoneNumb) {
        this.phoneNumb = phoneNumb;
    }

    public void setNameInEmergency(String nameInEmergency) {
        this.nameInEmergency = nameInEmergency;
    }

    public void setPhoneInEmergency(String phoneInEmergency) {
        this.phoneInEmergency = phoneInEmergency;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getMiddleName() {
        return this.middleName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getAddress() {
        return this.address;
    }

    public String getCity() {
        return this.city;
    }

    public String getState() {
        return this.state;
    }

    public String getZip() {
        return this.zip;
    }

    public String getPhoneNumb() {
        return this.phoneNumb;
    }

    public String getNameInEmergency() {
        return this.nameInEmergency;
    }

    public String getPhoneInEmergency() {
        return this.phoneInEmergency;
    }
}
