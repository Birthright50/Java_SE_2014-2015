import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by birthright on 28.10.15.
 */
public class Server {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        String name = sc.nextLine();
        final int PORT = 3456;
        ServerSocket s = new ServerSocket(PORT);
        Socket client = s.accept();
        DataInputStream bis = new DataInputStream(new BufferedInputStream(client.getInputStream()));
        DataOutputStream bos = new DataOutputStream(new BufferedOutputStream(client.getOutputStream()));
        while (true) {
            String line = sc.nextLine();
            bos.writeUTF(name + ": " + line);
            bos.flush();
            String x = bis.readUTF();
            System.out.println(x);
        }
    }
}
