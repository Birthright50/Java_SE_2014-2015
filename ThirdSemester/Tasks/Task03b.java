import java.util.ArrayList;
import java.util.Random;
import java.util.regex.Pattern;

/**
 * Created by Birthright on 17.09.2015.
 */
public class Task03b {
    public static void main(String[] args) {
        Random random = new Random();
        ArrayList<Integer> integerArrayList = new ArrayList<>(20);
        int notThreeNumbersInRow = 0;
        int allNumbers = 0;
        Pattern pattern = Pattern.compile("-?(([13579]+([02468]{0,2}|[02468]{4,}))+)|(([02468]{0,2}|[02468]{4,})[13579]+)+");
        while (notThreeNumbersInRow < 10) {
            Integer number = random.nextInt();
            if (pattern.matcher(number.toString()).matches()) {
                ++notThreeNumbersInRow;
                integerArrayList.add(number);
            }
            ++allNumbers;
        }
        System.out.println("Amount of not three numbers in a row : " + integerArrayList + "\n" + "Total numbers : " + allNumbers);
        pattern = Pattern.compile("[13579]([02468]{3})[13579]");
        notThreeNumbersInRow = 0;
        allNumbers = 0;
        integerArrayList.clear();
        while (notThreeNumbersInRow < 10) {
            Integer number = random.nextInt();
            if (!pattern.matcher(number.toString()).find()) {
                ++notThreeNumbersInRow;
                integerArrayList.add(number);
            }
            ++allNumbers;
        }
        System.out.println("Amount of not three numbers in a row : " + integerArrayList + "\n" + "Total numbers : " + allNumbers);
    }
}
