package financialForecasting;
import java.util.Scanner;
public class Driver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get user input
        System.out.print("Enter the present value: ");
        double initialAmount = scanner.nextDouble();

        System.out.print("Enter the annual growth rate (as a decimal): ");
        double annualRate = scanner.nextDouble();

        System.out.print("Enter the number of years: ");
        int years = scanner.nextInt();

        // Calculate future value
        double futureValue = FutureValuePrediction.computeFutureValue(initialAmount, annualRate, years);

        // Output result
        System.out.printf("The future value after %d years is: %.2f%n", years, futureValue);

        scanner.close();
    }

}
