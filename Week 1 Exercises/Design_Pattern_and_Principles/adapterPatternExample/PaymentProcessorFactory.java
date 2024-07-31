package adapterPatternExample;

public class PaymentProcessorFactory {
	public static PaymentProcessor getPaymentProcessor(String gatewayType) {
        switch (gatewayType.toLowerCase()) {
            case "paypal":
                return new PayPalAdapter(new PayPalPayment());
            case "stripe":
                return new StripeAdapter(new StripePayment());
            // Add more cases for additional gateways
            default:
                throw new IllegalArgumentException("Unknown payment gateway type: " + gatewayType);
        }
    }
}
