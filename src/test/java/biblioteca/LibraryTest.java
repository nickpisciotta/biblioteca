package biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.io.PrintStream;

import static org.mockito.Mockito.*;

public class LibraryTest {
    Library library;
    PrintStream printStream;
    List<Book> books;

    @Before
    public void initialize() {
        printStream = mock(PrintStream.class);
        books = new ArrayList<Book>();
    }


    @Test
    public void shouldPrintListOfBooksWhenPrintLibraryIsCalled() {
        Book book1 = new Book("Book1", "Author1", "2017", printStream);
        Book book2 = new Book("Book2", "Author2", "1999", printStream);
        books.add(book1);
        books.add(book2);
        library = new Library(books);
        library.printLibrary();
        verify(printStream).println(contains("Book1 -- Author1 -- 2017"));
        verify(printStream).println(contains("Book2 -- Author2 -- 1999"));
    }

    @Test
    public void shouldNotPrintBookWhenBookIsCheckedOut() {
        Book book1 = new Book("Book1", "Author1", "2017", printStream);
        Book book2 = new Book("Book2", "Author2", "1999", printStream);
        books.add(book1);
        books.add(book2);
        library = new Library(books);

        library.checkOut(book1);
        library.printLibrary();
        verify(printStream).println("Book2 -- Author2 -- 1999");
    }

}