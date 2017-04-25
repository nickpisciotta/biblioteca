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
    private PrintStream printStream;
    private BufferedReader bufferedReader;
    private Map <String, Command> menuOptions;
    private Command command1;


    @Before
    public void setUp() {
        printStream = mock(PrintStream.class);
        bufferedReader = mock(BufferedReader.class);
        command1 = mock(Command.class);
        menuOptions = new HashMap<>();
        menuOptions.put("1", command1);
        menu = new Menu(printStream, bufferedReader, menuOptions);
    }

    @Test
    public void shouldPrintMenuWhenChooseOptions() {
        menu.chooseOptions();

        verify(command1).list();
    }

    @Test
    public void shouldPrintLibraryWhenOptionOneIsSelected () throws IOException {
        when(bufferedReader.readLine()).thenReturn("1");

        menu.chooseOptions();

       verify(command1).execute();

    }

    @Test
    public void shouldPrintInvalidMessageWhenInvalidOptionIsSelected() throws IOException {
        when(bufferedReader.readLine()).thenReturn("5");

        menu.chooseOptions();

        verify(printStream).println(contains("Select a valid option!"));
    }
}