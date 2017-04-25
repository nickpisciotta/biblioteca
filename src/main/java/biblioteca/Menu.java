package biblioteca;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Map;

public class Menu {

    private final PrintStream printStream;
    private final BufferedReader bufferedReader;
    private final Map<String, Command> menuOptions;

    public Menu(PrintStream printStream, BufferedReader bufferedReader, Map<String, Command> menuOptions) {
        this.printStream = printStream;
        this.bufferedReader = bufferedReader;
        this.menuOptions = menuOptions;
    }

    public void chooseOptions() {
        printMenu();
        String userInput = readLine();
        if (menuOptions.containsKey(userInput)) {
            menuOptions.get(userInput).execute();
        } else {
            printStream.println("Select a valid option!");
        }
    }

    private String readLine() {
        String userInput = "";
        try {
            userInput = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return userInput;
    }

    private void printMenu() {
        printStream.println("Input Option Number For Selection");
        for (Command command : menuOptions.values()) {
            command.list();
        }
    }
}
