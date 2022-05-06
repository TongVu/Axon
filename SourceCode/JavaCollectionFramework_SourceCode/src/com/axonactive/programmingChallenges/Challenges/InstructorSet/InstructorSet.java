package com.axonactive.programmingChallenges.Challenges.InstructorSet;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class InstructorSet {
    private Set<Instructor> instructors;

    public InstructorSet(){ // nInstructors holds the number of instructors
        instructors = new HashSet<>();

        instructors.add(new Instructor("Tong", "Vu", "3354" ));
        instructors.add(new Instructor("Truc", "Anh", "2222" ));
        instructors.add(new Instructor("Nguyen", "Thinh", "1981" ));
        instructors.add(new Instructor("Tong", "Vu", "3325" )); // same name
        instructors.add(new Instructor("Le",  "Tu", "3354" ));
        instructors.add(new Instructor("Nguyen", "Vu", "2787" ));
        instructors.add(new Instructor("Tong", "Vu", "3354" )); // same everything
    }

    public void display(){
        Iterator<Instructor> it = instructors.iterator();
        while(it.hasNext()) System.out.println("\n" + it.next().toString());
    }

    public void search(Instructor obj){
        if(instructors.contains(obj)){
            System.out.println("FOUNDED\n" + obj.toString());
        }else{
            System.out.println(obj.toString() + " IS NOT FOUNDED");
        }
    }
}
