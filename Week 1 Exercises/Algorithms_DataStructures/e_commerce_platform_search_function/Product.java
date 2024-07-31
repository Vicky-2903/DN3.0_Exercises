package e_commerce_platform_search_function;

public class Product {
	 private String productId;
	    private String productName;
	    private String category;

	    // Constructor
	    public Product(String productId, String productName, String category) {
	        this.productId = productId;
	        this.productName = productName;
	        this.category = category;
	    }

	    // Getter for productId
	    public String getProductId() {
	        return productId;
	    }

	    // Setter for productId
	    public void setProductId(String productId) {
	        this.productId = productId;
	    }

	    // Getter for productName
	    public String getProductName() {
	        return productName;
	    }

	    // Setter for productName
	    public void setProductName(String productName) {
	        this.productName = productName;
	    }

	    // Getter for category
	    public String getCategory() {
	        return category;
	    }

	    // Setter for category
	    public void setCategory(String category) {
	        this.category = category;
	    }

	    @Override
	    public String toString() {
	        return "Product{" +
	                "productId='" + productId + '\'' +
	                ", productName='" + productName + '\'' +
	                ", category='" + category + '\'' +
	                '}';
	    }
}
