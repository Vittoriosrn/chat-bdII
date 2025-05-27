package chat;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class ChatLogger {
    private static PrintWriter writer;
    static {
        try {
            writer = new PrintWriter(new FileOutputStream("messages.txt", true), true);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static synchronized void log(String message) {
        writer.println(message);
    }
}
