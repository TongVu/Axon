package com.axonactive.programmingChallenges.Challenges.StockMap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class StocksMap {
    Map<String, Stock> stocksList;

    public StocksMap(){
        stocksList = new HashMap<>();
    }

    public void add(Stock obj){
        stocksList.put(obj.getSymbol(), obj);
    }

    public void showStockList(){
        stocksList.forEach((key, val) -> System.out.println(val)
                );
    }

    public void search(String stockSymbol){ // search the stock if in the stocksList by symbol key
        Stock tmp = stocksList.get(stockSymbol);
        if(tmp == null){
            System.out.println("NOT FOUND SUCH SYMBOL: " + stockSymbol);
        } else{
            System.out.println("Share price of " + stockSymbol +
                    ": " + stocksList.get(stockSymbol).getSharePrice());
        }
    }
}
