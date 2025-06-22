import java.util.*;

// Class to store book details
class Book {
    int bookId;
    String title;
    String author;

    Book(int id, String title, String author) {
        this.bookId = id;
        this.title = title;
        this.author = author;
    }

    void display() {
        System.out.println(bookId + " | " + title + " | " + author);
    }
}

public class LibrarySystem {
    static Book[] books = {
        new Book(1, "Java Basics", "Amit"),
        new Book(2, "C Programming", "Neha"),
        new Book(3, "Data Structures", "Rahul"),
        new Book(4, "Python Intro", "Priya")
    };

    // Linear Search by title
    static void linearSearch(String title) {
        for (Book b : books) {
            if (b.title.equalsIgnoreCase(title)) {
                System.out.println("Book Found:");
                b.display();
                return;
            }
        }
        System.out.println("Book Not Found");
    }

    // Binary Search by title (array must be sorted)
    static void binarySearch(String title) {
        int left = 0, right = books.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int cmp = books[mid].title.compareToIgnoreCase(title);
            if (cmp == 0) {
                System.out.println("Book Found:");
                books[mid].display();
                return;
            } else if (cmp < 0)
                left = mid + 1;
            else
                right = mid - 1;
        }
        System.out.println("Book Not Found");
    }

    public static void main(String[] args) {
        System.out.println("Linear Search:");
        linearSearch("Python Intro");

        // Sort books by title for binary search
        Arrays.sort(books, (a, b) -> a.title.compareToIgnoreCase(b.title));

        System.out.println("\nBinary Search:");
        binarySearch("Python Intro");
    }
}

