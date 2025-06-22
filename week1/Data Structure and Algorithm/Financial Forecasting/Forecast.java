public class Forecast {

    // Recursive method to calculate future value
    static double predict(double amount, double growth, int years) {
        if (years == 0)  // Stop when years become 0
            return amount;
        return predict(amount * (1 + growth), growth, years - 1);
    }

    public static void main(String[] args) {
        double current = 10000;   // Starting amount
        double rate = 0.10;       // 10% growth rate
        int time = 5;             // Number of years

        double futureValue = predict(current, rate, time);
        System.out.println("Value after " + time + " years: ₹" + futureValue);
    }
}

