package org.example;

public class Order {

    public enum OrderType{
        BUY,
        SELL
    }

    private double price;
    private double amount;
    private OrderType type;
    private String stockName;

    public Order() {} // we need this default constructor for deserialization!

    public Order(String stockName, double price, double amount, OrderType type)
    {
        this.stockName = stockName;
        this.price = price;
        this.amount = amount;
        this.type = type;
    }

    // getters and setters
    public double getPrice() {
        return price;
    }

    public double getAmount() {
        return amount;
    }

    public OrderType getType() {
        return type;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public void setType(OrderType type) {
        this.type = type;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
