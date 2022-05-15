package sum_a_file;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class FileSum {
    private String path;

    public FileSum() {
    }

    public FileSum(String path) throws FileNotFoundException {
        setPath(path);
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) throws FileNotFoundException {
            Scanner fileToRead = new Scanner(new File(path));
            this.path = path;
    }

    public double sumFile() throws FileNotFoundException {
        double sum = 0d;
        File numberFile = new File(this.path);
        Scanner fileToRead = new Scanner(numberFile);

        if(numberFile.length() == 0) return 0d;

        try {
            while (fileToRead.hasNext()) {
                sum += Double.parseDouble(fileToRead.nextLine());
            }
            fileToRead.close();
        }catch (NumberFormatException e){
            throw e;
        }

        return sum;
    }
}
