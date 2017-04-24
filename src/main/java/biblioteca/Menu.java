package biblioteca;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

public class Menu {

    private final PrintStream stream;
    private final BufferedReader bufferedReader;
    private Library library;

    public Menu(PrintStream stream, BufferedReader bufferedReader, Library library) {
        this.stream = stream;
        this.bufferedReader = bufferedReader;
        this.library = library;
    }

    public void chooseOptions() {
        printMenu();
        String userInput = readLine();

        Map<String, Command> menuOptions = new HashMap<>();
        menuOptions.put("1", new PrintLibraryCommand(library));
        menuOptions.get(userInput).execute();


//       else if (userInput.equals("2")) {
//            stream.println("Quiting...");
//        } else {
//            stream.println("Select a valid option!");
//        }
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
        String menu = "**********************";
        menu += "\nMAIN MENU\n";
        menu += "1 -- List Books\n2 -- Quit";
        menu += "\n**********************\n";
        menu += "Input option number for selection:";
        stream.println(menu);
    }
}
