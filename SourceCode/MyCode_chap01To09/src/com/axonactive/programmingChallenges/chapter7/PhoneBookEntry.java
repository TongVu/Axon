package com.axonactive.programmingChallenges.chapter7;

public class PhoneBookEntry {
    private String personName;
    private String phoneNumber;

    public PhoneBookEntry(String name, String phoneNumb){
        this.personName = name;
        this.phoneNumber = phoneNumb;
    }


    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getPersonName() {
        return personName;
    }


}
