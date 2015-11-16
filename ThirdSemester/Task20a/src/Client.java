import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

/**
 * Created by birthright on 28.10.15.
 */
public class Client {
    private static final int SERVER_PORT = 3456;


    public static void main(String[] args) {
        String host = "localhost";
        Socket socket;
        ArrayList<Message> client_messages = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter your name");
            final String name = bufferedReader.readLine();
            socket = new Socket(host, SERVER_PORT);
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            Message message;
            while (true) {
                String str = bufferedReader.readLine();
                if (str.length() == 0) {
                    out.writeObject(null);
                    out.flush();
                    ArrayList<Message> server_messages = (ArrayList<Message>) in.readObject();
                    server_messages.removeAll(client_messages);
                    client_messages.addAll(server_messages);
                    server_messages.forEach(System.out::println);
                } else {
                    message = new Message(name, str);
                    out.writeObject(message);
                    out.flush();
                }
            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}
