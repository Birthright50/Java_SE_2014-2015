import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;

/**
 * Created by Birthright on 28.11.2015.
 */
public class Server {
    public volatile static ArrayList<String> names;
    public volatile static ArrayList<ClientRoomThread> connections;
    final int PORT = 3456;

    public Server() throws IOException {
        connections = new ArrayList<>();
        names = new ArrayList<>();
        go();
    }

    public void go() {
        ServerSocket serverSocket;
        try {
            serverSocket = new ServerSocket(PORT);
            while (true) {
                Socket client = serverSocket.accept();
                System.out.println("Connected");
                ClientRoomThread crt = new ClientRoomThread(client);
                Thread thread = new Thread(crt);
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        new Server();
    }

    private class ClientRoomThread implements Runnable {
        private ObjectInputStream ois;
        private ObjectOutputStream ous;
        private ObjectOutputStream enemyOutputStream;
        private String name;

        public ClientRoomThread(Socket socket) {
            try {
                ous = new ObjectOutputStream(socket.getOutputStream());
                ois = new ObjectInputStream(socket.getInputStream());
            } catch (IOException ignored) {
            }
        }

        @Override
        public void run() {
            try {
                connections.add(this);
                ous.writeObject(names);
                ous.flush();
                this.name = ois.readUTF();
                ous.writeObject(names);
                ous.flush();
                names.add(this.name);
                System.out.println(names);
                String choose = ois.readUTF();
                if (!choose.equals(Client.NEW_ROOM)) {
                    for (ClientRoomThread clientRoomThread : connections) {
                        if (clientRoomThread.name.equals(choose)) {
                            this.enemyOutputStream = clientRoomThread.ous;
                            clientRoomThread.enemyOutputStream = this.ous;

                            break;
                        }
                    }
                }
                while (true) {
                  //TODO
                }
            } catch (SocketException e) {
                names.remove(this.name);
                connections.remove(this);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

}

