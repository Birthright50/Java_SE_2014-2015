package db.repository;

/**
 * Created by Birthright on 17.10.2015.
 */
public class Attendance {
    private int class_id;
    private int teacher_id;
    private int student_id;
    private int year;
    private Student student;

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public int getClass_id() {
        return class_id;
    }

    public void setClass_id(int class_id) {
        this.class_id = class_id;
    }

    public int getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(int teacher_id) {
        this.teacher_id = teacher_id;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Lesson getaLesson() {
        return aLesson;
    }

    public void setaLesson(Lesson aLesson) {
        this.aLesson = aLesson;
    }

    private Teacher teacher;
    private Lesson aLesson;
}
