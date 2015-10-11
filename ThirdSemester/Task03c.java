import java.util.ArrayList;
import java.util.Random;
import java.util.regex.Pattern;

/**
 * Created by Birthright on 17.09.2015.
 */
public class Task03c {
    public static void main(String[] args) {
        Random random = new Random();
        ArrayList<Integer> integerArrayList = new ArrayList<>(20);
        int evenNumber = 0;
        int allNumbers = 0;
        Pattern pattern = Pattern.compile("-?([02468])|([1-9][0-9]*[02468])");
        while (evenNumber < 10) {
            Integer number = random.nextInt();
            if (pattern.matcher(number.toString()).matches()) {
                ++evenNumber;
                integerArrayList.add(number);
            }
            ++allNumbers;
        }
        System.out.println("Amount of even numbers : " + integerArrayList + "\n" + "Total numbers : " + allNumbers);
    }
}
