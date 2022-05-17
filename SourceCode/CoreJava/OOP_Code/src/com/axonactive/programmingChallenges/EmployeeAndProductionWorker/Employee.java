package com.axonactive.programmingChallenges.EmployeeAndProductionWorker;

/*
/Employee

/Fields:
    -Employee name : String
    -Employee number (format XXX-L) : String
        :_ X is a digit within the range 0-9
        :_ L is a letter within the range A-M
    -Hire date : String

/Methods:
    +<<abstract>>getInfo(): void

 */

public abstract class Employee {
    private String name;
    private String employeeNumber;
    private String hireDate;

    public Employee() {
    }

    ;

    public Employee(String name, String empNumb, String hireDate) {
        setName(name);
        setEmployeeNumber(empNumb);
        this.hireDate = hireDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(String employeeNumber) {
        String errMsg =
                "\nName is formated as: XXX-L" +
                        "\nX is number in rang 0-9" +
                        "\nL is a letter in range A-M";

        if (employeeNumber.length() != 5) throw new IllegalArgumentException(errMsg);
        else {
            for (int i = 0; i < 3; i++) {
                if (!Character.isDigit(employeeNumber.charAt(i)))
                    throw new IllegalArgumentException(errMsg);
            }

            if (employeeNumber.charAt(3) != '-') throw new IllegalArgumentException(errMsg);

            if (employeeNumber.charAt(4) < 'A' ||
                    employeeNumber.charAt(4) > 'M')
                throw new IllegalArgumentException(errMsg);
        }
        this.employeeNumber = employeeNumber;
    }

    public String getHireDate() {
        return hireDate;
    }

    public void setHireDate(String hireDate) {
        this.hireDate = hireDate;
    }

    public abstract void getInfo();
}

