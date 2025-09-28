import java.io.*;

public class ThrowsExample {

    // Method declares that it may throw an IOException
    static void readFile() throws IOException {
        // Attempt to open a file that does not exist
        FileReader fr = new FileReader("nonexistent.txt");
        BufferedReader br = new BufferedReader(fr);

        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }

        br.close();
    }

    public static void main(String[] args) {
        try {
            readFile(); // Calling method that may throw IOException
        } catch (IOException e) {
            System.out.println("File not found or cannot be read.");
            System.out.println("Exception Message: " + e.getMessage());
        }
    }
}