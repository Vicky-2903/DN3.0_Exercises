package adapterPatternExample;
import java.util.*;
public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask the user for the payment gateways to test
        System.out.println("Enter payment gateways to test, separated by commas (e.g., paypal,stripe):");
        String input = scanner.nextLine();

        // Split the user input into a list of gateways
        List<String> gateways = Arrays.asList(input.split("\\s*,\\s*"));

        // Test processing payments through different gateways
        for (String gateway : gateways) {
            PaymentProcessor processor = PaymentProcessorFactory.getPaymentProcessor(gateway.trim());
            if (processor != null) {
                System.out.println("Testing with " + gateway + "...");
                processor.processPayment(100.00);
            } else {
                System.out.println("No processor found for " + gateway);
            }
        }

        scanner.close();
    }
}
