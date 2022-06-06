package problem7;

import java.util.Set;
import java.util.TreeSet;

public class OperateWithTwoSetDemo {
    public static void main(String[] args) {
        Set<Integer> firstIntegerSet = new TreeSet<>();
        firstIntegerSet.add(15);
        firstIntegerSet.add(30);
        firstIntegerSet.add(20);
        firstIntegerSet.add(1);
        firstIntegerSet.add(7);
        firstIntegerSet.add(29);
        firstIntegerSet.add(6);
        for (Integer number : firstIntegerSet)
            System.out.print(number + " ");
        System.out.println();


        Set<Integer> secondIntegerSet = new TreeSet<>();
        secondIntegerSet.add(85);
        secondIntegerSet.add(29);
        secondIntegerSet.add(6);
        secondIntegerSet.add(24);
        secondIntegerSet.add(4);
        secondIntegerSet.add(15);
        secondIntegerSet.add(5);
        for (Integer number : secondIntegerSet)
            System.out.print(number + " ");
        System.out.println();

        firstIntegerSet.addAll(secondIntegerSet);
        System.out.println("\naggregatedSet =================================");
        for (Integer number : firstIntegerSet)
            System.out.print(number + " ");


        firstIntegerSet.removeAll(secondIntegerSet);
        System.out.println("\nsubtractedSet =================================");
        for (Integer number : firstIntegerSet)
            System.out.print(number + " ");

        Set<Integer> thirdIntegerSet = new TreeSet<>();
        thirdIntegerSet.add(1);
        thirdIntegerSet.add(30);
        firstIntegerSet.retainAll(thirdIntegerSet);
        System.out.println("\nintersectedSet =================================");
        for (Integer number : firstIntegerSet)
            System.out.print(number + " ");
    }
}
