package com.axonactive.programmingChallenges.EmployeeAndProductionWorker;

public class EmployeeAndProductionWorkerDemo {
    public static void main(String[] args) {
        ProductionWorker emp = new ProductionWorker("Tong Vu", "244-D", "01 Apr 2022");
        emp.setPayRate(95.5);
        emp.setShift(2);

        emp.getInfo();
    }
}

