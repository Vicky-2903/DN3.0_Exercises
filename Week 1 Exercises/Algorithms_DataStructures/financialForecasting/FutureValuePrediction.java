package financialForecasting;
import java.util.*;
public class FutureValuePrediction {
    private static final Map<Integer, Double> cache = new HashMap<>();

    // Method to compute the future value of an investment
    public static double computeFutureValue(double initialAmount, double annualRate, int years) {
        if (years == 0) {
            return initialAmount;
        }

        if (cache.containsKey(years)) {
            return cache.get(years);
        }

        double result = computeFutureValue(initialAmount * (1 + annualRate), annualRate, years - 1);
        cache.put(years, result);

        return result;
    }
}
