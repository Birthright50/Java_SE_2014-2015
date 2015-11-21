import java.io.*;
import java.net.Socket;
import java.util.Random;

/**
 * Created by Birthright on 22.11.2015.
 */
public class Client {
    private static final int SERVER_PORT = 3456;

    public enum State implements Serializable {
        BLACK, WHITE
    }

    private static State myState;
    static Random random = new Random();

    public static void main(String[] args) {
        String host = "localhost";
        Socket socket;

        try {

            socket = new Socket(host, SERVER_PORT);
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

            while (true) {
                boolean pass = in.readBoolean();
                if (pass) {
                    //TODO, открыть диалоговое окно
                }
                State enemy_state = (State) in.readObject();
                int x = in.readInt();
                int y = in.readInt();
                printState(x, y, enemy_state); //нарисовать полученный камень

                x = random.nextInt(19);
                y = random.nextInt(19);
                pass = random.nextBoolean();
                out.writeBoolean(pass);
                out.writeObject(myState);
                out.writeInt(x);
                out.writeInt(y);
                out.flush();


            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

    private static void printState(int x, int y, State p0) {

    }
}
