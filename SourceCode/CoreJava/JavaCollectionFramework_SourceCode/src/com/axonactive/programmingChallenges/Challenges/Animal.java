package com.axonactive.programmingChallenges.Challenges;

import java.util.ArrayList;
import java.util.List;

public class Animal {
    List<Animal> list = new ArrayList<>();

    public void takeAnimalArr(ArrayList<Animal> arr){
        this.list = arr;
    }
}
