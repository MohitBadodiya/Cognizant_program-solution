class Employee {
    int id;
    String name;
    String post;
    double salary;

    Employee(int id, String name, String post, double salary) {
        this.id = id;
        this.name = name;
        this.post = post;
        this.salary = salary;
    }

    void show() {
        System.out.println(id + " | " + name + " | " + post + " | ₹" + salary);
    }
}

public class EmployeeSystem {
    static Employee[] list = new Employee[100];
    static int total = 0;

    // Add new employee
    static void add(Employee e) {
        list[total++] = e;
    }

    // Show all employees
    static void displayAll() {
        for (int i = 0; i < total; i++) {
            list[i].show();
        }
    }

    // Search by ID
    static void search(int id) {
        for (int i = 0; i < total; i++) {
            if (list[i].id == id) {
                System.out.println("Employee Found:");
                list[i].show();
                return;
            }
        }
        System.out.println("Employee Not Found");
    }

    // Delete by ID
    static void delete(int id) {
        for (int i = 0; i < total; i++) {
            if (list[i].id == id) {
                // Shift elements
                for (int j = i; j < total - 1; j++) {
                    list[j] = list[j + 1];
                }
                list[--total] = null;
                System.out.println("Employee Deleted");
                return;
            }
        }
        System.out.println("Employee Not Found");
    }

    public static void main(String[] args) {
        add(new Employee(1, "Aman", "Manager", 57000));
        add(new Employee(2, "Nisha", "Developer", 45000));
        add(new Employee(3, "Ramesh", "Tester", 32000));

        System.out.println("All Employees:");
        displayAll();

        System.out.println("\nSearch Employee with ID 2:");
        search(2);

        System.out.println("\nDelete Employee with ID 1:");
        delete(1);

        System.out.println("\nAfter Deletion:");
        displayAll();
    }
}

