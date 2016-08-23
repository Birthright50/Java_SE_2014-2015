import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by birthright on 28.10.15.
 */
public class Client {
    static Scanner sc = new Scanner(System.in);


    public static void main(String[] args) {
        new Client();
        int port = 3456;
        String host = "localhost";
        String name = sc.nextLine();
        Socket s;
        try {
            s = new Socket(host, port);
            DataInputStream bis = new DataInputStream(new BufferedInputStream(s.getInputStream()));
            DataOutputStream bos = new DataOutputStream(new BufferedOutputStream(s.getOutputStream()));
            while (true) {
                String serverCity = bis.readUTF();
                System.out.println(serverCity);
                Character lastChar = serverCity.charAt(serverCity.length() - 1);
                String myCity = sc.nextLine();
                while (Cities.cities.contains(myCity) || !Character.valueOf(myCity.toLowerCase().charAt(0)).equals(lastChar)) {
                    System.out.println("Wrong! Try again.");
                    myCity = sc.nextLine();
                }
                Cities.cities.add(myCity);
                bos.writeUTF(name + ": " + myCity);
                bos.flush();
                System.out.println("Right!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
