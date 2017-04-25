package biblioteca;

import java.io.PrintStream;
import java.util.List;

public class Library {
    private final PrintStream printStream;
    private List<Book> books;

    public Library(List<Book> books, PrintStream printStream) {
        this.books = books;
        this.printStream = printStream;
    }

    public void printLibrary() {

        for (Book book : books) {
            book.printBookDetails();
        }
    }

    public void checkOut(String bookTitle) {
        Book removedBook = find(bookTitle);
        if (removedBook != null) {
            books.remove(removedBook);
            printStream.println("Thank you! Enjoy the book");
        } else {
            printStream.println("That book is not available.");
        }
    }

    private Book find(String bookTitle) {
        Book bookToRemove = null;
        for (Book book : books ) {
            if (book.hasTitle(bookTitle)) {
             bookToRemove = book;
            }
        }
        return bookToRemove;
    }
}
