package decoratorPatternExample;

public class SMSNotifierDecorator extends NotifierDecorator {
	public SMSNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void send(String message) {
        super.send(message); // Call the original notifier
        sendSMS(message);    // Additional functionality
    }

    private void sendSMS(String message) {
        System.out.println("Sending SMS with message: " + message);
    }
}
