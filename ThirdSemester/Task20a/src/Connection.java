import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
                int count = message.getCount();
                if (count > -1) {
                    ArrayList<Message> custom = new ArrayList<>();
                    System.out.println(Server.messages);
                    for (int i = count; i < Server.messages.size(); i++) {
                        custom.add(Server.messages.get(i));
                    }
                    Messages messages = new Messages(custom);
                    out.writeObject(messages);
                    out.flush();
                } else {
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
