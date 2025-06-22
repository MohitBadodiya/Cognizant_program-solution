
import java.util.*;

// Order class to store order details
class Order {
    int orderId;
    String customerName;
    double totalPrice;

    Order(int orderId, String customerName, double totalPrice) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
    }

    void show() {
        System.out.println(orderId + " | " + customerName + " | ₹" + totalPrice);
    }
}

public class OrderSortDemo {

    // Bubble Sort by totalPrice
    static void bubbleSort(Order[] orders) {
        int n = orders.length;
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                if (orders[j].totalPrice > orders[j+1].totalPrice) {
                    Order temp = orders[j];
                    orders[j] = orders[j+1];
                    orders[j+1] = temp;
                }
            }
        }
    }

    // Quick Sort by totalPrice
    static void quickSort(Order[] orders, int low, int high) {
        if (low < high) {
            int p = partition(orders, low, high);
            quickSort(orders, low, p-1);
            quickSort(orders, p+1, high);
        }
    }

    static int partition(Order[] orders, int low, int high) {
        double pivot = orders[high].totalPrice;
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (orders[j].totalPrice < pivot) {
                i++;
                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }
        Order temp = orders[i+1];
        orders[i+1] = orders[high];
        orders[high] = temp;
        return i+1;
    }

    public static void main(String[] args) {
        Order[] orders = {
            new Order(1, "Aman", 4300),
            new Order(2, "Nisha", 4500),
            new Order(3, "Ram", 1500),
            new Order(4, "Sourabh", 2200)
        };

        // Bubble Sort test
        bubbleSort(orders);
        System.out.println("Orders by Bubble Sort:");
        for (Order o : orders) o.show();

        // Quick Sort test
        quickSort(orders, 0, orders.length-1);
        System.out.println("\nOrders by Quick Sort:");
        for (Order o : orders) o.show();
    }
}
