package biblioteca;

import com.sun.tools.javac.comp.Check;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.Assert.*;
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
    private PrintStream stream;

    @Before
    public void setup() {
        library = mock(Library.class);
        stream = mock(PrintStream.class);
        bufferedReader = mock(BufferedReader.class);
        checkOutBookCommand = new CheckoutBookCommand(library, bufferedReader, stream);
    }


    @Test
    public void shouldPromptUserToInputBookTitle() {
        checkOutBookCommand.execute();

        verify(stream).println("Enter book title");
    }

    @Test
    public void shouldRemoveChosenBookFromLibrary() throws IOException {
        when(bufferedReader.readLine()).thenReturn("foo");

        checkOutBookCommand.execute();

        verify(library).checkOut("foo");
    }

}