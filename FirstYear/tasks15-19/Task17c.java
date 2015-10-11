import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedHashMap;
import java.util.Scanner;

/**
 * Created by birthright on 20.03.15.
 */
public class Task17c {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("text.txt"));
        LinkedHashMap<Character, Integer> numberOfLetters = new LinkedHashMap<Character, Integer>();
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            for (int i = 0; i < line.length(); ++i) {
                char c = line.charAt(i);
                if (Character.isLetter(c)) {
                    if (numberOfLetters.containsKey(c)) {
                        numberOfLetters.put(c, numberOfLetters.get(c) + 1);
                    } else {
                        numberOfLetters.put(c, 1);
                    }
                }
            }
        }
        System.out.println(numberOfLetters);
    }
}
