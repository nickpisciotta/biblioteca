package biblioteca;

import java.util.List;

public class Library {
    private List<Book> books;

    public Library(List<Book> books) {
        this.books = books;
    }

    public void printLibrary() {

        for (Book book : books) {
            book.printBookDetails();
        }
    }

    public void checkOut(String bookTitle) {
        Book removedBook = find(bookTitle);
        if (removedBook) {
            books.remove(removedBook);
            stream.println("Thank you! Enjoy the book");
        } else {
            stream.println("That book is not available."); rgetharhs5yj5jtyjd
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
