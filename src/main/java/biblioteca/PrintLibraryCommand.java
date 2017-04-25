package biblioteca;


import java.io.PrintStream;

public class PrintLibraryCommand implements Command {

    private final Library library;
    private final String name;
    private String commandKey;
    private PrintStream printStream;

    public PrintLibraryCommand(String commandKey, String name, Library library, PrintStream printStream) {
        this.commandKey = commandKey;
        this.name = name;
        this.library = library;
        this.printStream = printStream;
    }

    public void execute() {
        library.printLibrary();
    }


    @Override
    public void list() {
        printStream.println(commandKey + " -- " + name);
    }

}
