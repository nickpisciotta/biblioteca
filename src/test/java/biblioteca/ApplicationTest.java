package biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.contains;
import static org.mockito.Mockito.times;


public class ApplicationTest {
    Library library;
    PrintStream printStream;
    Application application;
    InputStream inputStream;
    BufferedReader bufferedReader;

    @Before
    public void initialize() {
        printStream = mock(PrintStream.class);
        library = mock(Library.class);
        inputStream = mock(InputStream.class);
        bufferedReader = mock(BufferedReader.class);
        application = new Application(printStream, library, bufferedReader);
    }

    @Test
    public void shouldPrintWelcomeMessageWhenApplicationStarts() throws IOException {
        when(bufferedReader.readLine()).thenReturn("2");
        try {
            application.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
        verify(printStream).println("Welcome to Library!\n");
    }

    @Test
    public void shouldPrintLibraryWhenUserSelectsListBooks() throws IOException {
        when(bufferedReader.readLine()).thenReturn("1");
        application.start();
        //when(bufferedReader.readLine()).thenReturn("2");
        verify(library).printLibrary();

    }

    @Test
    public void shouldPrintErrorMessageWhenUserEntersInvalidOption() throws IOException {
        when(bufferedReader.readLine()).thenReturn("3");
        application.start();
        verify(printStream).println(contains("Select a valid option!"));
    }

    @Test
    public void shouldQuitApplicationWhenUserSelectsQuitOption() throws IOException {
        when(bufferedReader.readLine()).thenReturn("2");
        application.start();
        verify(printStream).println(contains("Quiting..."));
    }
}