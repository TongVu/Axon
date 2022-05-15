package cattle_food_grading;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class FoodGradeTest {

    @Test
    void setGrade_shouldReturnNoSuchElementException_whenGradeIsNotABC(){
       assertThrows(NoSuchElementException.class, ()->{
          new FoodGrade().setGrade("E");
       });

        assertThrows(NoSuchElementException.class, ()->{
            new FoodGrade().setGrade("D");
        });
    }
    @Test
    void setGrade_shouldSetGrade_whenGradeIsABC(){
        FoodGrade foodGrade = new FoodGrade();
        foodGrade.setGrade("A");

        assertEquals("A", foodGrade.getGrade());
    }

    @Test
    void getGrade_shouldReturnA_whenGradeIsA(){
        FoodGrade foodGradeA = new FoodGrade();
        foodGradeA.setGrade("A");
        assertEquals("A", foodGradeA.getGrade());
    }

    @Test
    void getGrade_shouldReturnB_whenGradeIsB(){
        FoodGrade foodGradeB = new FoodGrade();
        foodGradeB.setGrade("B");
        assertEquals("B", foodGradeB.getGrade());
    }

    @Test
    void getGrade_shouldReturnC_whenGradeIsC(){
        FoodGrade foodGradeC = new FoodGrade();
        foodGradeC.setGrade("C");
        assertEquals("C", foodGradeC.getGrade());
    }

    @Test
    void getPrice_shouldReturnThirty_whenGradeIsA(){
        FoodGrade foodGradeA = new FoodGrade();
        foodGradeA.setGrade("A");
        assertEquals(30, foodGradeA.getPrice());
    }

    @Test
    void getPrice_shouldReturnThirty_whenGradeIsB(){
        FoodGrade foodGradeB = new FoodGrade();
        foodGradeB.setGrade("B");
        assertEquals(20, foodGradeB.getPrice());
    }

    @Test
    void getPrice_shouldReturnThirty_whenGradeIsC(){
        FoodGrade foodGradeC = new FoodGrade();
        foodGradeC.setGrade("C");
        assertEquals(10, foodGradeC.getPrice());
    }
}