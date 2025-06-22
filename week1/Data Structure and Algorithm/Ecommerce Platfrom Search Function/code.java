import java.util.*;
class Product {
    int id;
    String name;
    String category;

    Product(int id, String name, String category) {
        this.id = id;
        this.name = name;
        this.category = category;
    }
}

public class Searchfun {

    // Linear Search
    static int linearSearch(Product[] items, String target) {
        for (int i = 0; i < items.length; i++) {
            if (items[i].name.equalsIgnoreCase(target))
                return i;
        }
        return -1;
    }

    // Binary Search (on sorted array)
    static int binarySearch(Product[] items, String target) {
        int left = 0, right = items.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int cmp = items[mid].name.compareToIgnoreCase(target);
            if (cmp == 0) return mid;
            else if (cmp < 0) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        Product[] list = {
            new Product(101, "Laptop", "Electronics"),
            new Product(102, "Shirt", "Clothing"),
            new Product(103, "Shoes", "Footwear"),
            new Product(104, "Mobile", "Electronics")
        };

        // Linear Search
        int idx = linearSearch(list, "Shoes");
        if (idx != -1)
            System.out.println("Found at index " + idx + " (Linear)");
        else
            System.out.println("Not found (Linear)");

        // Sort for Binary Search
        Arrays.sort(list, (a, b) -> a.name.compareToIgnoreCase(b.name));

        // Binary Search
        idx = binarySearch(list, "Shoes");
        if (idx != -1)
            System.out.println("Found at index " + idx + " (Binary)");
        else
            System.out.println("Not found (Binary)");
    }
}

