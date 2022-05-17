package grading;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GradingTest {


    @Test
    void calculateAverage_shouldReturnDoubleValue_whenProgrammingDissertationAndInterviewPositive() {
        assertEquals((double)(30 + 60 + 80) / 3 ,
                new Grading(30, 60, 80).calculateAverage());

        assertEquals((double)(40 + 50 + 70)/3 ,
                new Grading(40, 50, 70).calculateAverage());

        assertEquals((double)(20 + 90 + 85)/3 ,
                new Grading(20, 90, 85).calculateAverage());
    }

    @Test
    void showResult_shouldReturnA_whenAverageIsGreaterThanNinety(){
        assertEquals("A", new Grading(90, 90, 90).showResult());
        assertEquals("A", new Grading(95, 85, 93.5).showResult());
        assertEquals("A", new Grading(100, 100, 100).showResult());
    }

    @Test
    void showResult_shouldReturnB_whenAverageIsFromEightyToSmallerThanNinety(){
        assertEquals("B", new Grading(90, 90, 89).showResult());
        assertEquals("B", new Grading(80, 80, 80).showResult());
        assertEquals("B", new Grading(82, 80, 90).showResult());
    }
    @Test
    void showResult_shouldReturnC_whenAverageIsFromSeventyToSmallerThanEighty(){
        assertEquals("C", new Grading(70, 70, 70).showResult());
        assertEquals("C", new Grading(79, 80, 80).showResult());
        assertEquals("C", new Grading(73, 65, 83).showResult());
    }

    @Test
    void showResult_shouldReturnD_whenAverageIsFromSixtyToSmallerThanSeventy(){
        assertEquals("D", new Grading(60, 60, 60).showResult());
        assertEquals("D", new Grading(69, 70, 70).showResult());
        assertEquals("D", new Grading(63, 55, 63).showResult());
    }

    @Test
    void showResult_shouldReturnF_whenAverageIsSmallerThanSixty(){
        assertEquals("F", new Grading(60, 60, 59).showResult());
        assertEquals("F", new Grading(0, 0, 0).showResult());
        assertEquals("F", new Grading(20, 55, 90).showResult());
    }

}