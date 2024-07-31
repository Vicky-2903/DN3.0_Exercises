package e_commerce_platform_search_function;
import java.util.*;
public class Driver {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read number of products
        System.out.print("Enter number of products: ");
        int numProducts = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        // Create and populate products array
        Product[] products = new Product[numProducts];
        for (int i = 0; i < numProducts; i++) {
            System.out.print("Enter product ID: ");
            String id = scanner.nextLine();
            System.out.print("Enter product name: ");
            String name = scanner.nextLine();
            System.out.print("Enter product category: ");
            String category = scanner.nextLine();
            products[i] = new Product(id, name, category);
        }

        // Sort products for binary search
        Arrays.sort(products, (p1, p2) -> p1.getProductId().compareTo(p2.getProductId()));

        // Perform linear search
        System.out.print("Enter product ID to search using linear search: ");
        String linearSearchId = scanner.nextLine();
        Product linearSearchResult = LinearSearch.search(products, linearSearchId);
        if (linearSearchResult != null) {
            System.out.println("Linear Search: Product found: " + linearSearchResult);
        } else {
            System.out.println("Linear Search: Product not found.");
        }

        // Perform binary search
        System.out.print("Enter product ID to search using binary search: ");
        String binarySearchId = scanner.nextLine();
        Product binarySearchResult = BinarySearch.search(products, binarySearchId);
        if (binarySearchResult != null) {
            System.out.println("Binary Search: Product found: " + binarySearchResult);
        } else {
            System.out.println("Binary Search: Product not found.");
        }
        
        scanner.close();
    }
}
