package com.axonactive.programmingChallenges.Challenges.EmployeeMap;

/**
 * This class stores employee's number and name
 */
public class Employee {
    private String idNumber; // stores emloyee's ID number
    private String name; // stores employee's name

    public Employee(String idNumber, String name) {
        this.idNumber = idNumber;
        this.name = name;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
