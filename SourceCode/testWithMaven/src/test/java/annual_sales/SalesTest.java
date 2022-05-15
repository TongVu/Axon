package annual_sales;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class SalesTest {

    @Test
    void setFilePath_shouldReturnFileNotFoundException_whenFileNotExist() {
        Sales salesFile = new Sales();
        assertThrows(FileNotFoundException.class, ()->{
            salesFile.setFilePath("randomFile.txt");
        });
    }

    @Test
    void annualIncome_shouldReturnZero_whenFileIsEmpty() throws FileNotFoundException {
        Sales salesFile = new Sales("empty.txt");

        assertEquals(0.0, salesFile.annualIncome());
    }

    @Test
    void annualIncome_shouldReturnNumberFormatException_whenFileContainsText(){
        Sales salesFile = new Sales("annualSalesWithText.txt");

        assertThrows(NumberFormatException.class, ()->{
           salesFile.annualIncome();
        });
    }

    @Test
    void annualIncome_shouldReturnDoubleValue_whenFileContainsNumbers() throws FileNotFoundException {
        Sales salesFile = new Sales("annualSales.txt");

        assertEquals(1542.5, salesFile.annualIncome());
    }

    @Test
    void dailyIncome_shouldReturnDoubleValue_whenFileContainsNumbers() throws FileNotFoundException {
        Sales salesFile = new Sales("annualSales.txt");
        int days = (int) new File("annualSales.txt").length();

        assertEquals(salesFile.annualIncome()/days,
                salesFile.averageDailyIncome());
    }

    @Test
    void dailyIncome_shouldReturnZero_whenFileIsEmpty() throws FileNotFoundException {
        Sales salesFile = new Sales("empty.txt");

        assertEquals(0.0, salesFile.averageDailyIncome());
    }

    @Test
    void dailyIncome_shouldReturnNumberFormatException_whenFileContainsText(){
        Sales salesFile = new Sales("annualSalesWithText.txt");

        assertThrows(NumberFormatException.class, ()->{
           salesFile.annualIncome();
        });
    }

    @Test
    void averageMonthlyIncome_shouldReturnDoubleValue_whenFileContainsValue() throws FileNotFoundException {
        Sales salesFile = new Sales("annualSales.txt");
        int days = (int) new File("annualSales.txt").length();
        int months = Math.round(days/30);

        assertEquals(salesFile.annualIncome()/months,
                salesFile.averageMonthlyIncome());
    }

    @Test
    void averageMonthlyIncome_shouldReturnZero_whenFileIsEmpty() throws FileNotFoundException {
        Sales salesFile = new Sales("empty.txt");

        assertEquals(0, salesFile.averageMonthlyIncome());
    }

    @Test
    void averageMonthlyIncome_shouldReturnNumberFormatException_whenFileContainsText(){
        Sales salesFile = new Sales("annualSalesWithText.txt");

        assertThrows(NumberFormatException.class, ()->{
           salesFile.averageMonthlyIncome();
        });
    }
}