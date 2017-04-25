package biblioteca;

import java.io.PrintStream;

public class QuitCommand implements Command, Runner {
    private String name;
    private final PrintStream printStream;
    private boolean continueApplication;
    private String commandKey;

    public QuitCommand( String commandKey, String name, PrintStream printStream) {
        this.commandKey = commandKey;
        this.name = name;
        this.printStream = printStream;
        this.continueApplication = true;
    }

    public void execute() {
        printStream.println("Quitting");
        continueApplication = false;
    }

    @Override
    public void list() {
        printStream.println(commandKey + " -- " + name);
    }

    @Override
    public boolean shouldContinue() {
        return continueApplication;
    }
}
