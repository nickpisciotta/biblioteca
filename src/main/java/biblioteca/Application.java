package biblioteca;


import java.io.PrintStream;

public class Application {
    private final UserInput userInput;
    private final Processor processor;
    private final Menu menu;
    private PrintStream printStream;


    public Application(PrintStream printStream, UserInput userInput, Processor processor, Menu menu) {
        this.printStream = printStream;
        this.userInput = userInput;
        this.processor = processor;
        this.menu = menu;
    }

    public void processMainMenuOptionsSelection()  {
        do {
//            printMenu();
//            String userResponse = userInput.readLine();
//            processor.processOption(userResponse);
            menu.chooseOptions();
        } while (processor.shouldContinueSelecting());
    }

    public void start() {
        printWelcomeMessage();
        processMainMenuOptionsSelection();
    }

    private void printWelcomeMessage() {
        printStream.println("Welcome to Library!\n");
    }

}
