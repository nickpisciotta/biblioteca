package biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Created by npisciot on 4/24/17.
 */
public class CheckoutBookCommand implements Command {

    private final String name;
    private Library library;
    private BufferedReader bufferedReader;
    private PrintStream printStream;
    private String commandKey;


    public CheckoutBookCommand(String commandKey, String name, Library library, BufferedReader bufferedReader, PrintStream printStream) {
        this.commandKey = commandKey;
        this.name = name;
        this.library = library;
        this.bufferedReader = bufferedReader;
        this.printStream = printStream;
    }

    public void execute() {
        printStream.println("Enter book title");
        String bookTitle = ""; 
        try {
            bookTitle = bufferedReader.readLine();    
        } catch (IOException e) {
            e.getStackTrace();
        }
        library.checkOut(bookTitle);
    }

    @Override
    public void list() {
        printStream.println(commandKey + " -- " + name);
    }
}
