package biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.PrintStream;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.ArgumentMatchers.contains;


public class ApplicationTest {
    Library library;
    PrintStream printStream;
    Application application;
    InputStream inputStream;
    BufferedReader bufferedReader;
    Menu menu;
    private QuitCommand quitCommand;

    @Before
    public void initialize() {
        menu = mock(Menu.class);;
        printStream = mock(PrintStream.class);
        quitCommand = mock(QuitCommand.class);
        application = new Application(printStream, menu, quitCommand);
    }

    @Test
    public void shouldPrintWelcomeMessageWhenApplicationStarts() {
        application.start();

        verify(printStream).println("Welcome to Library!\n");
    }

    @Test
    public void shouldFooWhenStarting() {
        application.start();

        verify(menu).chooseOptions();
    }

}