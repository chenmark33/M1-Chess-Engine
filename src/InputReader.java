import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class InputReader {
    static BufferedReader reader;
    static StringTokenizer tokenizer;
    static BufferedWriter writer;

    /**
     * Constructor method to initialize the reader for input stream
     * @return void
     */
    static void open() {
        reader = new BufferedReader(new InputStreamReader(System.in));
        writer = new BufferedWriter(new OutputStreamWriter(System.out));
        tokenizer = new StringTokenizer("");
    }

    /**
     * Closes BufferedReader. Flushes and closes BufferedWriter
     * @return void
     */
    static void close() throws IOException {
        reader.close();
        writer.flush();
        writer.close();
    }

    /**
     * Prints to standard output
     * @return void
     */
    static void w(Object o) throws IOException {
        writer.write(o.toString());
    }

    /**
     * Gets the next word
     * @return String
     */
    static String next() throws IOException {
        while (!tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(reader.readLine());
        }
        return tokenizer.nextToken();
    }

    /**
     * Read in an integer
     * @return integer
     */
    static int i() throws IOException {
        return Integer.parseInt(next());
    }

    /**
     * Read in a string
     * @return String
     */
    static String s() throws IOException{
        return next();
    }

    /**
     * Read one line as Strings into an ArrayList.
     * @return ArrayList<String>
     */
    static ArrayList<String> readStringsToArrayListSingleLine() throws IOException {
        ArrayList<String> list = new ArrayList<>();
        String str = null;
        String[] vals;

        str = InputReader.reader.readLine();
        if (str == null || str.length() == 0) return list;
        vals = str.split(" ");

        for (int i = 0, valsLength = vals.length; i < valsLength; i++) {
            String s = vals[i];
            list.add(s);
        }
        return list;
    }
}
