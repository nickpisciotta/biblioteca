package biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Main {
    public static void main(String[] args) throws IOException {

        Book book1 = new Book("Book1", "Author1", "2017", System.out);
        Book book2 = new Book("Book2", "Author2", "1999", System.out);
        List<Book> books = new ArrayList<>();
        books.add(book1);
        books.add(book2);

        PrintStream printStream = new PrintStream(System.out);
        Library library = new Library(books, printStream);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Command> menuOptions = new HashMap<>();
        menuOptions.put("0", new PrintLibraryCommand("0", "List Books", library, printStream));
        QuitCommand quitCommand = new QuitCommand("2","Quit", printStream);
        CheckoutBookCommand checkoutBookCommand = new CheckoutBookCommand("1", "Checkout Book", library, bufferedReader,printStream);
        menuOptions.put("2", quitCommand);
        menuOptions.put("1", checkoutBookCommand);
        Menu menu = new Menu(System.out, bufferedReader, menuOptions);
        Application application = new Application(System.out, menu, quitCommand);

        application.start();
    }
}
