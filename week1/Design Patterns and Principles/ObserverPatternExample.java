import java.util.*;

public class ObserverPatternExample {
    public static void main(String[] args) {
        StockMarket market = new StockMarket();

        Observer mobile = new MobileApp();
        Observer web = new WebApp();

        market.register(mobile);
        market.register(web);

        market.setPrice(350.5);
        System.out.println();

        market.deregister(web);
        market.setPrice(360.0);
    }
}

// Subject Interface
interface Stock {
    void register(Observer o);
    void deregister(Observer o);
    void notifyObservers();
}

// Concrete Subject
class StockMarket implements Stock {
    private List<Observer> observers = new ArrayList<>();
    private double price;

    public void register(Observer o) {
        observers.add(o);
    }

    public void deregister(Observer o) {
        observers.remove(o);
    }

    public void notifyObservers() {
        for (Observer o : observers)
            o.update(price);
    }

    public void setPrice(double price) {
        this.price = price;
        System.out.println("Stock Price Updated: ₹" + price);
        notifyObservers();
    }
}

// Observer Interface
interface Observer {
    void update(double price);
}

// Concrete Observer 1
class MobileApp implements Observer {
    public void update(double price) {
        System.out.println("Mobile App - New Stock Price: ₹" + price);
    }
}

// Concrete Observer 2
class WebApp implements Observer {
    public void update(double price) {
        System.out.println("Web App - New Stock Price: ₹" + price);
    }
}

