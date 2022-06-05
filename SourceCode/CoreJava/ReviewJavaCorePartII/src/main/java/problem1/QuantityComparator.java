package problem1;

import java.util.Comparator;

public class QuantityComparator implements Comparator<Goods> {

    @Override
    public int compare(Goods o1, Goods o2) {
        return o1.getStockUnit() - o2.getStockUnit();
    }
}
