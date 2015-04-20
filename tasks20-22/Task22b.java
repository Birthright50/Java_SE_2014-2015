package DZ;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Created by Birthright on 19.04.2015.
 */
public class Task22b {
    static LinkedHashMap<String, ArrayList<String>> map = new LinkedHashMap<>();
    static Scanner sc = new Scanner(System.in);


    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("in.txt"));
        while (scanner.hasNext()) {
            String notTerminals[] = scanner.nextLine().split(" ");
            String transitions[] = notTerminals[1].split("\\|");
            ArrayList<String> list = new ArrayList<>();
            Collections.addAll(list, transitions);
            map.put(notTerminals[0], list);
        }
        int n = sc.nextInt();
        counter = 0;
        showWords(map.entrySet().iterator().next().getKey(), n);
    }

    static int counter;

    public static void showWords(String nodeWord, int n) {
        int index = -1;
        for (Map.Entry<String, ArrayList<String>> elem : map.entrySet()) {
            do {
                index = nodeWord.indexOf(elem.getKey(), index + 1);
                if (nodeWord.contains(elem.getKey())) {
                    for (String listElem : elem.getValue()) {
                        if (index != -1) {
                            String word = nodeWord.substring(0, index) +
                                    listElem + nodeWord.substring(index +
                                    elem.getKey().length());
                            boolean q = true;
                            for (Map.Entry<String, ArrayList<String>> a : map.entrySet()) {
                                if (word.contains(a.getKey())) {
                                    q = false;
                                    break;
                                }
                            }
                            if (counter < n) {
                                if (q) {
                                    System.out.println(word);
                                    counter++;
                                }
                                showWords(word, n);
                            } else {
                                return;
                            }
                        }
                    }
                }
            } while (index != -1);
        }
    }
}
