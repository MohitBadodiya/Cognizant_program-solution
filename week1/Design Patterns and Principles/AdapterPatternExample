public class AdapterPatternExample{
    public static void main(String[] args) {
        // RazorPay Payment
        Payment payment1 = new RazorPayAdapter();
        payment1.pay(1000);

        // PayTM Payment
        Payment payment2 = new PayTMAdapter();
        payment2.pay(2000);
    }
}

// Target Interface
interface Payment {
    void pay(double amount);
}

// Adaptee 1
class RazorPay {
    public void sendPayment(double amt) {
        System.out.println("Paid ₹ " + amt + " using RazorPay.");
    }
}

// Adaptee 2
class PayTM {
    public void makeTransaction(double amt) {
        System.out.println("Paid ₹ " + amt + " using PayTM.");
    }
}

// Adapter for RazorPay
class RazorPayAdapter implements Payment {
    private RazorPay rpay = new RazorPay ();

    public void pay(double amount) {
        rpay.sendPayment(amount);
    }
}

// Adapter for PayTM
class PayTMAdapter implements Payment {
    private PayTM paytm = new PayTM();

    public void pay(double amount) {
        paytm.makeTransaction(amount);
    }
}

