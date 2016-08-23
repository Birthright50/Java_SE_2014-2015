package db.repository;

/**
 * Created by Birthright on 17.10.2015.
 */
public abstract class Subject {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public Subject(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
