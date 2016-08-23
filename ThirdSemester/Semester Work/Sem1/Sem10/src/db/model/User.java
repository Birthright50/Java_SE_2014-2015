package db.model;

import java.sql.Date;

/**
 * Created by Birthright on 18.10.2015.
 */
public class User {

    private int id;
    private String login;
    private String password;
    private String salt;
    private String email;
    private String region;
    private String first_name;
    private String last_name;
    private Date date;
    private int year_st;
    private String gender;
    private String car_mark;

    public User(String login, String password, String email, String region, String first_name, String last_name, Date date, int year_st, String gender, String car_mark) {
        this.login = login;
        this.password = password;
        this.email = email;
        this.region = region;
        this.first_name = first_name;
        this.last_name = last_name;
        this.date = date;
        this.year_st = year_st;
        this.gender = gender;
        this.car_mark = car_mark;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getYear_st() {
        return year_st;
    }

    public void setYear_st(int year_st) {
        this.year_st = year_st;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCar_mark() {
        return car_mark;
    }

    public void setCar_mark(String car_mark) {
        this.car_mark = car_mark;
    }
}
