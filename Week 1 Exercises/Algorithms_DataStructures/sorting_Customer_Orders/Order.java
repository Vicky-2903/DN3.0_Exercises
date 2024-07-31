package sorting_Customer_Orders;

public class Order {
	private int orderId;
	private String customerName;
	private double totalPrice;

	public Order(int orderId, String customerName, double totalPrice) {
		this.orderId = orderId;
		this.customerName = customerName;
		this.totalPrice = totalPrice;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public void displayOrderDetails() {
		System.out.println("Order ID: " + orderId);
		System.out.println("Customer Name: " + customerName);
		System.out.println("Total Price: " + totalPrice);
	}

	public static void bubbleSort(Order[] orders) {
		int n = orders.length;
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - 1 - i; j++) {
				if (orders[j] != null && orders[j + 1] != null
						&& orders[j].getTotalPrice() > orders[j + 1].getTotalPrice()) {
					Order temp = orders[j];
					orders[j] = orders[j + 1];
					orders[j + 1] = temp;
				}
			}
		}
	}

	public static void quickSort(Order[] orders, int low, int high) {
		if (low < high) {
			int pi = partition(orders, low, high);

			quickSort(orders, low, pi - 1);
			quickSort(orders, pi + 1, high);
		}
	}

	// Partition method used by Quick Sort
	private static int partition(Order[] orders, int low, int high) {
		double pivot = orders[high].getTotalPrice();
		int i = (low - 1); // Index of smaller element

		for (int j = low; j < high; j++) {
			if (orders[j] != null && orders[j].getTotalPrice() <= pivot) {
				i++;

				// Swap orders[i] and orders[j]
				Order temp = orders[i];
				orders[i] = orders[j];
				orders[j] = temp;
			}
		}

		// Swap orders[i + 1] and orders[high] (or pivot)
		Order temp = orders[i + 1];
		orders[i + 1] = orders[high];
		orders[high] = temp;

		return i + 1;
	}

}
