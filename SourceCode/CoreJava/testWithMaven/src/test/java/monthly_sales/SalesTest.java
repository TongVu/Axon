package monthly_sales;

import org.junit.jupiter.api.Test;

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
    void totalIncome_shouldReturnNumberFormatException_whenFileContainsText() throws FileNotFoundException {
        Sales salesFile = new Sales("numbersAndText.txt");

        assertThrows(NumberFormatException.class, ()->{
           salesFile.totalIncome();
        });
    }

    @Test
    void totalIncome_shouldReturnZero_whenFileIsEmpty() throws FileNotFoundException {
        Sales salesFile = new Sales("empty.txt");
        assertEquals(0.0, salesFile.totalIncome());
    }

    @Test
    void totalIncome_shouldReturnDoubleValue_whenFileHasValue() throws FileNotFoundException {
        Sales salesFile = new Sales("numbers.txt");
        assertEquals(167.0, salesFile.totalIncome());
    }

    @Test
    void averageDailyIncome_shouldReturnDoubleValue_whenTotalIncomeIsAValue() throws FileNotFoundException {
        Sales salesFile = new Sales("numbers.txt");
        salesFile.totalIncome();
        assertEquals(salesFile.totalIncome()/30,
                salesFile.averageDailyIncome());

        Sales salesFile2 = new Sales("empty.txt");
        assertEquals(0.0, salesFile2.averageDailyIncome());
    }
}