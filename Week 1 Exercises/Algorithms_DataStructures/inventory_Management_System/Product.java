package inventory_Management_System;

public class Product {
	// Attributes
	private int productId;
	private String productName;
	private int quantity;
	private double price;

	// Default constructor
	public Product() {
	}

	// Parameterized constructor
	public Product(int productId, String productName, int quantity, double price) {
		this.productId = productId;
		this.productName = productName;
		this.quantity = quantity;
		this.price = price;
	}

	// Getter and Setter for productId
	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	// Getter and Setter for productName
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	// Getter and Setter for quantity
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	// Getter and Setter for price
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	// Method to display product details
	@Override
	public String toString() {
		return "Product{" + "productId=" + productId + ", productName='" + productName + '\'' + ", quantity=" + quantity
				+ ", price=" + price + '}';
	}
}
