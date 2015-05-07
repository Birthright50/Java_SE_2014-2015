import java.util.Scanner;

/**
 * Created by Birthright on 06.05.2015.
 */
public class Task28c extends Thread {
    private int beginning;
    private int end;

    public Task28c(int beginning, int end) {
        this.beginning = beginning;
        this.end = end;
    }

    @Override
    public void run() {
        for (int i = beginning; i < end; i++) {
            sum += array[i];
        }
    }

    public static int sum;
    public static int[] array;

    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sum = 0;
        array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        Task28c one = new Task28c(0, n / 2);
        Task28c two = new Task28c(n / 2, n);
        one.start();
        two.start();
        one.join();
        two.join();
        System.out.println(sum);
    }
}
