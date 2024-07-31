package decoratorPatternExample;
import java.util.*;
public class Test {
	public static void main(String[] args) {
        // Create base notifier (EmailNotifier)
        Notifier baseNotifier = new EmailNotifier();
        
        // List to hold dynamically added decorators
        List<NotifierDecorator> decorators = new ArrayList<>();
        
        // Create a scanner to get user input
        Scanner scanner = new Scanner(System.in);
        
        // Ask user which decorators to add
        System.out.println("Which decorators would you like to add? (Type 'SMS', 'Slack', or 'None')");
        String input;
        
        while (!(input = scanner.nextLine()).equalsIgnoreCase("None")) {
            switch (input.trim().toLowerCase()) {
                case "sms":
                    decorators.add(new SMSNotifierDecorator(baseNotifier));
                    baseNotifier = decorators.get(decorators.size() - 1); // Update baseNotifier
                    break;
                case "slack":
                    decorators.add(new SlackNotifierDecorator(baseNotifier));
                    baseNotifier = decorators.get(decorators.size() - 1); // Update baseNotifier
                    break;
                default:
                    System.out.println("Invalid input. Please enter 'SMS', 'Slack', or 'None'.");
            }
            
            System.out.println("Add another decorator or type 'None' to finish:");
        }
        
        // Send a message using the configured decorators
        System.out.println("Sending a message with all selected decorators...");
        baseNotifier.send("Hello, this is a dynamic test message.");
        
        // Close scanner
        scanner.close();
    }
}
