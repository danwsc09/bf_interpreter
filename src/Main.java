import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    private final static int BUFFER_SIZE = 30_000;
    public static void main(String[] args) throws IOException {
        char[] buffer = new char[BUFFER_SIZE];
        int pointer = 0;
        if (args.length != 1) {
            System.out.println("Usage: java Main" + " <filename>");
        }

        String filename = args[0];

        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String currentLine = reader.readLine();
        reader.close();

        System.out.println("Done!");
    }

}
