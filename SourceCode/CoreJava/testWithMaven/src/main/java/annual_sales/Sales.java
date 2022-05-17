package annual_sales;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.FieldPosition;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sales {
    private String filePath;

    public Sales() {
    }

    public Sales(String filePath) {
        this.filePath = filePath;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) throws FileNotFoundException {
        new Scanner(new File(filePath));
        this.filePath = filePath;
    }

    public double annualIncome() throws FileNotFoundException {
        double annualIncome = 0;
        File salesFile = new File(filePath);
        Scanner fileToRead = new Scanner(salesFile);

        if (salesFile.length() == 0) return 0;

        if (salesFile.length() != 0) {
            while (fileToRead.hasNext()) {
                fileToRead.next();
                annualIncome += Double.valueOf(fileToRead.next());
            }
            fileToRead.close();
        }

        return annualIncome;
    }


    public double averageDailyIncome() throws FileNotFoundException {
        double averageDailyIncome;
        File salesFile = new File(filePath);
        int days = (int) salesFile.length();

        if (days == 0) return 0;
        averageDailyIncome = annualIncome() / days;

        return averageDailyIncome;
    }

    public double averageMonthlyIncome() throws FileNotFoundException {
        double averageMonthlyIncome = 0;
        File salesFile = new File(filePath);
        int days = (int) salesFile.length();
        int months = Math.round(days / 30);

        if (days == 0) return 0;
        averageMonthlyIncome = annualIncome() / months;

        return averageMonthlyIncome;
    }
}
