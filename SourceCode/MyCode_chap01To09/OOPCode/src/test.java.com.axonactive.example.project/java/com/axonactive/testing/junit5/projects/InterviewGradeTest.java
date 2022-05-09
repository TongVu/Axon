package com.axonactive.testing.junit5.projects;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InterviewGradeTest {

    @Test
    @DisplayName("Programming point below 0")
    void setProgramming_shouldReturnIllegalArgumentException_programmingSmallerThanZero() {
        var interview = new InterviewGrade();

        assertThrows(IllegalArgumentException.class,
                () -> interview.setProgramming(-3));
    }

    @Test
    @DisplayName("Essay point below 0")
    void setEssay_shouldReturnIllegalArgumentException_essaySmallerThanZero() {
        var interview = new InterviewGrade();

        assertThrows(IllegalArgumentException.class,
                () -> interview.setEssay(-1));
    }

    @Test
    @DisplayName("Interview point below 0")
    void setInterview_shouldReturnIllegalArgumentException_interviewSmallerThanZero() {
        var interview = new InterviewGrade();

        assertThrows(IllegalArgumentException.class,
                () -> interview.setInterview(-10));
    }

    @Test
    @DisplayName("Is averager positive")
    void average_shouldReturnPositiveNumber_ProgrammingEssayInterviewArePositive() {
        var interview = new InterviewGrade();

        assertEquals(71.33, interview.average(59, 90, 65));
    }

    @Test
    @DisplayName("Grade A if average is equal or greater than 90")
    void gradingAverage_shouldReturnA_averageEqualOrGreaterThanNinety() {
        var interview = new InterviewGrade();

        assertEquals("A", interview.gradingAverage(90, 90, 90));
        assertEquals("A", interview.gradingAverage(80, 90, 100));
        assertEquals("A", interview.gradingAverage(100, 100, 100));
    }

    @Test
    @DisplayName("Grade B if average is from 80 to 90")
    void gradingAverage_shouldReturnB_averageEqualOrGreaterThanEighty() {
        var interview = new InterviewGrade();

        assertEquals("B", interview.gradingAverage(89, 89, 89));
        assertEquals("B", interview.gradingAverage(80, 85, 87));
        assertEquals("B", interview.gradingAverage(80, 80, 80));
    }

    @Test
    @DisplayName("Grade C if average is from 70 to 80")
    void gradingAverage_shouldReturnC_averageEqualOrGreaterThanSeventy() {
        var interview = new InterviewGrade();

        assertEquals("C", interview.gradingAverage(79, 79, 79));
        assertEquals("C", interview.gradingAverage(70, 75, 77));
        assertEquals("C", interview.gradingAverage(70, 70, 70));
    }

    @Test
    @DisplayName("Grade D if average is from 60 to 70")
    void gradingAverage_shouldReturnD_averageEqualOrGreaterThanSixty() {
        var interview = new InterviewGrade();

        assertEquals("D", interview.gradingAverage(69, 69, 69.5));
        assertEquals("D", interview.gradingAverage(60, 65, 67));
        assertEquals("D", interview.gradingAverage(60, 60, 60));
    }

    @Test
    @DisplayName("Grade F if average is below 60")
    void gradingAverage_shouldReturnF_averageBelowSixty() {
        var interview = new InterviewGrade();

        assertEquals("F", interview.gradingAverage(59, 59, 59.5));
        assertEquals("F", interview.gradingAverage(50, 55, 57));
        assertEquals("F", interview.gradingAverage(0, 60, 60));
    }
}