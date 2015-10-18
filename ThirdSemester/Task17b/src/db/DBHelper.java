package db;

import db.repository.*;
import singleton.ConnectionSingleton;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Formatter;
import java.util.HashSet;

/**
 * Created by Birthright on 17.10.2015.
 */
public class DBHelper {
    public static HashSet<Student> getStudents() {
        HashSet<Student> students = new HashSet<>();
        Connection connection = ConnectionSingleton.getStatement();
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM students");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Student student = new Student(resultSet.getInt("id"), resultSet.getString("name"));
                students.add(student);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return students;
    }

    public static HashSet<Lesson> getClasses() {
        HashSet<Lesson> lessons = new HashSet<>();
        Connection connection = ConnectionSingleton.getStatement();
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM classes");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Lesson subj = new Lesson(resultSet.getInt("id"), resultSet.getString("name"));
                lessons.add(subj);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return lessons;
    }

    public static HashSet<School> getSchools() {
        HashSet<School> schools = new HashSet<>();
        Connection connection = ConnectionSingleton.getStatement();
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM schools");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                School school = new School(resultSet.getInt("id"), resultSet.getString("name"));
                schools.add(school);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return schools;
    }

    public static HashSet<Teacher> getTeachers(HashSet<School> schools) {
        HashSet<Teacher> teachers = new HashSet<>();
        Connection connection = ConnectionSingleton.getStatement();
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM teachers");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int school_id = resultSet.getInt("school_id");
                School teacherSchool = null;
                for (School school : schools) {
                    if (school_id == school.getId()) {
                        teacherSchool = school;
                        break;
                    }
                }
                Teacher teacher = new Teacher(resultSet.getInt("id"), resultSet.getString("name"), school_id, teacherSchool);
                teachers.add(teacher);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return teachers;
    }

    public static HashSet<Attendance> getAttendance(HashSet<Student> students, HashSet<Teacher> teachers, HashSet<Lesson> lessons) {
        HashSet<Attendance> attendances = new HashSet<>();
        Connection connection = ConnectionSingleton.getStatement();
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM attendance");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Attendance attendance = new Attendance();
                int class_id = resultSet.getInt("class_id");
                int teacher_id = resultSet.getInt("teacher_id");
                int student_id = resultSet.getInt("student_id");
                Student student = null;
                Teacher teacher = null;
                Lesson subj = null;
                for (Student object : students) {
                    if (student_id == object.getId()) {
                        student = object;
                    }
                }
                for (Teacher object : teachers) {
                    if (teacher_id == object.getId()) {
                        teacher = object;
                    }
                }
                for (Lesson object : lessons) {
                    if (class_id == object.getId()) {
                        subj = object;
                    }
                }
                attendance.setClass_id(class_id);
                attendance.setStudent_id(student_id);
                attendance.setTeacher_id(teacher_id);
                attendance.setTeacher(teacher);
                attendance.setStudent(student);
                attendance.setaLesson(subj);
                attendance.setYear(resultSet.getInt("year"));
                attendances.add(attendance);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return attendances;


    }

    public static String firstQuery(HashSet<Attendance> attendances) {
        StringBuilder stringBuilder = new StringBuilder();
        Formatter formatter = new Formatter(stringBuilder);
        formatter.format("%-20s%-25s%n", "Student name", "Class name");
        stringBuilder.append("-----------------------------------------------------\n");
        HashSet<FirstQueryHelper> firstQueryHelpers = new HashSet<>();
        for (Attendance attendance : attendances) {
            int year = attendance.getYear();
            if (year > 1991 && year < 1999) {
                FirstQueryHelper firstQueryHelper = new FirstQueryHelper();
                firstQueryHelper.class_name = attendance.getaLesson().getName();
                firstQueryHelper.student_name = attendance.getStudent().getName();
                firstQueryHelpers.add(firstQueryHelper);
            }
        }
        for (FirstQueryHelper helper : firstQueryHelpers) {
            formatter.format("%-20s%-25s%n", helper.student_name, helper.class_name);
        }
        return stringBuilder.toString();


    }

    public static String secondQuery(HashSet<Attendance> attendances) {
        StringBuilder stringBuilder = new StringBuilder();
        Formatter formatter = new Formatter(stringBuilder);
        formatter.format("%-20s%-25s%n", "Student name", "Year");
        stringBuilder.append("-----------------------------------------------------\n");
        for (Attendance attendance : attendances) {
            if (attendance.getTeacher().getName().equals("Horace Slughorn")) {
                formatter.format("%-20s%-25s%n", attendance.getStudent().getName(), attendance.getYear());
            }
        }
        return stringBuilder.toString();
    }

    private static class FirstQueryHelper {
        private String student_name;
        private String class_name;


        @Override
        public boolean equals(Object o) {
            FirstQueryHelper that = (FirstQueryHelper) o;
            return !(student_name != null ? !student_name.equals(that.student_name) : that.student_name != null) && !(class_name != null ? !class_name.equals(that.class_name) : that.class_name != null);

        }

        @Override
        public int hashCode() {
            int result = student_name != null ? student_name.hashCode() : 0;
            result = 31 * result + (class_name != null ? class_name.hashCode() : 0);
            return result;
        }
    }
}
