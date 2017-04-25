package biblioteca;


import java.io.PrintStream;

public class Application {
    private final Menu menu;
    private Runner quitCommand;
    private PrintStream printStream;


    public Application(PrintStream printStream, Menu menu, Runner quitCommand) {
        this.printStream = printStream;
        this.menu = menu;
        this.quitCommand = quitCommand;
    }

    public void processMainMenuOptionsSelection()  {
        do {
            menu.chooseOptions();
        } while (quitCommand.shouldContinue());
    }

    public void start() {
        printWelcomeMessage();
        processMainMenuOptionsSelection();
    }

    private void printWelcomeMessage() {
        printStream.println("Welcome to Library!\n");
    }

}
