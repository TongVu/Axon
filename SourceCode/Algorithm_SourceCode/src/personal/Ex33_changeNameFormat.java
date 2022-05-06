package personal;

import java.util.Scanner;

public class Ex33_changeNameFormat {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String firstName, middleName, lastName;

        System.out.print("Last name: ");
        lastName = input.nextLine();

        System.out.print("Middle name: ");
        middleName = input.nextLine();

        System.out.print("First name: ");
        firstName = input.nextLine();


        System.out.println("Change format");
        System.out.println(firstName + " "
                + middleName + " "
                + lastName
        );

    }
}
