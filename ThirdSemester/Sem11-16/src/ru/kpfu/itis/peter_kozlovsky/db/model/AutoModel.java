package ru.kpfu.itis.peter_kozlovsky.db.model;

/**
 * Created by Birthright on 10.11.2015.
 */
public class AutoModel {

    private String name;
    private String name_brand;
    private int year;
    private String body;
    private String text;
    private String image_url_1;
    private String image_url_2;
    private String image_url_3;
    private String image_url_4;
    private String image_url_5;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getImage_url_1() {
        return image_url_1;
    }

    public void setImage_url_1(String image_url_1) {
        this.image_url_1 = image_url_1;
    }

    public String getImage_url_2() {
        return image_url_2;
    }

    public void setImage_url_2(String image_url_2) {
        this.image_url_2 = image_url_2;
    }

    public String getImage_url_3() {
        return image_url_3;
    }

    public void setImage_url_3(String image_url_3) {
        this.image_url_3 = image_url_3;
    }

    public String getImage_url_4() {
        return image_url_4;
    }

    public void setImage_url_4(String image_url_4) {
        this.image_url_4 = image_url_4;
    }

    public String getImage_url_5() {
        return image_url_5;
    }

    public void setImage_url_5(String image_url_5) {
        this.image_url_5 = image_url_5;
    }

    public String getName_brand() {
        return name_brand;
    }

    public void setName_brand(String name_brand) {
        this.name_brand = name_brand;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    private String url;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
