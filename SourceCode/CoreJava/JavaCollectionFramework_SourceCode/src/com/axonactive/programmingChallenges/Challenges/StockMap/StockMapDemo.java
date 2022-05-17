package com.axonactive.programmingChallenges.Challenges.StockMap;

public class StockMapDemo {
    public static void main(String[] args) {
        StocksMap vieStock = new StocksMap();

        vieStock.add(new Stock("NKY",27_105.26 ));
        vieStock.add(new Stock("TPX",1_105.15 ));
        vieStock.add(new Stock("HSI",20_620.45 ));
        vieStock.add(new Stock("SHSZ300",4_013.26 ));
        vieStock.add(new Stock("MXAP",171.47 ));

        vieStock.showStockList();

        System.out.println("Look up for NKY symbol");
        vieStock.search("NKY");

        System.out.println("\nLook up for SX5E symbol");
        vieStock.search("SX5E");
    }
}
