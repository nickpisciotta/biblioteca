package biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) throws IOException {

        Book book1 = new Book("Book1", "Author1", "2017", System.out);
        Book book2 = new Book("Book2", "Author2", "1999", System.out);
        List<Book> books = new ArrayList<>();
        books.add(book1);
        books.add(book2);


        Library library = new Library(books);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        UserInput userInput = new UserInput(bufferedReader);
        Processor processor = new Processor(library, System.out);
        Menu menu = new Menu(System.out, bufferedReader, library);
        Application application = new Application(System.out, userInput, processor, menu);

        application.start();
    }
}
