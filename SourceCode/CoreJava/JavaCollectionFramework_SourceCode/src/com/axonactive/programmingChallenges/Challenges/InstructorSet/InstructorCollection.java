package com.axonactive.programmingChallenges.Challenges.InstructorSet;

/**
 * This class stores Instructor objects in a HashSet
 * It can display all instructors in the set
 * It can allow usr search instructor
 */

public class InstructorCollection {
    public static void main(String[] args) {
        InstructorSet newSet = new InstructorSet(); // newSet holds a list of instructors when call it's default constructor


//        "Tong", "Vu", "3354"
//        "Truc", "Anh", "2222"
        newSet.display();
        Instructor lookedPerson =  new Instructor("Tong", "Vu", "3354"),
        lookedPerson2 = new Instructor("Truc", "Anh", "2225");

        newSet.search(lookedPerson); // looking for first person

        newSet.search(lookedPerson2); // looking for second person
    }

}
