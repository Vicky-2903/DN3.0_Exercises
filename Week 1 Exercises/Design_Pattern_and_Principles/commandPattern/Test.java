package commandPattern;

import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		// Create a receiver
		Light light = new Light();

		// Create command objects
		Command lightOn = new LightOnCommand(light);
		Command lightOff = new LightOffCommand(light);

		// Create an invoker
		RemoteControl remote = new RemoteControl();

		// Scanner for user input
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("Enter command (on/off/exit): ");
			String input = scanner.nextLine().trim().toLowerCase();

			switch (input) {
			case "on":
				remote.setCommand(lightOn);
				remote.pressButton();
				break;
			case "off":
				remote.setCommand(lightOff);
				remote.pressButton();
				break;
			case "exit":
				System.out.println("Exiting...");
				scanner.close();
				return;
			default:
				System.out.println("Invalid command. Please enter 'on', 'off', or 'exit'.");
			}
		}
	}

}
