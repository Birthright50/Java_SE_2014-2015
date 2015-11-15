package ru.kpfu.itis.peter_kozlovsky.db.model;

/**
 * Created by Birthright on 14.11.2015.
 */
public class Ad {
    private int id;
    private String name;
    private String url_image_1;
    private String url_image_2;
    private String url_image_3;
    private String url_image_4;
    private String url_image_5;
    private String text;
    private int year;
    private int probeg;
    private int price;
    private int id_user;
private String city;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getId() {
        return id;
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

    public String getUrl_image_1() {
        return url_image_1;
    }

    public void setUrl_image_1(String url_image_1) {
        this.url_image_1 = url_image_1;
    }

    public String getUrl_image_2() {
        return url_image_2;
    }

    public void setUrl_image_2(String url_image_2) {
        this.url_image_2 = url_image_2;
    }

    public String getUrl_image_3() {
        return url_image_3;
    }

    public void setUrl_image_3(String url_image_3) {
        this.url_image_3 = url_image_3;
    }

    public String getUrl_image_4() {
        return url_image_4;
    }

    public void setUrl_image_4(String url_image_4) {
        this.url_image_4 = url_image_4;
    }

    public String getUrl_image_5() {
        return url_image_5;
    }

    public void setUrl_image_5(String url_image_5) {
        this.url_image_5 = url_image_5;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getProbeg() {
        return probeg;
    }

    public void setProbeg(int probeg) {
        this.probeg = probeg;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
