import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by birthright on 10.12.15.
 */
public class Main {
    private static class SupportClass implements Comparable<SupportClass> {
        private int length;
        private int count;
        private double medium;


        @Override
        public int compareTo(SupportClass o) {
            return Double.compare(this.medium, o.medium);
        }
    }

    public static void main(String[] args) throws ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);

        HashMap<String, Integer> voidCount = new HashMap<>();
        HashMap<String, Integer> parametersCount = new HashMap<>();
        HashMap<String, SupportClass> mediumNameMethodLength = new HashMap<>();
        HashMap<String, SupportClass> mediumParameterNameLength = new HashMap<>();


        for (int i = 0; i < 3; i++) {
            Class cl = Class.forName(scanner.next());
            Method[] methods = cl.getMethods();
            for (final Method method : methods) {
                if (method.isAnnotationPresent(author.class)) {
                    author annotation = method.getAnnotation(author.class);
                    String name = annotation.name();
                    if (!voidCount.containsKey(name)) {
                        voidCount.put(name, 0);
                    }
                    if (method.getReturnType().equals(Void.TYPE)) {
                        voidCount.computeIfPresent(name, (k, v) -> v + 1);
                    }
                    if (!parametersCount.containsKey(name)) {
                        parametersCount.put(name, 0);
                    }
                    parametersCount.computeIfPresent(name, (k, v) -> v + method.getParameterCount());
                    if (!mediumNameMethodLength.containsKey(name)) {
                        mediumNameMethodLength.put(name, new SupportClass());
                    }
                    SupportClass nameMethodsSup = mediumNameMethodLength.get(name);
                    nameMethodsSup.length += method.getName().length();
                    nameMethodsSup.count += 1;

                    if (!mediumParameterNameLength.containsKey(name)) {
                        mediumParameterNameLength.put(name, new SupportClass());
                    }
                    SupportClass paramSupport = mediumParameterNameLength.get(name);
                    Parameter[] parameters = method.getParameters();
                    for (Parameter parameter : parameters) {
                        paramSupport.count += 1;
                        paramSupport.length += parameter.toString().length();

                    }

                }
            }
        }
        mediumNameMethodLength.forEach((k, v) -> v.medium = (double) v.length / v.count);
        mediumParameterNameLength.forEach((k, v) -> v.medium = (double) v.length / v.count);


        System.out.println("The number of void functions");
        voidCount.entrySet().parallelStream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (x, y) -> {
                            throw new AssertionError();
                        },
                        LinkedHashMap::new
                )).forEach((k, v) -> System.out.println("Name: " + k + ", Count: " + v));
        System.out.println();

        System.out.println("The total number of parameters to write a function");
        parametersCount.entrySet().parallelStream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (x, y) -> {
                            throw new AssertionError();
                        },
                        LinkedHashMap::new
                )).forEach((k, v) -> System.out.println("Name: " + k + ", Count: " + v));
        System.out.println();

        System.out.println("The average length of the method name");
        mediumNameMethodLength.entrySet().parallelStream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (x, y) -> {
                            throw new AssertionError();
                        },
                        LinkedHashMap::new
                )).forEach((k, v) -> System.out.println("Name: " + k + ", Medium length: " + v.medium));
        System.out.println();

        System.out.println("The average length of a parameter name in the method");
        mediumParameterNameLength.entrySet().parallelStream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (x, y) -> {
                            throw new AssertionError();
                        },
                        LinkedHashMap::new
                )).forEach((k, v) -> System.out.println("Name: " + k + ", Medium length: " + v.medium));
        System.out.println();
    }
}
