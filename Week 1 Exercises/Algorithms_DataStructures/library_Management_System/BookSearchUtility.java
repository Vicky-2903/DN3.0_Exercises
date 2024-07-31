package library_Management_System;

import java.util.ArrayList;
import java.util.List;

public class BookSearchUtility {
	// Method to perform linear search by title
    public static List<Book> findBooksByTitle(List<Book> bookList, String title) {
        List<Book> foundBooks = new ArrayList<>();
        
        // Iterate over each book in the array
        for (Book book : bookList) {
            // Check if the book's title matches the search title
            if (book.getTitle().equalsIgnoreCase(title)) {
                foundBooks.add(book);
            }
        }
        
        return foundBooks;
    }
}
