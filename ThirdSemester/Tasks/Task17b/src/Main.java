import db.DBHelper;
import db.repository.*;

import java.util.HashSet;

/**
 * Created by Birthright on 18.10.2015.
 */
public class Main {
    public static void main(String[] args) {
        HashSet<Student> students = DBHelper.getStudents();
        HashSet<School> schools = DBHelper.getSchools();
        HashSet<Teacher> teachers = DBHelper.getTeachers(schools);
        HashSet<Lesson> lessons = DBHelper.getClasses();
        HashSet<Attendance> attendance = DBHelper.getAttendance(students, teachers, lessons);

        String first = DBHelper.firstQuery(attendance);
        String second = DBHelper.secondQuery(attendance);

        System.out.println(first);
        System.out.println(second);

    }
}
