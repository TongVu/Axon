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
public class CourseManagement {
    private List<Course> courses = new ArrayList<>();

    public void addCourse() {
        Course newCourse = new Course();
        Scanner input = new Scanner(System.in);
        int day, month, year;

        System.out.println("Course name: ");
        newCourse.setCourseName(input.nextLine());

        do {
            System.out.println("Start date (day, month, year)");

            System.out.print("Day: ");
            day = input.nextInt();
            input.nextLine();

            System.out.print("Month: ");
            month = input.nextInt();
            input.nextLine();

            System.out.print("Year: ");
            year = input.nextInt();
            input.nextLine();
            newCourse.setStartDate(LocalDate.of(year, month, day));

            System.out.println("End date (day, month, year)");
            System.out.print("Day: ");
            day = input.nextInt();
            input.nextLine();

            System.out.print("Month: ");
            month = input.nextInt();
            input.nextLine();

            System.out.print("Year: ");
            year = input.nextInt();
            input.nextLine();
            newCourse.setEndDate(LocalDate.of(year, month, day));

        } while (newCourse.getStartDate().isAfter(newCourse.getEndDate()));

        courses.add(newCourse);
    }

    public Course searchCourseByName() {
        Scanner input = new Scanner(System.in);
        boolean isFound = false;
        String courseName;

        System.out.print("Enter course's name: ");
        courseName = input.nextLine();

        for (Course course : courses)
            if (courseName.equalsIgnoreCase(course.getCourseName())) {
                System.out.println(course.toString());
                return course;
            }

        System.out.println("There is no course with name: " + courseName);
        return new Course();
    }

    public void showCoursesStudentsEnrolled() {
        for (Course course : courses) {
            System.out.println("=======================================");
            System.out.println(course.getCourseName());
            System.out.println(course.toString() + "\n\n");
        }
    }

    public void showCoursesHaventEnded() {
        System.out.println("Courses haven't ended ===========================================");
        LocalDate today = LocalDate.now();
        for (Course course : courses) {
            if (today.isAfter(course.getEndDate())) {
                System.out.println(course.getCourseName() + "\n" +
                        course.getStartDate() + "\n" +
                        course.getEndDate() + "\n");
            }
        }
    }

    public void showCoursesHaventStarted() {
        System.out.println("Courses haven't started ===========================================");
        LocalDate today = LocalDate.now();
        for (Course course : courses) {
            if (today.isBefore(course.getStartDate())) {
                System.out.println(course.getCourseName() + "\n" +
                        course.getStartDate() + "\n" +
                        course.getEndDate() + "\n");
            }
        }
    }

    public static void main(String[] args) {
        CourseManagement manager = new CourseManagement();
        manager.addCourse();
        Course existedCourse = manager.searchCourseByName();
        existedCourse.addStudent();
        manager.showCoursesStudentsEnrolled();

        manager.addCourse();

        manager.showCoursesHaventEnded();
        manager.showCoursesHaventStarted();
    }
}
