import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Created by birthright on 28.10.15.
 */
public class Server {
    public static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
    volatile static ArrayList<Message> messages = new ArrayList<>();

    ArrayList<Connection> connections;
    final int PORT = 3456;

    public Server() throws IOException {
        connections = new ArrayList<>();
        go();
    }

    public void go() {
        ServerSocket serverSocket;
        try {
            serverSocket = new ServerSocket(PORT);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        while (true) {
            Socket client = null;
            try {
                client = serverSocket.accept();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Connected");
            connections.add(new Connection(this, client));
        }
    }

    public static void main(String[] args) throws IOException {
        new Server();
    }
}
