import java.io.*;
import java.util.*;

public class MoveInterface extends Thread {
    private volatile boolean alive = true;

    /**
     * This method is the main interface from which the user enters commands to the engine
     * and is kept open while {@link MoveInterface#alive} is true. An invalid command
     * will set it to false by calling {@link MoveInterface#terminate()}.
     */
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

    /**
     * Sets {@link MoveInterface#alive} to false, causing {@link MoveInterface#run()} to terminate.
     */
    public void terminate() {
        this.alive = false;
    }

    /**
     * Returns true if the user enters a valid input.
     * Valid inputs start with either uci (followed by a series of commands denoting the desired actions)
     * or restart, which prompts the engine to start a new game.
     *
     * @return A boolean denoting if the user's input is valid or not
     * @throws IOException
     */
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

    /**
     * Sends the user's input to the engine for further processing/making a move.
     *
     * @param userInput The user's input, split by spaces.
     */
    public void sendUCIResponse(List<String> userInput) {
        System.out.println("Sending response... \n");
    }

    /**
     * Prompts the user to reset the board.
     *
     * @return A boolean if the user wants to reset the board.
     * @throws IOException
     */
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

    /**
     * Resets the board
     */
    public void resetBoard() {
        System.out.println("Resetting board...");
    }
}