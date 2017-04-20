package biblioteca;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Application {
    private PrintStream printStream;
    private Library library;
    private BufferedReader bufferedReader;
    private int userSelectedOption;

    public Application(PrintStream printStream, Library library, BufferedReader bufferedReader) {
        this.printStream = printStream;
        this.library = library;
        this.bufferedReader = bufferedReader;
    }

    private void printWelcomeMessage() {
        printStream.println("Welcome to Library!\n");
    }

    public void processMainMenuOptionsSelection() throws IOException {
        do {
            printStream.println("\n**********************");
            printStream.println("MAIN MENU\n");
            printStream.println("1 -- List Books\n2 -- Quit");
            printStream.println("**********************\n");
            printStream.println("Input option number for selection:");
            String userInput = bufferedReader.readLine();
            userSelectedOption = Integer.parseInt(userInput);
            if (userSelectedOption == 1) {
                library.printLibrary();
            } else if (userSelectedOption != 1 && userSelectedOption != 2) {
                printStream.println("Select a valid option!");
            }
            printStream.println("\nChoose another option.");
        } while (userSelectedOption != 2);
        printStream.println("Quiting...");
    }

    public void start() throws IOException {
        printWelcomeMessage();
        processMainMenuOptionsSelection();
    }
}
