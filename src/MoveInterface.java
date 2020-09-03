import java.io.*;
import java.util.*;

public class MoveInterface extends Thread {
    private volatile boolean alive = true;

    @Override
    public void run() {
        InputReader.open();

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

        try {
            InputReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void terminate() {
        this.alive = false;
    }

    public boolean validInput() throws IOException {
        List<String> userInput = InputReader.readStringsToArrayListSingleLine();
        if (userInput.isEmpty()) return false;
        String commandType = userInput.get(0);
        if (commandType.equals("uci")) {
            sendUCIResponse(userInput);
            return true;
        }
        else if (commandType.equals("restart")) {
            return promptResetBoard();
        }
        System.out.println("Quitting Engine...");
        return false;
    }

    public void sendUCIResponse(List<String> userInput) {
        System.out.println("Sending response... \n");
    }

    public boolean promptResetBoard() throws IOException {
        System.out.println("Are you sure you want to reset the board? (Y/N): ");
        String userInput = InputReader.s();
        userInput = userInput.toLowerCase().strip();
        if (userInput.equals("y")) {
            resetBoard();
        }
        System.out.println();
        return true;
    }

    public void resetBoard() {
        System.out.println("Resetting board...");
    }
}