package annual_sales;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws FileNotFoundException {
        File salesFile = new File("annualSalesWithText.txt");
        Scanner fileToRead = new Scanner(salesFile);

        Sales annualSales = new Sales("annualSalesWithText.txt");
        annualSales.annualIncome();
    }
}
