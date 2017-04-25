package biblioteca;

import org.junit.Before;
import org.junit.Test;

import javax.annotation.processing.Processor;
import java.io.PrintStream;

import static junit.framework.TestCase.assertFalse;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class QuitCommandTest {

    private PrintStream stream;
    private QuitCommand quitCommand;

    @Before
    public void setUp() {
        stream = mock(PrintStream.class);
        quitCommand = new QuitCommand(stream);
    }

   @Test
    public void shouldPrintQuittingWhenApplicationWhenCommandedToQuit() {
       quitCommand.execute();

       verify(stream).println("Quitting");
   }

   @Test
    public void shouldTellProcessorWhenToQuit() {
       quitCommand.execute();

       assertFalse(quitCommand.shouldContinue());
   }
}