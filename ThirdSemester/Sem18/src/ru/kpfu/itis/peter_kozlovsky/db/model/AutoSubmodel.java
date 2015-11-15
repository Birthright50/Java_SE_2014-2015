package ru.kpfu.itis.peter_kozlovsky.db.model;

/**
 * Created by Birthright on 11.11.2015.
 */
public class AutoSubmodel {
    private String name;
    private String name_model;
    private String name_brand;
    private int price;
    private int speed;
    private double acceleration;
    private int capacity;
    private int power;
    private int flowrate;
private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName_model() {
        return name_model;
    }

    public void setName_model(String name_model) {
        this.name_model = name_model;
    }

    public String getName_brand() {
        return name_brand;
    }

    public void setName_brand(String name_brand) {
        this.name_brand = name_brand;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public double getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(double acceleration) {
        this.acceleration = acceleration;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getFlowrate() {
        return flowrate;
    }

    public void setFlowrate(int flowrate) {
        this.flowrate = flowrate;
    }

}
