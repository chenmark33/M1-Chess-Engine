import java.io.*;
import java.util.*;

public class ChessEngine {

    public ChessEngine() {
    }

    public void run() throws IOException {
        while (true) {
            if (!processInput()) break;
        }
    }

    public boolean processInput() throws IOException {
        List<String> userInput = IO.readStringsToArrayListSingleLine();
        if (userInput.isEmpty()) return false;
        String commandType = userInput.get(0);
        if (commandType.equals("quit")) {
            System.out.println("Quitting Engine");
            return false;
        }
        if (commandType.equals("uci")) {
            sendUCIResponse(userInput);
            return true;
        }
        return false;
    }

    public void sendUCIResponse(List<String> userInput) {
        System.out.println("Sending response");
    }
}
