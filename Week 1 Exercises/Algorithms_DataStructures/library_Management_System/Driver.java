package library_Management_System;

import java.util.*;

public class Driver {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter the number of books: ");
		int numBooks = scanner.nextInt();
		scanner.nextLine(); // Consume the newline

		List<Book> bookList = new ArrayList<>();

		for (int i = 0; i < numBooks; i++) {
			System.out.print("Enter book ID: ");
			int bookId = scanner.nextInt();
			scanner.nextLine(); // Consume the newline

			System.out.print("Enter book title: ");
			String title = scanner.nextLine();

			System.out.print("Enter book author: ");
			String author = scanner.nextLine();

			bookList.add(new Book(bookId, title, author));
		}

		// Sort the list by title
		bookList.sort((b1, b2) -> b1.getTitle().compareToIgnoreCase(b2.getTitle()));

		System.out.print("Enter the title of the book to search for: ");
		String searchTitle = scanner.nextLine();

		System.out.print("Choose search method (1 for Binary Search, 2 for Linear Search): ");
		int searchMethod = scanner.nextInt();
		scanner.nextLine(); // Consume the newline

		if (searchMethod == 1) {
			// Binary search
			Book foundBook = BookSearchUtility_BinarySearch.findBookByTitle(bookList, searchTitle);
			if (foundBook != null) {
				System.out.println("Book found: " + foundBook);
			} else {
				System.out.println("Book not found.");
			}
		} else if (searchMethod == 2) {
			// Linear search
			List<Book> foundBooks = BookSearchUtility.findBooksByTitle(bookList, searchTitle);
			if (!foundBooks.isEmpty()) {
				System.out.println("Books found:");
				for (Book book : foundBooks) {
					System.out.println(book);
				}
			} else {
				System.out.println("Book not found.");
			}
		} else {
			System.out.println("Invalid search method selected.");
		}

		scanner.close();
	}
}
