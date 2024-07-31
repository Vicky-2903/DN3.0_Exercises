package singletonPatternExample;

public class Logger {
	private static Logger instance;

	// Private constructor to prevent instantiation
	private Logger() {
		// Initialization code here
	}

	// Public static method to provide access to the instance
	public static Logger getInstance() {
		if (instance == null) {
			// Synchronize block to ensure thread safety
			synchronized (Logger.class) {
				if (instance == null) {
					instance = new Logger();
				}
			}
		}
		return instance;
	}

	// Example method to log messages
	public void log(String message) {
		System.out.println("Log: " + message);
	}
}
