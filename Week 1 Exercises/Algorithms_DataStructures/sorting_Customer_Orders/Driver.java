package sorting_Customer_Orders;

import java.util.*;

public class Driver {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter number of orders: ");
		int numberOfOrders = scanner.nextInt();
		scanner.nextLine(); // consume newline

		Order[] orders = new Order[numberOfOrders];

		for (int i = 0; i < numberOfOrders; i++) {
			System.out.print("Enter order ID: ");
			int orderId = scanner.nextInt();
			scanner.nextLine(); // consume newline
			System.out.print("Enter customer name: ");
			String customerName = scanner.nextLine();
			System.out.print("Enter total price: ");
			double totalPrice = scanner.nextDouble();
			scanner.nextLine(); // consume newline

			orders[i] = new Order(orderId, customerName, totalPrice);
		}

		System.out.println("\nBefore Sorting:");
		for (Order order : orders) {
			if (order != null) {
				System.out.println("Order ID: " + order.getOrderId() + ", Customer Name: " + order.getCustomerName()
						+ ", Total Price: " + order.getTotalPrice());
			}
		}

		System.out.println("\nAfter Bubble Sorting:");
		Order.bubbleSort(orders);
		for (Order order : orders) {
			if (order != null) {
				System.out.println("Order ID: " + order.getOrderId() + ", Customer Name: " + order.getCustomerName()
						+ ", Total Price: " + order.getTotalPrice());
			}
		}

		System.out.println("\nAfter Quick Sorting:");
		Order.quickSort(orders, 0, orders.length - 1);
		for (Order order : orders) {
			if (order != null) {
				System.out.println("Order ID: " + order.getOrderId() + ", Customer Name: " + order.getCustomerName()
						+ ", Total Price: " + order.getTotalPrice());
			}
		}

		scanner.close();
	}
}