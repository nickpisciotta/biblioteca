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
    UserInput userInput;
    Processor processor;
    Menu menu;

    @Before
    public void initialize() {
        menu = mock(Menu.class);;
        printStream = mock(PrintStream.class);
        userInput = mock(UserInput.class);
        processor = mock(Processor.class);
        application = new Application(printStream, userInput, processor, menu);
    }

    @Test
    public void shouldPrintWelcomeMessageWhenApplicationStarts() {
        application.start();

        verify(printStream).println("Welcome to Library!\n");
    }

    @Test
    public void shouldPrintMenuWhenApplicationStarts() {
        application.start();

        verify(printStream).println(contains("**********************\n" +
                "MAIN MENU\n" +
                "1 -- List Books\n" +
                "2 -- Quit\n" +
                "**********************\n" +
                "Input option number for selection:"));
    }

    @Test
    public void shouldFooWhenStarting() {
        application.start();

        verify(menu).chooseOptions();
    }








}