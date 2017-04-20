package biblioteca;


import java.io.PrintStream;

public class Book {
    public String title;
    public String author;
    public String yearPublished;
    private PrintStream printStream;

    public Book(String title, String author, String yearPublished, PrintStream printStream) {
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
        this.printStream = printStream;
    }

    public void printBookDetails() {
        printStream.println(title + " -- " + author + " -- " + yearPublished);
    }

}
