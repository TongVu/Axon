package personal;

import java.util.ArrayList;
import java.util.List;

public class PermuteSet {
    private List<String> permuteSet = new ArrayList<>(); // holds a random permuted list of from 1 to n;

    public PermuteSet(){}

    public PermuteSet(List<String> input) {
        for (String numb :
                input) {
            permuteSet.add(numb);
        }
    }

    public List<String> getPermuteSet() {
        return permuteSet;
    }

    public void setPermuteSet(List<String> permuteSet) {
        this.permuteSet = permuteSet;
    }

    @Override
    public String toString(){
        String set = "";
        for (String element :
                permuteSet) {
            set += element;
        }

        return set;
    }
}
