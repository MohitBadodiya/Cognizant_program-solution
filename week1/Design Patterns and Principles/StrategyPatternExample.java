public class StrategyPatternExample {
    public static void main(String[] args) {
        PaymentContext context;

        context = new PaymentContext(new CreditCardPayment());
        context.makePayment(1500);

        System.out.println();

        context = new PaymentContext(new PayTMPayment());
        context.makePayment(2500);
    }
}

//Strategy Interface
interface PaymentStrategy {
    void pay(double amount);
}

//Concrete Strategies
class CreditCardPayment implements PaymentStrategy {
    public void pay(double amount) {
        System.out.println("Paid ₹" + amount + " using Credit Card.");
    }
}

class PayTMPayment implements PaymentStrategy {
    public void pay(double amount) {
        System.out.println("Paid ₹" + amount + " using PayPTM.");
    }
}

//Context Class
class PaymentContext {
    private PaymentStrategy strategy;

    public PaymentContext(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public void makePayment(double amount) {
        strategy.pay(amount);
    }
}

