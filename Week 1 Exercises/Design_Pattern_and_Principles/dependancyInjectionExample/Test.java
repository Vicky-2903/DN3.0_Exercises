package dependancyInjectionExample;
import java.util.Scanner;
public class Test {
	public static void main(String[] args) {
		// Create an instance of CustomerRepositoryImpl
		CustomerRepository customerRepository = new CustomerRepositoryImpl();

		// Inject the repository instance into CustomerService
		CustomerService customerService = new CustomerService(customerRepository);

		// Create a scanner to read input from the user
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter customer ID to search: ");
		int customerId = scanner.nextInt();

		// Use the service to find a customer
		Customer customer = customerService.getCustomerById(customerId);

		if (customer != null) {
			// Print the customer details
			System.out.println("Customer ID: " + customer.getId());
			System.out.println("Customer Name: " + customer.getName());
			System.out.println("Customer Email: " + customer.getEmail());
		} else {
			System.out.println("Customer not found.");
		}

		// Close the scanner
		scanner.close();
	}

}
