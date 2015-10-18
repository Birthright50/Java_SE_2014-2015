package db.repository;

/**
 * Created by Birthright on 17.10.2015.
 */
public class Teacher extends Subject {
    private School school;
    private int school_id;

    public Teacher(int id, String name, int school_id, School school) {
        super(id, name);
        this.school_id = school_id;
        this.school = school;
    }

    public School getSchool() {
        return school;
    }

    public int getSchool_id() {
        return school_id;
    }

    public void setSchool_id(int school_id) {
        this.school_id = school_id;
    }

    public void setSchool(School school) {
        this.school = school;
    }
}
