package problem9;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SoftwareHouse {
    private String theName;
    private Set<Employee> employeeSet = new HashSet<>();

    public boolean addEmployee(Employee employee) {
        for (Employee emp : employeeSet)
            if (emp.equals(employee)) {
                employeeSet.add(employee);
                return true;
            }

        return false;
    }

    public boolean addEmployee() {
        int choice;
        Employee newEmployee = null;
        Scanner input = new Scanner(System.in);

        System.out.println("Choose employee type");
        System.out.println("1. Programmer");
        System.out.println("2. Project Leader");
        System.out.println("3. Administrator");
        choice = input.nextInt();

        if (choice < 1 || choice > 3) return false;

        if (choice == 1) // create Programmer
            newEmployee = createProgrammer();

        if (choice == 2) // create Project Leader
            newEmployee = createProjectLeader();

        if (choice == 3) // create administrator
            newEmployee = createAdministrator();

        employeeSet.add(newEmployee);
        return true;
    }

    private Programmer createProgrammer() {
        Scanner input = new Scanner(System.in);
        Programmer newProgrammer = new Programmer();

        System.out.print("Enter payroll number: ");
        newProgrammer.setPayrollNumber(input.nextInt());

        System.out.print("Enter programmer's name: ");
        newProgrammer.setName(input.nextLine());

        System.out.print("Enter basic monthly salary: ");
        newProgrammer.setTheBasicMonthlySalary(input.nextDouble());

        System.out.println("Enter programming language: ");
        newProgrammer.setTheLanguage(input.nextLine());

        return newProgrammer;
    }

    private Administrator createAdministrator() {
        Scanner input = new Scanner(System.in);
        Administrator newAdministrator = new Administrator();

        System.out.print("Enter payroll number: ");
        newAdministrator.setPayrollNumber(input.nextInt());

        System.out.print("Enter administrator's name: ");
        newAdministrator.setName(input.nextLine());

        System.out.print("Enter basic monthly salary: ");
        newAdministrator.setTheBasicMonthlySalary(input.nextDouble());

        System.out.println("Enter department of the administrator: ");
        newAdministrator.setDepartment(input.nextLine());

        return newAdministrator;
    }

    private ProjectLeader createProjectLeader() {
        Scanner input = new Scanner(System.in);
        ProjectLeader newProjectLeader = new ProjectLeader();

        System.out.print("Enter payroll number: ");
        newProjectLeader.setPayrollNumber(input.nextInt());

        System.out.print("Enter project leader's name: ");
        newProjectLeader.setName(input.nextLine());

        System.out.print("Enter basic monthly salary: ");
        newProjectLeader.setTheBasicMonthlySalary(input.nextDouble());

        System.out.println("Enter programming language: ");
        newProjectLeader.setTheLanguage(input.nextLine());

        return newProjectLeader;
    }

    public void displayAllStaff() {
        for (Employee emp : employeeSet)
            System.out.println(emp);
    }

    public double getMonthlySalaryBill() {
        double totalSalary = 0;
        for (Employee emp : employeeSet)
            totalSalary += emp.getMonthlySalary();

        return totalSalary;
    }

    public void sortAllStaffByName() {
        List<Employee> sortedList = new ArrayList<>(employeeSet);

        Collections.sort(sortedList);
        for (Employee emp : sortedList)
            System.out.println(emp);
    }

    public void displayListProgrammers() {
        for (Employee emp : employeeSet)
            if (emp instanceof Programmer)
                System.out.println(emp);
    }

    //Update Department For Admin

    public boolean deleteEmployee() {
        int id;
        Scanner input = new Scanner(System.in);

        System.out.print("Enter employee's id: ");
        id = input.nextInt();

        for (Employee emp : employeeSet) {
            if (emp.getPayrollNumber() == id) {
                employeeSet.remove(emp);
                return true;
            }
        }

        return false;
    }

    public void menu() {
        int choice = 0;
        Scanner input = new Scanner(System.in);

        do {
            System.out.println("1. Add employee");
            System.out.println("2. Display all staffs");
            System.out.println("3. Get monthly salary bill");
            System.out.println("4. Sort all staff by name");
            System.out.println("5. Display list programmers");
            System.out.println("6. ");
            System.out.println("7. Delete employee by id");
            System.out.print("Choice: ");

            choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1 -> addEmployee();
                case 2 -> displayAllStaff();
                case 3 -> getMonthlySalaryBill();
                case 4 -> sortAllStaffByName();
                case 5 -> displayListProgrammers();
                case 6 -> System.out.println("Haven't done");
                default -> deleteEmployee();
            }
        } while (choice > 0 && choice < 6);

        if (choice == 6) System.out.println("EXIT");
    }
}
