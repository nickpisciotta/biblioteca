package biblioteca;

import org.junit.Test;

import java.io.PrintStream;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

/**
 * Created by jsum on 4/19/17.
 */
public class MainTest {

        @Test
    public void should() {
            PrintStream printStream = mock (PrintStream.class);
            new Main();
        }
}