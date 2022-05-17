package Test;

public class Test {
    public static void main(String[] args) {
        Employee newEmployee = new SalariedEmployee();

        ((SalariedEmployee) newEmployee).setComission(3);
    }
}
