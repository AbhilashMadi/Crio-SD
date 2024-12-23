package observer_pattern.stock_market;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Observer Interface
interface Observer {
    void update(String stock, double price);
}

// Subject Interface
interface Subject {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}

// Concrete Subject
class StockMarketSubject implements Subject {
    private Map<String, Double> stockPrices = new HashMap<>();
    private List<Observer> observers = new ArrayList<>();

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            for (Map.Entry<String, Double> entry : stockPrices.entrySet()) {
                observer.update(entry.getKey(), entry.getValue());
            }
        }
    }

    // Business Logic
    public void setStockPrice(String stock, double price) {
        stockPrices.put(stock, price);
        notifyObservers();
    }
}

// Concrete Observer
class StockClient implements Observer {
    private String name;

    public StockClient(String name) {
        this.name = name;
    }

    @Override
    public void update(String stock, double price) {
        System.out.println(name + " received update: " + stock + " is now $" + price);
    }
}

// App Class
public class StockMarket {
    public static void main(String[] args) {
        StockMarketSubject stockMarket = new StockMarketSubject();

        StockClient client1 = new StockClient("Client 1");
        StockClient client2 = new StockClient("Client 2");

        stockMarket.addObserver(client1);
        stockMarket.addObserver(client2);

        stockMarket.setStockPrice("AAPL", 145.0);
        stockMarket.setStockPrice("GOOGL", 2800.0);
    }
}
