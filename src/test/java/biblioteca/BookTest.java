package biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.contains;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


public class BookTest {
    PrintStream printStream;

    @Before
    public void initialize() {
        printStream = mock(PrintStream.class);
    }

    @Test
    public void shouldPrintBookDetailsWhenBookIsCalled() {
        Book book1 = new Book("Title1", "Author1", "2017", printStream);
        book1.printBookDetails();
        verify(printStream).println(contains("Title1 -- Author1 -- 2017"));
    }
}