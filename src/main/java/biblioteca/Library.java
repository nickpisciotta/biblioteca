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

    public void checkOut(Book book) {
        books.remove(book);
    }
}
