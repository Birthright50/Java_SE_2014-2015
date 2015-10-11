import java.util.Scanner;

/**
 * Created by BirthrightL on 11.11.2014.
 */
public class Student {
    private String fio;
    private int year;

    public Student(String s, int y) {
        fio = s;
        year = y;
    }

    public static void studentInfo() {
        System.out.println("Это всего лишь метод " +
                "для демонстрации static");
    }


    public String getFio() {
        return fio;
    }

    public void greet(Student s) {
        System.out.println(fio +
                        " приветствует студента с именем " +
                        s.getFio()
        );
    }

    public int getYear() {
        return year;
    }

    public void setFio(String s) {
        fio = s;
    }

    public void setYear(int y) {
        year = y;
    }
}
