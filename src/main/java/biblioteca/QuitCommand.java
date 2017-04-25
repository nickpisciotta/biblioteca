package biblioteca;

import java.io.PrintStream;

public class QuitCommand implements Command, Runner {
    private final PrintStream stream;
    private boolean continueApplication;

    public QuitCommand(PrintStream stream) {
        this.stream = stream;
        this.continueApplication = true;
    }

    public void execute() {
        stream.println("Quitting");
        continueApplication = false;
    }

    @Override
    public boolean shouldContinue() {
        return continueApplication;
    }
}
