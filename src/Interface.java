import java.io.*;
import java.util.*;

public class Interface extends Thread {
    private volatile boolean alive = true;

    public Interface() {
    }

    public void run() {
        while (alive) {
            System.out.println("Available Commands: ");
            System.out.println("uci ... (send UCI input to Engine)");
            System.out.println("quit (quits the engine and exits the program)");
            System.out.println("restart (restarts the engine and resets the board)");
            System.out.print("Enter commands: ");
            try {
                if (!validInput()) {
                    terminate();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void terminate() {
        this.alive = false;
    }

    public boolean validInput() throws IOException {
        List<String> userInput = IO.readStringsToArrayListSingleLine();
        if (userInput.isEmpty()) return false;
        String commandType = userInput.get(0);

        if (commandType.equals("quit")) {
            System.out.println("Quitting Engine...");
            return false;
        }
        else if (commandType.equals("uci")) {
            sendUCIResponse(userInput);
            return true;
        }
        else if (commandType.equals("restart")) {
            return promptResetBoard();
        }
        return false;
    }

    public void sendUCIResponse(List<String> userInput) {
        System.out.println("Sending response... \n");
    }

    public boolean promptResetBoard() throws IOException {
        System.out.println("Are you sure you want to restart? (Y/N): ");
        String userInput = IO.s();
        userInput = userInput.toLowerCase().strip();
        if (userInput.equals("y")) {
            System.out.println("Restarting engine and resetting board... \n");
            resetBoard();
        }
        System.out.println();
        return true;
    }

    public void resetBoard() {

    }
}
