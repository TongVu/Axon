package com.axonactive.problems.Payroll;

public class Payroll {
    private String employeeName;
    private String idNumber;
    private double hourlyPayRate;
    private double hoursWorked;

    public Payroll() {
    }

    public Payroll(String name, String id) {
        setEmployeeName(name);
        setIdNumber(id);
    }

    public void setEmployeeName(String employeeName) {
        try {
            if (employeeName.isEmpty()) throw new EmptyNameException();
            this.employeeName = employeeName;
        } catch (EmptyNameException e) {
            e.printStackTrace();
        }
    }

    public void setIdNumber(String idNumber) {
        try {
            if (idNumber.isEmpty()) throw new EmptyIDException();
            this.idNumber = idNumber;
        } catch (EmptyIDException e) {
            e.printStackTrace();
        }
    }

    public void setHourlyPayRate(double hourlyPayRate) {
        try{
            if(hourlyPayRate < 0 ||
                    hourlyPayRate > 25) throw new InvalidPayRateException();
            this.hourlyPayRate = hourlyPayRate;
        } catch(InvalidPayRateException e){
            e.printStackTrace();
        }
    }

    public void setHoursWorked(double hoursWorked) {
        try {
            if (hoursWorked < 0 ||
                    hoursWorked > 84) throw new HoursWorkedException();
                this.hoursWorked = hoursWorked;
        } catch(HoursWorkedException e){
            e.printStackTrace();
        }
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public double getHourlyPayRate() {
        return hourlyPayRate;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }


    public double grossPay() {
        return hoursWorked * hourlyPayRate;
    }

}
