package chat;

import java.net.ServerSocket;
import java.net.Socket;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Server {
    private static List<PrintWriter> clients = Collections.synchronizedList(new ArrayList<>());

    public static void main(String[] args) throws IOException {
        int port = args.length > 0 ? Integer.parseInt(args[0]) : 12345;

        ServerSocket serverSocket = new ServerSocket(port); //cria serverSocket na porta 12345
        System.out.println("Servidor rodando na porta " + port);

        while (true) {
            Socket socket = serverSocket.accept(); //aceita a conexão

            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            clients.add(out);
            new Thread(() -> handle(socket, out)).start();
        }
    }

    private static void handle(Socket socket, PrintWriter out) {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            String line;
            while ((line = in.readLine()) != null) {
                String msg = socket.getInetAddress().getHostAddress() + ": " + line;
                broadcast(msg);
            }
        } catch (IOException e) {
        } finally {
            clients.remove(out);
            try { socket.close(); } catch (IOException e) {}
        }
    }

    private static void broadcast(String message) {
        synchronized (clients) {
            for (PrintWriter pw : clients) pw.println(message);
        }
        ChatLogger.log(message);
    }
}
