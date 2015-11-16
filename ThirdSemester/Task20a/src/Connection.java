import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

/**
 * Created by birthright on 09.11.15.
 */
public class Connection implements Runnable {
    Socket socket;
    Thread thread;
    Server server;


    @Override
    public void run() {

        try {
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            while (true) {
                Message message = (Message) in.readObject();
                if (message == null) {
                    System.out.println(Server.messages);
                    ArrayList<Message> custom = new ArrayList<>();
                    custom.addAll(Server.messages);
                    out.writeObject(custom);
                    out.flush();
                } else {
                    System.out.println(message);
                    Server.messages.add(message);
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }


    public Connection(Server server, Socket socket) {
        this.socket = socket;
        this.server = server;
        thread = new Thread(this);
        thread.start();
    }
}
