package Problem3;

import java.util.Scanner;
import java.util.StringTokenizer;

public abstract class Employee implements Payable {
    private String ssn;
    private String firstName;
    private String lastName;
    private String birthDay;
    private String phone;
    private String email;

    public Employee() {
    }

    ;

    Employee(String ssn, String firstName, String lastName) {
        setSsn(ssn);
        setFirstName(firstName);
        setLastName(lastName);
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirthDay() {
        return birthDay;
    }

    /*
        Birthday have format dd/MM/yyyy;
     */
    public void setBirthDay(String birthDay) {
        StringTokenizer tokens = new StringTokenizer(birthDay, "/");
        String[] dayMonthYear = new String[tokens.countTokens()];

        for (int i = 0; i < dayMonthYear.length; i++) {
            dayMonthYear[i] = tokens.nextToken();
        }
        while (
                !(Integer.parseInt(dayMonthYear[0]) <= 31
                        && Integer.parseInt(dayMonthYear[0]) >= 1) ||

                        !(Integer.parseInt(dayMonthYear[1]) <= 12
                                && Integer.parseInt(dayMonthYear[1]) >= 1) ||

                        !(Integer.parseInt(dayMonthYear[2]) >= 1922 &&
                                Integer.parseInt(dayMonthYear[2]) <= 2022)) {
            System.out.println("Invalid birthday. Format: dd/mm/yyyy");
            System.out.print("Please type again: ");
            Scanner input = new Scanner(System.in);
            String usrInput;

            usrInput = input.nextLine();
            this.setBirthDay(usrInput);
        }

        this.birthDay = birthDay;
    }

    public String getPhone() {
        return phone;
    }

    /*
        Phone have at least 7 postitive number digits
        haven't check if the number contain character
     */
    public void setPhone(String phone) {
        while (phone.length() < 7 ) {
            System.out.println("Phone have at least 7 positive number digits");
        }
            this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public double getPaymentAmount() {
        return 0.0d;
    }

    @Override
    public String toString() {
        return "return a string";
    }
}
