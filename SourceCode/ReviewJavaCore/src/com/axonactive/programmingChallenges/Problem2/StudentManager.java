package com.axonactive.programmingChallenges.Problem2;

import java.util.*;

public class StudentManager {
    Map<String, Student> list = new TreeMap<>();

    /*
        Calling default constructor from StudentManager to get rid of the arduous input
     */
    StudentManager() {
        Student student1 = new Student("12341", "Tong", "Vu", "24/04/1995", 2014),
                student2 = new Student("12356", "Nguyen", "Anh", "03/05/2002", 2013),
                student3 = new Student("29475", "Nguyen", "Dinh", "03/05/2002", 2019),
                student4 = new Student("19847", "Nguyen", "Nhan", "01/06/2001", 2021);
        list.put(student1.getId(), student1);
        list.put(student2.getId(), student2);
        list.put(student3.getId(), student3);
        list.put(student4.getId(), student4);
    }

    public void start() {
        int choice = 0;
        Scanner input = new Scanner(System.in);

        do {
            System.out.print("1. Add student\n" +
                    "2. Sorted list\n" +
                    "3. Search Student by ID \n" +
                    "4. Show list from 2019 to 2021\n" +
                    "5. Exit\n" +
                    "Enter your choice: "
            );
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    add();
                    break;
                case 2:
                    sortedStudentsList();
                    break;
                case 3:
                    searchID();
                    break;
                case 4:
                    searchYear();
                    break;
                case 5:
                    System.out.println("EXIT");
            }
        } while (choice >= 1 && choice < 5);
    }

    public void add() {
        Scanner input = new Scanner(System.in);
        Student newStudent = new Student();

        System.out.print("First name: ");
        newStudent.setFirstName(input.nextLine());

        System.out.print("Last name: ");
        newStudent.setLastName(input.nextLine());

        System.out.print("ID: ");
        newStudent.setId(input.nextLine());

        System.out.print("DOB: ");
        newStudent.setDob(input.nextLine());

        System.out.print("Year enrolled: ");
        newStudent.setYear(input.nextInt());
        list.put(newStudent.getId(), newStudent);
    }

    public void sortedStudentsList() {
        TreeMap<Integer, Student> newList = new TreeMap<>();
        list.forEach((k,v)->{
            newList.put(v.getYear(), v);
        });
        System.out.println("SORTED STUDENT LIST ==============================");
        newList.forEach((k, v) -> {
            System.out.println(v.toString());
        });
    }

    public void searchID() {
        Scanner input = new Scanner(System.in);
        String usrId; // holds usr input id to search

        System.out.print("Enter student ID to search: ");
        usrId = input.nextLine();

        if (list.containsKey(usrId)) {
            System.out.println(list.get(usrId));
        } else System.out.println("NOT FOUNDED");
    }

    public void searchYear() {
        System.out.println("STUDENT LIST IN 2019-2021 =========================");

        list.forEach((k, v) -> {
            if (v.getYear() <= 2021 &&
                    v.getYear() >= 2019) System.out.println(v.toString());
        });
    }

}
