import java.util.ArrayList;
import java.util.Random;
import java.util.regex.Pattern;

/**
 * Created by Birthright on 17.09.2015.
 */
public class Task04b {
    public static void main(String[] args) {
        Random random = new Random();
        ArrayList<Integer> integerArrayList = new ArrayList<>(20);
        int customNumbers = 0;
        int allNumbers = 0;
        Pattern pattern = Pattern.compile("-?[02468]{4,5}");
        while (customNumbers < 10) {
            Integer number = random.nextInt();
            if (pattern.matcher(number.toString()).matches()) {
                integerArrayList.add(number);
                ++customNumbers;
            }
            ++allNumbers;
        }
        System.out.println("Amount of custom numbers : " + integerArrayList + "\n" + "Total numbers : " + allNumbers);

        pattern = Pattern.compile("^-?[02468]{4,5}$");
        customNumbers = 0;
        integerArrayList.clear();
        allNumbers = 0;
        while (customNumbers < 10) {
            Integer number = random.nextInt();
            if (pattern.matcher(number.toString()).find()) {
                integerArrayList.add(number);
                ++customNumbers;
            }
            ++allNumbers;
        }
        System.out.println("Amount of custom numbers : " + integerArrayList + "\n" + "Total numbers : " + allNumbers);

    }
}
