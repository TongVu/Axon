package Problem3;

import java.util.*;

/**
 * This program let usr
 * input a list of employee and which department they are belonged to -> then add them to those deparment
 * show employees list individually
 * search employee by their name, show detail of their information
 * statistic: show all departments and number of employees each department has.
 * calculate the salary that have to pay to all employees, and average employee salary;
 */
public class DepartmentManage {
    List<Employee> employeesList = new ArrayList<>();
    HashMap<String, Department> departmentList = new HashMap<>();

    public DepartmentManage() {
    }

    public void addEmployee() {
        Scanner input = new Scanner(System.in);
        int choice;
        Employee newEmployee = null;

        /*
            Create employee based on their choice
         */
        System.out.print("Is the employee a Salaried Employee(1) or Hourly Employee (2)? (1/2) : ");
        choice = input.nextInt();
        if (choice == 1) {
            newEmployee = new SalariedEmployee();
        } else if (choice == 2) {
            newEmployee = new HourlyEmployee();
        } else System.out.print("Maybe you've type the wrong one");


        /*
            Set basic information for the employee
         */
        if (choice == 1 || choice == 2) {
            input.nextLine();
            System.out.print("Employee's SSN: ");
            newEmployee.setSsn(input.nextLine());

            System.out.print("Employee first name: ");
            newEmployee.setFirstName(input.nextLine());

            System.out.print("Employee last name: ");
            newEmployee.setLastName(input.nextLine());

            System.out.print("Employee birthday (dd/mm/yyyy): ");
            newEmployee.setBirthDay(input.nextLine());

            System.out.print("Employee phone: ");
            newEmployee.setPhone(input.nextLine());

            System.out.print("Employee email: ");
            newEmployee.setEmail(input.nextLine());
        }
       /*
             in case the employee is a Salaried Employee -> set commission, gross sales, salary to their fields
        */
        if (choice == 1) {
            System.out.print("Comission rate: ");
            ((SalariedEmployee) newEmployee).setCommissionRate(input.nextDouble());

            System.out.print("Gross sales: ");
            ((SalariedEmployee) newEmployee).setGrossSales(input.nextDouble());

            System.out.print("Basic salary: ");
            ((SalariedEmployee) newEmployee).setBasicSalary(input.nextDouble());

            System.out.print("How many department are you belonged to: ");
            int depsNumber = input.nextInt();

            for (int i = 0; i < depsNumber; i++) {
                Department dep = new Department();

                System.out.print("Department name: ");
                dep.setDepartmentName(input.nextLine());
                dep.addEmployee(newEmployee);
                departmentList.put(dep.getDepartmentName(), dep);
            }
        }

       /*
             in case the employee is a Hourly Employee-> set wage and working hours to their fields
        */
        if (choice == 2) {
            System.out.print("Wage: ");
            ((HourlyEmployee) newEmployee).setWage(input.nextDouble());

            System.out.print("Working hour: ");
            ((HourlyEmployee) newEmployee).setWorkingHours(input.nextDouble());

            System.out.print("How many department are you belonged to: ");
            int depsNumber = input.nextInt();

        }
       /*
            add employees to the list
        */
        employeesList.add(newEmployee);
    }

    public void main() {
    }
}
