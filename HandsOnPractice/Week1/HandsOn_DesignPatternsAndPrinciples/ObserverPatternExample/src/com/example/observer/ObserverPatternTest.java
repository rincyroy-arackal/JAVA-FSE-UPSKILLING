package com.example.observer;

public class ObserverPatternTest {
    public static void main(String[] args) {
        StockMarket market = new StockMarket();

        Observer mobile1 = new MobileApp("M001");
        Observer web1 = new WebApp("U001");

        market.registerObserver(mobile1);
        market.registerObserver(web1);

        market.setStockPrice("AAPL", 185.6);
        System.out.println("----");

        market.setStockPrice("GOOG", 2795.3);
        System.out.println("----");

        market.removeObserver(mobile1);

        market.setStockPrice("TSLA", 755.2);
    }
}
