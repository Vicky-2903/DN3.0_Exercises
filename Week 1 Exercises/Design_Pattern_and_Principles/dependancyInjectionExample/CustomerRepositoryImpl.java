package dependancyInjectionExample;

public class CustomerRepositoryImpl implements CustomerRepository {
	@Override
    public Customer findCustomerById(int id) {
        // For demonstration purposes, returning a dummy customer.
        // In a real application, this method would interact with a database.
        return new Customer(id, "John Doe", "john.doe@example.com");
    }
}
