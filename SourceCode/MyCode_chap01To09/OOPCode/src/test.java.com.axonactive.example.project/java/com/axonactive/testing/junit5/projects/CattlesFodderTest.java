package com.axonactive.testing.junit5.projects;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class CattlesFodderTest {

    @Test
    @DisplayName("Check grade is A - price is 30")
    void checkGrade_shouldReturnThirty_getFoodGradeIsA(){
        var cattleFodder = new CattlesFodder();
        cattleFodder.setFoodGrade("A");

        assertEquals(30, cattleFodder.checkGrade());
    }

    @Test
    @DisplayName("Check grade is B - price is 20")
    void checkGrade_shouldReturnTwenty_getFoodGradeIsB(){
        var cattleFodder = new CattlesFodder();
        cattleFodder.setFoodGrade("B");

        assertEquals(20, cattleFodder.checkGrade());
    }

    @Test
    @DisplayName("Check grade is C - price is 10")
    void checkGrade_shouldReturnTen_getFoodGradeIsC(){
        var cattleFodder = new CattlesFodder();
        cattleFodder.setFoodGrade("C");

        assertEquals(10, cattleFodder.checkGrade());
    }

    @Test
    @DisplayName("Food grade is not A, B, C throw Exception")
    void checkGrade_shouldReturnNoSuchElementException_getFoodGradeIsNotABC() {
        var cattleFodder = new CattlesFodder();
        cattleFodder.setFoodGrade("F");

        assertThrows(NoSuchElementException.class,
                () -> cattleFodder.checkGrade());
    }
}