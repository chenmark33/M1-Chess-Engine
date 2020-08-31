import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        ChessEngine engine = new ChessEngine();
        IO.open();
        engine.run();
        IO.close();
        System.exit(0);
    }
}
