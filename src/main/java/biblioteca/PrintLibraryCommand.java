package biblioteca;


public class PrintLibraryCommand implements Command {

    private final Library library;

    public PrintLibraryCommand(Library library) {
        this.library = library;
    }

    public void execute() {
        library.printLibrary();
    }
}
