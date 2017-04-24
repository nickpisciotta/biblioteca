package biblioteca;

import java.io.PrintStream;

public class Processor {
    private final Library library;
    private final PrintStream stream;
    private boolean continueSelecting = true;

    public Processor(Library library, PrintStream stream) {
       this.library = library;
       this.stream = stream;
    }

    public void processOption(String userResponse) {
        if (userResponse.equals("1")) {
            library.printLibrary();
            stream.println("\nChoose another option.");
        } else if (userResponse.equals("2")) {
            System.out.println();
            stream.println("Quiting...");
            continueSelecting  = false;
        } else {
            stream.println("Select a valid option!");
            stream.println("\nChoose another option.");
        }
    }

    public boolean shouldContinueSelecting() {
        return continueSelecting;
    }
}
