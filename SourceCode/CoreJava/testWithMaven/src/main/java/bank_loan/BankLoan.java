package bank_loan;

public class BankLoan {
    private double annualSalary;
    private int yearHasWorked;

    public BankLoan(double annualSalary, int yearHasWorked) {
        this.annualSalary = annualSalary;
        this.yearHasWorked = yearHasWorked;
    }

    public double getAnnualSalary() {
        return annualSalary;
    }

    public void setAnnualSalary(double annualSalary) {
        this.annualSalary = annualSalary;
    }

    public int getYearHasWorked() {
        return yearHasWorked;
    }

    public void setYearHasWorked(int yearHasWorked) {
        this.yearHasWorked = yearHasWorked;
    }

    public boolean isAnnualSalaryValid() {
        return this.annualSalary >= 30000;
    }

    public boolean isYearHasWorkedValid(){
        return this.yearHasWorked >= 2;
    }

    public boolean isCustomerValidToLoan(){
        return isAnnualSalaryValid() && isYearHasWorkedValid();
    }

}
