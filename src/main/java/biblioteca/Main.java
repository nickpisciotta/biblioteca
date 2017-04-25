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

        Library library = new Library(books);
        PrintStream stream = new PrintStream(System.out);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Command> menuOptions = new HashMap<>();
        menuOptions.put("1", new PrintLibraryCommand(library));
        QuitCommand quitCommand = new QuitCommand(stream);
        CheckoutBookCommand checkoutBookCommand = new CheckoutBookCommand(library, bufferedReader,stream);
        menuOptions.put("2", quitCommand);
        menuOptions.put("0", checkoutBookCommand);
        Menu menu = new Menu(System.out, bufferedReader, menuOptions);
        Application application = new Application(System.out, menu, quitCommand);

        application.start();
    }
}
