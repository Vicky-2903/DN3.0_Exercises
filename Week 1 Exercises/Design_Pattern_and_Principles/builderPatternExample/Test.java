package builderPatternExample;

import java.util.*;

public class Test {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// Get CPU
		System.out.print("Enter CPU: ");
		String cpu = scanner.nextLine();

		// Get RAM
		System.out.print("Enter RAM (in GB): ");
		int ram = scanner.nextInt();

		// Get Storage
		System.out.print("Enter Storage (in GB): ");
		int storage = scanner.nextInt();

		// Get Graphics Card
		System.out.print("Does it have a Graphics Card? (yes/no): ");
		scanner.nextLine(); // Consume newline
		String hasGraphicsCardInput = scanner.nextLine();
		boolean hasGraphicsCard = hasGraphicsCardInput.equalsIgnoreCase("yes");

		// Create Computer instance using the Builder pattern
		Computer userPC = new Computer.Builder().setCPU(cpu).setRAM(ram).setStorage(storage)
				.setGraphicsCard(hasGraphicsCard).build();

		// Print details of the created computer
		System.out.println("\nYour Computer Configuration:");
		System.out.println("CPU: " + userPC.getCPU());
		System.out.println("RAM: " + userPC.getRAM() + " GB");
		System.out.println("Storage: " + userPC.getStorage() + " GB");
		System.out.println("Graphics Card: " + (userPC.hasGraphicsCard() ? "Yes" : "No"));

		// Close the scanner
		scanner.close();
	}

}
