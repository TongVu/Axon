package com.axonactive.programmingChallenges.Challenges.EmployeeMap;

/**
 * This Program create an EmployeeMap obj which can add Employee objects to the list,
 * and look up employees' ID numbers;
 */
public class EmployeeMapDemo {
    public static void main(String[] args) {
        EmployeeMap empList = new EmployeeMap();

        empList.add(new Employee("244AAATSN","Tong Vu" ));
        empList.add(new Employee( "232AAATSN","John Due"));
        empList.add(new Employee("051AAATSN","Lil Wayne"));

        System.out.println("Is the employee who has the ID 224AAATSN in the list?");
        empList.search("244AAATSN");

        System.out.println("Is the employee who has the ID 220AAATSN in the list?");
        empList.search("220AAATSN");
    }
}
