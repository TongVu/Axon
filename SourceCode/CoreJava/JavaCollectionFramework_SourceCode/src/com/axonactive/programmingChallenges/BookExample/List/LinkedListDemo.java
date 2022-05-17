package com.axonactive.programmingChallenges.BookExample.List;
import java.util.LinkedList;
import java.util.List;

public class LinkedListDemo {
    public  static void main(String [ ] args)
    {
        List<String> nameList = new LinkedList<>();
        String [ ] names = {"Ann", "Bob", "Carol"};

        // Add to arrayList
        for (int k = 0; k < names.length; k++)
            nameList.add(names[k]);

        // Display name list
        for (int k = 0; k < nameList.size(); k++)
            System.out.println(nameList.get(k));
    }
}
