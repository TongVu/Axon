package personal;

import java.util.*;

/**
 * This program ask you to input n, then it shows all permutation from 1 to n
 * PermuteSet obj is the supporter for this program
 */

public class Ex11_PermuteN {
    /**
     * This function calculate the number of sets from 1 to n can permute
     * @param n is the number larger than 0
     * @return the number of sets from 1 to n can permute
     */
    public static int permuteResult(int n){
        if(n == 1) return 1;
        else
            return n * permuteResult(n - 1);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n;

        System.out.print("n: ");
        n = input.nextInt();

        List<String> strList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            strList.add(Integer.toString(i + 1));
        }

        HashMap<String, PermuteSet> sets = new HashMap<>(); // variable sets holds all sets that from 1 to n can permute

        PermuteSet firstElement = new PermuteSet(strList);
        sets.put(firstElement.toString(), firstElement); // create firstElement to put in the set

        PermuteSet newElement; // newElement holds the val after shuffle

        int numbOfSet = permuteResult(n); // number of sets that 1 from n can permute

        while(sets.size() < numbOfSet){ // if the collection isn't full, shuffle and get new permutation
            Collections.shuffle(strList);
            newElement = new PermuteSet(strList);
            if(!sets.containsKey(strList)){
                sets.put(newElement.toString(), newElement);
            }
        }

        Iterator<PermuteSet> it = sets.values().iterator();
        while(it.hasNext()) System.out.println(it.next().toString());

    }
}
