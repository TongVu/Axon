package monthly_sales;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Sales {
    private String filePath;

    public Sales() {
    }

    public Sales(String filePath) throws FileNotFoundException {
        setFilePath(filePath);
    }

    public void setFilePath(String filePath) throws FileNotFoundException {
        new Scanner(new File(filePath));

        this.filePath = filePath;
    }

    public double totalIncome() throws FileNotFoundException {
        Scanner fileToRead = new Scanner(new File(this.filePath));
        double totalIncome = 0;

        while (fileToRead.hasNext()) {
            totalIncome += Double.parseDouble(fileToRead.nextLine());
        }
        fileToRead.close();

        return totalIncome;
    }

    public double averageDailyIncome() throws FileNotFoundException {
        return totalIncome() / 30;
    }

}
