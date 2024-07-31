package library_Management_System;

import java.util.Arrays;
import java.util.List;

public class BookSearchUtility_BinarySearch {

    // Binary search method to find a book by title
    public static Book findBookByTitle(Book[] books, String title) {
        int left = 0;
        int right = books.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            Book midBook = books[mid];
            int cmp = midBook.getTitle().compareToIgnoreCase(title);

            if (cmp == 0) {
                return midBook;  // Title matches
            } else if (cmp < 0) {
                left = mid + 1;  // Search right half
            } else {
                right = mid - 1;  // Search left half
            }
        }

        return null;  // Title not found
    }

    // Overloaded method for List<Book>
    public static Book findBookByTitle(List<Book> books, String title) {
        return findBookByTitle(books.toArray(new Book[0]), title);
    }
}
