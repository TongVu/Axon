package sum_a_file;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class FileSumTest {
    @Test
    void setPath_shouldReturnFileNotFoundException_whenInputPathNotExist() {
        FileSum file = new FileSum();

        assertThrows(FileNotFoundException.class, ()->{
            file.setPath("randomPath.txt");
        });
    }

    @Test
    void sumFile_shouldReturnZero_whenFileIsEmpty() throws FileNotFoundException {
        FileSum emptyFile = new FileSum("empty.txt");

        assertEquals(0.0, emptyFile.sumFile());
    }

    @Test
    void sumFile_shouldReturnNumberFormatException_whenFileHasText() throws FileNotFoundException {
        FileSum file = new FileSum("numbersAndText.txt");

        assertThrows(NumberFormatException.class, ()->{
            file.sumFile();
        });
    }

    @Test
    void sumFile_shouldReturnDoubleValue_whenFileContainsNumbers() throws FileNotFoundException {
        FileSum file = new FileSum("numbers.txt");
        assertEquals(167.0, file.sumFile());
    }

}