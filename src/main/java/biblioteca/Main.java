package biblioteca;

import jdk.internal.util.xml.impl.Input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args

    ) throws IOException {

        Book book1 = new Book("Book1", "Author1", "2017", System.out);
        Book book2 = new Book("Book2", "Author2", "1999", System.out);
        List<Book> books = new ArrayList<>();
        books.add(book1);
        books.add(book2);


        Library library = new Library(books);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Application application = new Application(System.out, library, bufferedReader);
        try {
            application.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
