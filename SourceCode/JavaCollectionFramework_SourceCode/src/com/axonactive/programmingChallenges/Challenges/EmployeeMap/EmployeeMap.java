package com.axonactive.programmingChallenges.Challenges.EmployeeMap;

import java.util.HashMap;
import java.util.Map;

/**
 * This class has Employee objects
 * allows to look them up by their ID numbers
 */
public class EmployeeMap {
    Map<String, Employee> employees;

    public EmployeeMap() {
        employees = new HashMap<>();
    }

    public void add(Employee obj) {
        employees.put(obj.getIdNumber(), obj);
    }

    public void search(String id) {
        Employee tempEmp = employees.get(id);

        if (employees.get(id) != null){
            System.out.println(tempEmp.getName() + " _ " + tempEmp.getIdNumber());
        }else
            System.out.println("NOT FOUNDED");
    }


}
