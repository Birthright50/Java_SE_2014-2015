import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * Created by Birthright on 02.05.2015.
 */
public class ThreadTime extends Thread {
    private String utc;

    public ThreadTime(String city, String utc) {
        super(city);
        this.utc = utc;
    }

    @Override
    public void run() {
        SimpleDateFormat sdf = new SimpleDateFormat("kk:mm:ss");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT" + this.utc));
        while (true) {
            System.out.println(getName() + ": " + sdf.format(new Date()));
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        ThreadTime[] a = new ThreadTime[n];
        for (int i = 0; i < n; i++) {
            a[i] = new ThreadTime(sc.nextLine(), sc.nextLine());
        }
        for (int i = 0; i < n; i++) {
            a[i].start();
            sleep(25);
        }

    }
}
