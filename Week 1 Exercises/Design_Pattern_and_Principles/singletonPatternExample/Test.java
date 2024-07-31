package singletonPatternExample;

public class Test {
	public static void main(String[] args) {
        // Get two instances of Logger
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();
        
        // Log messages using both instances
        logger1.log("This is a message from logger1.");
        logger2.log("This is a message from logger2.");

        // Check if both instances are the same
        if (logger1 == logger2) {
            System.out.println("Both logger1 and logger2 are the same instance.");
        } else {
            System.out.println("logger1 and logger2 are different instances.");
        }
    }
}
