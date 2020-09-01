import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Interface moveInterface = new Interface();
        IO.open();
        moveInterface.run();
        IO.close();
        System.exit(0);
    }
}
