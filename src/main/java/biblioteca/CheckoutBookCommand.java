package biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Created by npisciot on 4/24/17.
 */
public class CheckoutBookCommand implements Command {

    private Library library;
    private BufferedReader bufferedReader;
    private PrintStream stream;


    public CheckoutBookCommand(Library library, BufferedReader bufferedReader, PrintStream stream) {
        this.library = library;
        this.bufferedReader = bufferedReader;
        this.stream = stream;
    }

    public void execute() {
        stream.println("Enter book title");
        String bookTitle = ""; 
        try {
            bookTitle = bufferedReader.readLine();    
        } catch (IOException e) {
            e.getStackTrace();
        }
        library.checkOut(bookTitle);
    }
}
