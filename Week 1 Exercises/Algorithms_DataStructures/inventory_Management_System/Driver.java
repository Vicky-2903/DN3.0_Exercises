package inventory_Management_System;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nInventory Management System");
            System.out.println("1. Add Product");
            System.out.println("2. Update Product");
            System.out.println("3. Delete Product");
            System.out.println("4. Display All Products");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice;
            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline left-over
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Clear the invalid input
                continue;
            }

            switch (choice) {
                case 1:
                    // Add Product
                    System.out.print("Enter product ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    System.out.print("Enter product name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter quantity: ");
                    int quantity = scanner.nextInt();

                    System.out.print("Enter price: ");
                    double price = scanner.nextDouble();

                    Product newProduct = new Product(id, name, quantity, price);
                    inventory.addProduct(newProduct);
                    break;

                case 2:
                    // Update Product
                    System.out.print("Enter product ID to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    System.out.print("Enter new product name: ");
                    String updateName = scanner.nextLine();

                    System.out.print("Enter new quantity: ");
                    int updateQuantity = scanner.nextInt();

                    System.out.print("Enter new price: ");
                    double updatePrice = scanner.nextDouble();

                    Product updatedProduct = new Product(updateId, updateName, updateQuantity, updatePrice);
                    inventory.updateProduct(updatedProduct);
                    break;

                case 3:
                    // Delete Product
                    System.out.print("Enter product ID to delete: ");
                    int deleteId = scanner.nextInt();
                    inventory.deleteProduct(deleteId);
                    break;

                case 4:
                    // Display All Products
                    System.out.println("All Products:");
                    inventory.displayProducts();
                    break;

                case 5:
                    // Exit
                    running = false;
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        }

        scanner.close();
    }
}