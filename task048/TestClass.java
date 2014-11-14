import java.util.Scanner;

/**
 * Created by BirthrightL on 11.11.2014.
 */
public class TestClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Student.studentInfo();
        Преподаватель v = new Преподаватель(sc.nextLine(), sc.nextLine());
        System.out.println(v.getFio());
        System.out.println(v.getpredmet());
        v.setFio(sc.nextLine());
        v.setpredmet(sc.nextLine());
        Student s = new Student(sc.nextLine(), sc.nextInt());
        Student s2 = new Student(sc.nextLine(), sc.nextInt());
        System.out.println(s.getFio());
        System.out.println(s.getYear());
        s.greet(s2);
        s2.greet(s);
        v.RateStudent(s2);
        v.RateStudent(s);
    }
}
