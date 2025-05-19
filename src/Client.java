import java.net.Socket;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.IOException;

public class Client {
    public static void main(String[] args) throws IOException {
        if (args.length < 1) return;
        String host = args[0];
        int port = args.length > 1 ? Integer.parseInt(args[1]) : 12345;
        Socket socket = new Socket(host, port);
        System.out.println("Conectado em " + host + ":" + port);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        new Thread(() -> {
            try {
                String response;
                while ((response = in.readLine()) != null) {
                    System.out.println(response);
                }
            } catch (IOException e) {
            }
        }).start();

        String line;
        while ((line = console.readLine()) != null) {
            out.println(line);
        }
        socket.close();
    }
}
