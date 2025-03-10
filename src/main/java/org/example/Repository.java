package org.example;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class Repository {

    // stocks to buy
    private final PriorityQueue<Order> buyOrders = new PriorityQueue<>(
            Comparator.comparingDouble(Order::getPrice).reversed());
    // stock to sell
    private final PriorityQueue<Order> sellOrders = new PriorityQueue<>(
            Comparator.comparingDouble(Order::getPrice));

    // classification of stocks
    public void add(Order order)
    {
        if(order.getType() == Order.OrderType.BUY)
        {
            buyOrders.add(order);
        }else{
            sellOrders.add(order);
        }
    }

    // returns top 10 orders to buy
    public List<Order> getTop10TypeBuyOrders()
    {
        //return buyOrders.stream().limit(10).collect(Collectors.toList());

        return buyOrders.stream()
                .sorted(Comparator.comparing(Order::getPrice).reversed())
                .limit(10)
                .collect(Collectors.toList());
    }

    // return top 10 orders to sell
    public List<Order> getTop10TypeSellOrders()
    {
        //return sellOrders.stream().limit(10).collect(Collectors.toList());
        return sellOrders.stream()
                .sorted(Comparator.comparing(Order::getPrice))
                .limit(10)
                .collect(Collectors.toList());
    }

    // example data
    public void initializeData()
    {
        add(new Order("AAPL", 120.50, 10, Order.OrderType.BUY));
        add(new Order("MSFT", 230.75, 15, Order.OrderType.SELL));
        add(new Order("GOOGL", 937.55, 77, Order.OrderType.BUY));
        add(new Order("AMZN", 340.20, 20, Order.OrderType.SELL));
        add(new Order("TSLA", 720.10, 25, Order.OrderType.BUY));
        add(new Order("META", 280.30, 30, Order.OrderType.SELL));
        add(new Order("NVDA", 560.45, 35, Order.OrderType.BUY));
        add(new Order("NFLX", 450.50, 40, Order.OrderType.SELL));
        add(new Order("ADBE", 670.60, 45, Order.OrderType.BUY));
        add(new Order("ORCL", 85.90, 50, Order.OrderType.SELL));

        add(new Order("INTC", 50.60, 55, Order.OrderType.BUY));
        add(new Order("AMD", 120.70, 60, Order.OrderType.SELL));
        add(new Order("DIS", 130.80, 65, Order.OrderType.BUY));
        add(new Order("V", 200.90, 70, Order.OrderType.SELL));
        add(new Order("PYPL", 180.95, 75, Order.OrderType.BUY));
        add(new Order("UBER", 40.15, 80, Order.OrderType.SELL));
        add(new Order("LYFT", 35.25, 85, Order.OrderType.BUY));
        add(new Order("SQ", 220.35, 90, Order.OrderType.SELL));
        add(new Order("SNAP", 15.45, 95, Order.OrderType.BUY));
        add(new Order("TWTR", 50.55, 100, Order.OrderType.SELL));

        add(new Order("BABA", 250.65, 105, Order.OrderType.BUY));
        add(new Order("JD", 80.75, 110, Order.OrderType.SELL));
        add(new Order("BIDU", 170.85, 115, Order.OrderType.BUY));
        add(new Order("T", 30.95, 120, Order.OrderType.SELL));
        add(new Order("VZ", 55.05, 125, Order.OrderType.BUY));
        add(new Order("PFE", 40.15, 130, Order.OrderType.SELL));
        add(new Order("JNJ", 160.25, 135, Order.OrderType.BUY));
        add(new Order("MRNA", 150.35, 140, Order.OrderType.SELL));
        add(new Order("CVS", 70.45, 145, Order.OrderType.BUY));
        add(new Order("WMT", 140.55, 150, Order.OrderType.SELL));

        add(new Order("COST", 400.65, 155, Order.OrderType.BUY));
        add(new Order("HD", 320.75, 160, Order.OrderType.SELL));
        add(new Order("LOW", 210.85, 165, Order.OrderType.BUY));
        add(new Order("MCD", 250.95, 170, Order.OrderType.SELL));
        add(new Order("SBUX", 100.05, 175, Order.OrderType.BUY));
        add(new Order("KO", 60.15, 180, Order.OrderType.SELL));
        add(new Order("PEP", 160.25, 185, Order.OrderType.BUY));
        add(new Order("NKE", 140.35, 190, Order.OrderType.SELL));
        add(new Order("ADIDAS", 160.45, 195, Order.OrderType.BUY));
        add(new Order("PUMA", 70.55, 200, Order.OrderType.SELL));

        add(new Order("GE", 100.65, 205, Order.OrderType.BUY));
        add(new Order("GM", 40.75, 210, Order.OrderType.SELL));
        add(new Order("F", 30.85, 215, Order.OrderType.BUY));
        add(new Order("TSM", 90.95, 220, Order.OrderType.SELL));
        add(new Order("INTU", 510.05, 225, Order.OrderType.BUY));
        add(new Order("CRM", 240.15, 230, Order.OrderType.SELL));
        add(new Order("CSCO", 55.25, 235, Order.OrderType.BUY));
        add(new Order("IBM", 130.35, 240, Order.OrderType.SELL));
        add(new Order("HPQ", 25.45, 245, Order.OrderType.BUY));
        add(new Order("DELL", 50.55, 250, Order.OrderType.SELL));

        add(new Order("NFLX", 450.50, 260, Order.OrderType.BUY));
        add(new Order("AAPL", 2057.19, 168, Order.OrderType.BUY));
        add(new Order("MSFT", 3220.58, 187, Order.OrderType.SELL));
        add(new Order("ATVI", 1073.91, 95, Order.OrderType.BUY));
        add(new Order("INTC", 1050.40, 89, Order.OrderType.SELL));
        add(new Order("AMD", 2200.30, 100, Order.OrderType.BUY));
        add(new Order("META", 1440.25, 80, Order.OrderType.SELL));
        add(new Order("AMZN", 3330.50, 120, Order.OrderType.BUY));
        add(new Order("TSLA", 700.30, 65, Order.OrderType.SELL));
        add(new Order("NVDA", 820.10, 55, Order.OrderType.BUY));

        add(new Order("ORCL", 230.25, 45, Order.OrderType.SELL));
        add(new Order("ADBE", 980.60, 75, Order.OrderType.BUY));
        add(new Order("DIS", 560.90, 85, Order.OrderType.SELL));
        add(new Order("V", 240.20, 95, Order.OrderType.BUY));
        add(new Order("PYPL", 180.95, 55, Order.OrderType.SELL));
        add(new Order("UBER", 40.15, 80, Order.OrderType.BUY));
        add(new Order("LYFT", 35.25, 90, Order.OrderType.SELL));
        add(new Order("SQ", 220.35, 50, Order.OrderType.BUY));
        add(new Order("SNAP", 15.45, 60, Order.OrderType.SELL));
        add(new Order("TWTR", 50.55, 30, Order.OrderType.BUY));

        add(new Order("BABA", 250.65, 35, Order.OrderType.SELL));
        add(new Order("JD", 80.75, 25, Order.OrderType.BUY));
        add(new Order("BIDU", 170.85, 45, Order.OrderType.SELL));
        add(new Order("T", 30.95, 70, Order.OrderType.BUY));
        add(new Order("VZ", 55.05, 75, Order.OrderType.SELL));
        add(new Order("PFE", 40.15, 65, Order.OrderType.BUY));
        add(new Order("JNJ", 160.25, 100, Order.OrderType.SELL));
        add(new Order("MRNA", 150.35, 110, Order.OrderType.BUY));
        add(new Order("CVS", 70.45, 90, Order.OrderType.SELL));
        add(new Order("WMT", 140.55, 85, Order.OrderType.BUY));

    }
}
