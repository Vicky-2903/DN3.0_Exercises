package decoratorPatternExample;

public class SlackNotifierDecorator extends NotifierDecorator {
	public SlackNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void send(String message) {
        super.send(message); // Call the original notifier
        sendSlack(message);  // Additional functionality
    }

    private void sendSlack(String message) {
        System.out.println("Sending Slack message with message: " + message);
    }
}
