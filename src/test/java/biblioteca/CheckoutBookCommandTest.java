package biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

/**
 * Created by npisciot on 4/24/17.
 */
public class CheckoutBookCommandTest {
    private Library library;
    private CheckoutBookCommand checkOutBookCommand;
    private BufferedReader bufferedReader;
    private Book book;
    private PrintStream printStream;

    @Before
    public void setup() {
        library = mock(Library.class);
        printStream = mock(PrintStream.class);
        bufferedReader = mock(BufferedReader.class);
        checkOutBookCommand = new CheckoutBookCommand("1", "Checkout Book", library, bufferedReader, printStream);
    }


    @Test
    public void shouldPromptUserToInputBookTitle() {
        checkOutBookCommand.execute();

        verify(printStream).println("Enter book title");
    }

    @Test
    public void shouldRemoveChosenBookFromLibrary() throws IOException {
        when(bufferedReader.readLine()).thenReturn("foo");

        checkOutBookCommand.execute();

        verify(library).checkOut("foo");
    }

    @Test
    public void shouldPrintCommandDetailsInMenuWhenExecuted() {
        checkOutBookCommand.list();

        verify(printStream).println("1 -- Checkout Book");
    }
}