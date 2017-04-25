package biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

public class LibraryTest {
    Library library;
    PrintStream printStream;
    List<Book> books;
    private Book book1;
    private Book book2;

    @Before
    public void initialize() {
        printStream = mock(PrintStream.class);
        books = new ArrayList<Book>();
        book1 = new Book("Book1", "Author1", "2017", printStream);
        book2 = new Book("Book2", "Author2", "1999", printStream);
        books.add(book1);
        books.add(book2);
        library = new Library(books);
    }


    @Test
    public void shouldPrintListOfBooksWhenPrintLibraryIsCalled() {
        library.printLibrary();

        verify(printStream).println(contains("Book1 -- Author1 -- 2017"));
        verify(printStream).println(contains("Book2 -- Author2 -- 1999"));
    }

    @Test
    public void shouldRemoveChosenBookWhenBookIsCheckedOut() {
        library.checkOut("Book1");

        assertThat(books, not(hasItem(book1)));
    }


}