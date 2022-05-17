package com.axonactive.programmingChallenges.chapter6;

public class Employee {
        private String name;
        private int idNumber;
        private String department;
        private String position;

        public Employee(String empName, int empIdNumber, String empDepartment, String empPosition) {
            name = empName;
            idNumber = empIdNumber;
            department = empDepartment;
            position = empPosition;
        }
        public Employee(String empName, int empIdNumber) {
            name = empName;
            idNumber = empIdNumber;
        }
        public Employee(){ }


        public void setName(String empName){
            name = empName;
        }
        public void setIdNumber(int empIdNumber){
            idNumber = empIdNumber;
        }
        public void setDepartment(String empDepartment){
            department = empDepartment;
        }
        public void setPosition(String empPosition){
            position = empPosition;
        }

        public String getName(){
            return name;
        }
        public int getIdNumber(){
            return idNumber;
        }
        public String getDepartment(){
            return department;
        }
        public String getPosition(){
            return position;
        }

    public static void main(String[] args) {
        Employee person1, person2, person3;

        person1 = new Employee("Susan Meyers", 47899, "Accounting", "Vice President");
        person2 = new Employee("Mark Jones", 39119, "IT", "Programming");
        person3 = new Employee("Joy Rogers", 81774, "Manufacturing", "Engineer");

        // Person 1
        System.out.println("====================== Person 1 =======================");
        System.out.println( person1.getName() );
        System.out.println( person1.getIdNumber() );
        System.out.println( person1.getDepartment() );
        System.out.println( person1.getPosition() );

        // Person2
        System.out.println("====================== Person 2 =======================");
        System.out.println( person2.getName() );
        System.out.println( person2.getIdNumber() );
        System.out.println( person2.getDepartment() );
        System.out.println( person2.getPosition() );

        // Person3
        System.out.println("====================== Person 3 =======================");
        System.out.println( person3.getName() );
        System.out.println( person3.getIdNumber() );
        System.out.println( person3.getDepartment() );
        System.out.println( person3.getPosition() );
    }
}
