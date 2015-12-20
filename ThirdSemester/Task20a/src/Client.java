import java.io.*;
import java.net.Socket;

/**
 * Created by birthright on 28.10.15.
 */
public class Client {
    private static final int SERVER_PORT = 3456;
    static int messagesCount = 0;

    public static void main(String[] args) {
        String host = "localhost";
        Socket socket;

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
                    out.writeObject(new Message("", "", messagesCount));
                    out.flush();
                    Messages my_messages = (Messages) in.readObject();
                    my_messages.getMessages().forEach(System.out::println);
                    messagesCount += my_messages.getMessages().size();
                } else {
                    message = new Message(name, str, -1);
                    out.writeObject(message);
                    out.flush();
                }
            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}
