import java.util.*;

class Product {
    int productId;
    String productName;
    int quantity;
    double price;

    Product(int id, String name, int qty, double price) {
        this.productId = id;
        this.productName = name;
        this.quantity = qty;
        this.price = price;
    }

    void display() {
        System.out.println(productId + " | " + productName + " | " + quantity + " | ₹" + price);
    }
}

public class Inventory{
    static HashMap<Integer, Product> inventory = new HashMap<>();

    // Add Product
    static void addProduct(Product p) {
        inventory.put(p.productId, p);
    }

    // Update Product
    static void updateProduct(int id, int newQty, double newPrice) {
        if (inventory.containsKey(id)) {
            Product p = inventory.get(id);
            p.quantity = newQty;
            p.price = newPrice;
        }
    }

    // Delete Product
    static void deleteProduct(int id) {
        inventory.remove(id);
    }

    // Display All Products
    static void displayAll() {
        for (Product p : inventory.values()) {
            p.display();
        }
    }

    public static void main(String[] args) {
        addProduct(new Product(1, "Laptop", 10, 50000));
        addProduct(new Product(2, "Mobile", 20, 15000));

        System.out.println("All Products:");
        displayAll();

        updateProduct(2, 25, 14500);
        System.out.println("\nAfter Update:");
        displayAll();

        deleteProduct(1);
        System.out.println("\nAfter Deletion:");
        displayAll();
    }
}

