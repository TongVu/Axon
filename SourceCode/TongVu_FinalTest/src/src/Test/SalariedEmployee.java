package Test;

public class SalariedEmployee extends Employee{
    private double commissionRate;
    private double grossSales;
    private double basicSalary;

    SalariedEmployee(){
        super();
    }
    SalariedEmployee(String ssn, String firstName, String lastName) {
        super(ssn, firstName, lastName);
    }

    public void setComission(double commissionRate){
        this.commissionRate = commissionRate;
    }
}
