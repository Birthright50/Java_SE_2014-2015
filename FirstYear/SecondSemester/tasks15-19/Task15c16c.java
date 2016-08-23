import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Created by Birthright on 19.03.2015.
 */
public class Task15c16c {

    public static boolean checkName(String string) {
        return string.length() != 0 && ((string.charAt(0) <= 'Я') && (string.charAt(0) >= 'А'));
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("11405.txt"));
        scanner.nextLine();
        scanner.nextLine();
        ArrayList<String> tasks = new ArrayList<>();
        LinkedHashMap<String, ArrayList<String>> students = new LinkedHashMap<>();
        while (scanner.hasNextLine()) {
            String q = scanner.nextLine().trim();
            String[] o = q.split("\t");
            if (checkName(q)) {
                if (students.containsKey(o[0])) {
                    ArrayList<String> marks = students.get(o[0]);
                    marks.addAll(Arrays.asList(o).subList(1, o.length));
                } else {
                    ArrayList<String> marks = new ArrayList<>();
                    marks.addAll(Arrays.asList(o).subList(1, o.length));
                    students.put(o[0], marks);
                }
            } else {
                Collections.addAll(tasks, o);
            }
        }
        tasks.remove(tasks.size() - 1);
        for (Object o : students.entrySet()) {
            System.out.println(o);
        }
        System.out.println();
        LinkedHashMap<String, Integer> resolvedTasks = new LinkedHashMap<>();
        for (Map.Entry<String, ArrayList<String>> a : students.entrySet()) {
            Integer l = 0;
            for (String x : a.getValue()) {
                if (x.equals("1")) {
                    l++;
                }
            }
            resolvedTasks.put(a.getKey(), l);
        }
        System.out.println(resolvedTasks);
        System.out.println();
        LinkedHashMap<String, Double> average = new LinkedHashMap<>();
        for (Map.Entry<String, ArrayList<String>> a : students.entrySet()) {
            Double l = 0.0;
            for (String x : a.getValue()) {
                if (!x.equals(".")) {
                    l += Double.valueOf(x);
                }
            }
            l /= tasks.size();
            average.put(a.getKey(), l);
        }
        System.out.println(average);
        System.out.println();
        LinkedHashMap<String, Integer> numbOfStudents = new LinkedHashMap<String, Integer>();
        Integer i = 0;
        for (String x : tasks) {
            Integer s = 0;
            for (Map.Entry<String, ArrayList<String>> a : students.entrySet()) {
                if ((a.getValue().get(i).equals("1"))) {
                    s++;
                }
            }
            numbOfStudents.put(x, s);
            i++;
        }
        i = 0;
        System.out.println(numbOfStudents);
        System.out.println();
        LinkedHashMap<String, Double> averageForTask = new LinkedHashMap<String, Double>();
        for (String x : tasks) {
            Double s = 0.0;
            for (Map.Entry<String, ArrayList<String>> a : students.entrySet()) {
                if (!(a.getValue().get(i).equals(".")) && Double.parseDouble(a.getValue().get(i)) != 0) {
                    s += Double.parseDouble(a.getValue().get(i));
                }
            }
            averageForTask.put(x, s/students.size());
            i++;
        }
        System.out.println(averageForTask);
    }
}
