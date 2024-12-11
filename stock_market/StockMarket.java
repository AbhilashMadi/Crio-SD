package stock_market;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

interface Observer {
    void update(String stock, double price);
}

interface Subject {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers(String stock, double price);
}

class StockMarketObserver implements Subject {
    private final Map<String, Double> stocks = new HashMap<>();
    private final List<Observer> observers = new ArrayList<>();

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String stock, double price) {
        for (Observer observer : observers) {
            observer.update(stock, price);
        }
    }

    public void addOrUpdateStock(String stock, double price) {
        stocks.put(stock, price);
        notifyObservers(stock, price); // Notify about the specific stock change
    }
}

class StockClient implements Observer {
    private final String name;

    public StockClient(String name) {
        this.name = name;
    }

    @Override
    public void update(String stock, double price) {
        System.out.printf("%s -> [Stock: %s, Price: %.2f]%n", name, stock, price);
    }
}

public class StockMarket {
    public static void main(String[] args) {
        StockMarketObserver market = new StockMarketObserver();

        StockClient client1 = new StockClient("Cred");
        StockClient client2 = new StockClient("Grow");

        market.addObserver(client1);
        market.addObserver(client2);

        market.addOrUpdateStock("Birla", 19.99);
        market.addOrUpdateStock("Quant M", 29.99);
        market.addOrUpdateStock("Birla", 25.49); // Update existing stock price
    }
}
