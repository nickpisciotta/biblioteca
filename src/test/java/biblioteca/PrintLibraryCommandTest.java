package biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.PrintStream;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by npisciot on 4/25/17.
 */
public class PrintLibraryCommandTest {

    private Library library;
    private Command printLibraryCommand;
    private PrintStream printStream;

    @Before
    public void setUp() {
        library = mock(Library.class);
        printStream = mock(PrintStream.class);
        printLibraryCommand = new PrintLibraryCommand("0", "List Books", library, printStream);
    }

    @Test
    public void shouldPrintListOfBooksWhenPrintLibraryIsCalled() {
        printLibraryCommand.execute();

        verify(library).printLibrary();
    }

    @Test
    public void shouldPrintOutPrintLibraryCommandInMenuWhenExecuted() {
        printLibraryCommand.list();

        verify(printStream).println("0 -- List Books");
    }

}