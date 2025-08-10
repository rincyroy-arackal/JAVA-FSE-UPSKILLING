import java.util.Arrays;
import java.util.Comparator;

class Book {
    int bookId;
    String title;
    String author;

    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book(" + bookId + ", " + title + ", " + author + ")";
    }
}

public class LibraryManager {

    // Linear Search
    public static Book linearSearch(Book[] books, String title) {
        for (Book b : books) {
            if (b.title.equalsIgnoreCase(title)) {
                return b;
            }
        }
        return null;
    }

    // Binary Search (Assumes sorted by title)
    public static Book binarySearch(Book[] books, String title) {
        int left = 0, right = books.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int cmp = books[mid].title.compareToIgnoreCase(title);

            if (cmp == 0) return books[mid];
            else if (cmp < 0) left = mid + 1;
            else right = mid - 1;
        }

        return null;
    }

    // Display all books
    public static void displayBooks(Book[] books) {
        for (Book b : books) {
            System.out.println(b);
        }
    }

    public static void main(String[] args) {
        Book[] books = {
            new Book(101, "Java Programming", "James Gosling"),
            new Book(102, "Data Structures", "Mark Allen"),
            new Book(103, "Operating Systems", "Andrew Tanenbaum"),
            new Book(104, "Algorithms", "Robert Sedgewick"),
            new Book(105, "Database Systems", "C.J. Date")
        };

        System.out.println("All Books:");
        displayBooks(books);

        System.out.println("\n🔎 Linear Search for 'Algorithms':");
        Book found1 = linearSearch(books, "Algorithms");
        System.out.println(found1 != null ? found1 : "Book not found");

        // Sort books by title before binary search
        Arrays.sort(books, Comparator.comparing(b -> b.title.toLowerCase()));

        System.out.println("\n🔍 Binary Search for 'Algorithms':");
        Book found2 = binarySearch(books, "Algorithms");
        System.out.println(found2 != null ? found2 : "Book not found");
    }
}
