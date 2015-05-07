import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Birthright on 06.05.2015.
 */
public class Task28b extends Thread {
    private int beginning;
    private int end;

    @Override
    public void run() {
        for (int i = beginning; i < end; i++) {
            sum += array[i];
        }
    }

    public Task28b(int beginning, int end) {
        this.beginning = beginning;
        this.end = end;
    }

    static int[] array;
    static int sum;

    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        sum = 0;
        array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        ArrayList<Task28b> arrayList = new ArrayList<>();
        int s = 0;
        int m = n / k;
        int l = n / k;
        for (int i = 0; i < k - 1; i++) {
            arrayList.add(new Task28b(s, l));
            s += m;
            l += m;
        }
        arrayList.add(new Task28b(s, n));
        for (Task28b b : arrayList) {
            b.start();
        }
        for (Task28b b : arrayList) {
            b.join();
        }
        System.out.println(sum);
    }
}
