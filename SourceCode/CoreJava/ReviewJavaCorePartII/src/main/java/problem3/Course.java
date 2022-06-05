package problem3;


import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Course {
    private List<Student> students = new ArrayList<>();
    private String courseName;
    private LocalDate startDate;
    private LocalDate endDate;

    public void initalizeStudents() {
        Scanner ip = new Scanner(System.in);
        String answer = "";
        int numberOfStudents = 0;
        do {
            System.out.println("Add student for " + courseName + " course? (y/n)");
            answer = ip.nextLine();
            if (answer.equalsIgnoreCase("y") && numberOfStudents < 20) {
                addStudent();
                numberOfStudents++;
            }
            if(numberOfStudents >= 20){
                System.out.println("The course is full");
                break;
            }
        } while (answer.equalsIgnoreCase("y"));
    }

    public void addStudent() {
        Student student = new Student();
        Scanner ip = new Scanner(System.in);

        System.out.println("Enter student full name: ");
        student.setFullName(ip.nextLine());

        System.out.println("Enter student address: ");
        student.setAddress(ip.nextLine());

        System.out.println("Enter student's phone number: ");
        student.setPhoneNumber(ip.nextLine());

        students.add(student);
    }
}
