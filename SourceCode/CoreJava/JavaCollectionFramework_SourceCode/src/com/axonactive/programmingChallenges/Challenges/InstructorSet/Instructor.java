package com.axonactive.programmingChallenges.Challenges.InstructorSet;

/**
 * This class stores data about an instructor.
 */

public class Instructor {
    private String lastName;     // Last name
    private String firstName;    // First name
    private String officeNumber; // Office number

    /**
     * This constructor initializes the last name,
     * first name, and office number.
     *
     * @param lname  The instructor's last name.
     * @param fname  The instructor's first name.
     * @param office The office number.
     */

    public Instructor(String lname, String fname,
                      String office) {
        lastName = lname;
        firstName = fname;
        officeNumber = office;
    }

    /**
     * The copy constructor initializes the object
     * as a copy of another Instructor object.
     *
     * @param object2 The object to copy.
     */

    public Instructor(Instructor object2) {
        lastName = object2.lastName;
        firstName = object2.firstName;
        officeNumber = object2.officeNumber;
    }

    /**
     * The set method sets a value for each field.
     *
     * @param lname  The instructor's last name.
     * @param fname  The instructor's first name.
     * @param office The office number.
     */

    public void set(String lname, String fname,
                    String office) {
        lastName = lname;
        firstName = fname;
        officeNumber = office;
    }

    /**
     * toString method
     *
     * @return A string containing the instructor
     * information.
     */

    public String toString() {
        // Create a string representing the object.
        String str = "Last Name: " + lastName +
                "\nFirst Name: " + firstName +
                "\nOffice Number: " + officeNumber;

        // Return the string.
        return str;
    }


   /*
   When you design a class, you will need to override the hashCode and equals methods if you want to
   store objects of the class in a HashSet.

    1. If you call an object’s hashCode method more than once during the execution of an application,
    the method should consistently return the same value. The only exception is when something in
    the object has changed, which would affect the way the equals method makes comparisons.

    2. If the equals method reports that two objects are equal, then both objects’ hashCode methods
    should return the same value.

    3. If the equals method reports that two objects are not equal, it is permissible for both objects to
    have the same hash code. You should be aware, however, that having too many unequal objects
    with the same hash code will degrade the performance of an algorithm that uses the hash codes
    for searching.
    */

    // overriding hashCode and equals methods

    @Override
    public int hashCode(){
        return lastName.hashCode() + firstName.hashCode() + officeNumber.hashCode();
    }

    @Override
    public boolean equals(Object obj){
        if(!(obj instanceof Instructor)) // check if obj same type as Instructor
            return false;
        else{
            Instructor tmpInstructor = (Instructor) obj; // cast Instructor type to the Obj since I've known it's an Instructor

            return lastName.equalsIgnoreCase(tmpInstructor.lastName) &&
                    firstName.equalsIgnoreCase(tmpInstructor.firstName) &&
                    officeNumber.equalsIgnoreCase(tmpInstructor.officeNumber);
        }
    }
}