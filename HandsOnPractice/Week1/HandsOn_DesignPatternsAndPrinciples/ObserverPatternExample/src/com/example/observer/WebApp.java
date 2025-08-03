package com.example.observer;

public class WebApp implements Observer {
    private String userId;

    public WebApp(String userId) {
        this.userId = userId;
    }

    @Override
    public void update(String stockName, double stockPrice) {
        System.out.println("WebApp [" + userId + "] - Stock: " + stockName + " updated to $" + stockPrice);
    }
}
