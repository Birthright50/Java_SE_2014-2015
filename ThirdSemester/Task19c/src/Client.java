import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by birthright on 28.10.15.
 */
public class Client {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int port = 3456;
        String host = "localhost";
        String name = sc.nextLine();
        Socket s;
        try {

            s = new Socket(host, port);
            DataInputStream bis = new DataInputStream(new BufferedInputStream(s.getInputStream()));
            DataOutputStream bos = new DataOutputStream(new BufferedOutputStream(s.getOutputStream()));

            while (true) {

                String x = bis.readUTF();
                System.out.println(x);
                bos.writeUTF(name + ": " + sc.nextLine());
                bos.flush();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
