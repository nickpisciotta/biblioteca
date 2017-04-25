package biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static junit.framework.TestCase.assertFalse;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class QuitCommandTest {

    private PrintStream printStream;
    private QuitCommand quitCommand;

    @Before
    public void setUp() {
        printStream = mock(PrintStream.class);
        quitCommand = new QuitCommand("2", "Quit", printStream);
    }

   @Test
    public void shouldPrintQuittingWhenApplicationWhenCommandedToQuit() {
       quitCommand.execute();

       verify(printStream).println("Quitting");
   }

   @Test
    public void shouldTellProcessorWhenToQuit() {
       quitCommand.execute();

       assertFalse(quitCommand.shouldContinue());
   }

   @Test
    public void shouldPrintCommandDetailsInMenuWhenExecuted() {
        quitCommand.list();

        verify(printStream).println("2 -- Quit");
   }
}