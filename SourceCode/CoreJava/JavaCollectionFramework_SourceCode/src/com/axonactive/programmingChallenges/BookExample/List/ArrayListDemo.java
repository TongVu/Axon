package com.axonactive.programmingChallenges.BookExample.List;
import java.util.List;
import java.util.ArrayList;

/**
 * Usage: faster in storing and accessing data
 */
public class ArrayListDemo {
    public static void main(String[] args) {
        List<String> nameList = new ArrayList<>();
        String[] names = {"Ann", "Bob", "Carol"};

        // Add to arrayList
        for (int k = 0; k < names.length; k++)
            nameList.add(names[k]);

        // Display name list
        for (int k = 0; k < nameList.size(); k++)
            System.out.println(nameList.get(k));
    }
}
