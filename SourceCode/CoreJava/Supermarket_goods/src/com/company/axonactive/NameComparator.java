package com.company.axonactive;

import java.util.Comparator;

public class NameComparator implements Comparator<Goods> {
    @Override
    public int compare(Goods o1, Goods o2) {
        return o1.getGoodsName().compareTo(o2.getGoodsName());
    }
}