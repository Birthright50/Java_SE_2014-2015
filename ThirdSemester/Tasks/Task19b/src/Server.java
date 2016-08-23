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
        String first_city = sc.nextLine();
        Cities.cities.add(first_city);
        bos.writeUTF(name + ": " + first_city);
        bos.flush();
        while (true) {
            String clientCity = bis.readUTF();
            System.out.println(clientCity);
            String myCity = sc.nextLine();
            Character lastChar = clientCity.charAt(clientCity.length() - 1);
            while (Cities.cities.contains(myCity) || !Character.valueOf(myCity.toLowerCase().charAt(0)).equals(lastChar)) {
                System.out.println("Wrong! Try again.");
                myCity = sc.nextLine();
            }
            Cities.cities.add(myCity);
            bos.writeUTF(name + ": " + myCity);
            bos.flush();
            System.out.println("Right!");
        }
    }
}
