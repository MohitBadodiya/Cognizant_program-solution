
public class DependencyInjectionExample{
    public static void main(String[] args) {
        // Inject repository into service via constructor
        CustomerRepository repo = new CustomerRepositoryImpl();
        CustomerService service = new CustomerService(repo);

        // Use service to find customer
        service.getCustomerById(101);
    }
}


interface CustomerRepository {
    String findCustomerById(int id);
}


class CustomerRepositoryImpl implements CustomerRepository {
    public String findCustomerById(int id) {
        return "Customer with ID: " + id + " found.";
    }
}


class CustomerService {
    private CustomerRepository repository;

    // Constructor Injection
    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public void getCustomerById(int id) {
        String result = repository.findCustomerById(id);
        System.out.println(result);
    }
}

