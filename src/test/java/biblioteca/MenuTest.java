package biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

import static org.mockito.ArgumentMatchers.contains;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


public class MenuTest {
    private Menu menu;
    private PrintStream stream;
    private BufferedReader bufferedReader;
    private Library library;
    private Map <String, Command> menuOptions;
    private QuitCommand quitCommand;
    private PrintLibraryCommand printLibraryCommand;


    @Before
    public void setUp() {
        stream = mock(PrintStream.class);
        bufferedReader = mock(BufferedReader.class);
        library = mock(Library.class);
        printLibraryCommand = mock(PrintLibraryCommand.class);
        quitCommand = mock(QuitCommand.class);
        menuOptions = new HashMap<>();
        menuOptions.put("1", printLibraryCommand);
        menuOptions.put("2", quitCommand);
        menu = new Menu(stream, bufferedReader, menuOptions);
    }

    @Test
    public void shouldPrintMenuWhenChooseOptions() {
        menu.chooseOptions();

        verify(stream).println(contains("**********************\n" +
                                                "MAIN MENU\n" +
                                                "1 -- List Books\n" +
                                                "2 -- Quit\n" +
                                                "**********************\n" +
                                                "Input option number for selection:"));
    }

    @Test
    public void shouldPrintLibraryWhenOptionOneIsSelected () throws IOException {
        when(bufferedReader.readLine()).thenReturn("1");

        menu.chooseOptions();

       verify(printLibraryCommand).execute();

    }

    @Test
    public void shouldPrintInvalidMessageWhenInvalidOptionIsSelected() throws IOException {
        when(bufferedReader.readLine()).thenReturn("5");

        menu.chooseOptions();

        verify(stream).println(contains("Select a valid option!"));
    }

    @Test
    public void shouldQuitWhenOptionTwoIsSelected() throws IOException {
        when(bufferedReader.readLine()).thenReturn("2");

        menu.chooseOptions();

        verify(quitCommand).execute();
    }

}