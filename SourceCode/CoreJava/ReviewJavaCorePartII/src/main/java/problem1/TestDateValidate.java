package problem1;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Scanner;

public class TestDateValidate {
    public static boolean isNumber(String dateMonthOrYear) {
        if (dateMonthOrYear == null) return false;

        try {
            Integer.parseInt(dateMonthOrYear);
        } catch (NumberFormatException numberFormatException) {
            return false;
        }

        return true;
    }

    public static boolean checkDay(String date) {
        if (Integer.parseInt(date) > 0 &&
                Integer.parseInt(date) <= 31) {
            return true;
        } else return false;
    }

    public static boolean checkMonth(String month) {
        if (Integer.parseInt(month) > 0 &&
                Integer.parseInt(month) < 13) {
            return true;
        } else return false;
    }

    public static boolean checkYear(String year) {
        int THIS_YEAR = 2022;

        if (Integer.parseInt(year) > 2000 &&
                Integer.parseInt(year) <= THIS_YEAR) {
            return true;
        } else return false;
    }

    public static void main(String[] args) throws ParseException {
        Scanner kb = new Scanner(System.in);
        String importedDate;


/*
        boolean isDateValid = true;
        do {
            if (!isDateValid)
            System.out.println("Something went wrong. Please make sure you input the correct format");

            System.out.println("Enter date with format: dd/mm/yyyy");
            importedDate = kb.nextLine();

            StringTokenizer tokens = new StringTokenizer(importedDate, "/");
            String day = String.valueOf(tokens.nextToken().toCharArray());
            String month = String.valueOf(tokens.nextToken().toCharArray());
            String year = String.valueOf(tokens.nextToken().toCharArray());

            System.out.println("Is day valid: " + checkDay(day));
            System.out.println("Is month valid: " + checkMonth(month));
            System.out.println("Is year valid: " + checkYear(year));
            if (isNumber(day) && isNumber(month) && isNumber(year)) { // if day - month - year are all number
                if (checkDay(day) &&  // if day in range 1 -31
                        checkMonth(month) &&  // if month in range 1-12
                        checkYear(year)) { // if year from 2000 - THIS_YEAR
                    System.out.println("OK");
                } else isDateValid = false;
            } else isDateValid = false;
        } while (!isDateValid);

*/
        System.out.println(Calendar.getInstance().get(Calendar.YEAR));

        Ceramics cre2 = new Ceramics("1234", "CHECKING CERAMIC", 200, 52, "VIE", "05/05/2022");
        Ceramics cre3 = new Ceramics("5678", "CHECKING CERAMIC 2", 200, 65, "VIE", "26/04/2022");

        System.out.println(cre2.checkSalesRate());
        System.out.println(cre3.checkSalesRate());

    }
}
