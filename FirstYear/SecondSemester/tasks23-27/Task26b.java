import java.io.*;
import java.util.Scanner;

/**
 * Created by Birthright on 02.05.2015.
 */
public class Task26b {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Scanner sc = new Scanner(System.in);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("out.txt"));
        for (int i = 0; i < 10; i++) {
            Graph s = new Graph(sc.nextInt(), sc.nextInt());
            objectOutputStream.writeObject(s);
        }
        sc.close();
        objectOutputStream.close();
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("out.txt"));
        for (int i = 0; i < 10; i++) {
            Graph a = (Graph) objectInputStream.readObject();
            if (a.getV() % 2 == 0) {
                System.out.println(a);
            }
        }
        objectInputStream.close();
    }
}
