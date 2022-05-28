package com.example.java_recycleview_tutorial;

public class carModel {
    String car_name;
    int car_hp;
    int car_img;

    public carModel(String car_name, int car_hp, int car_img) {
        this.car_name = car_name;
        this.car_hp = car_hp;
        this.car_img = car_img;
    }

    public String getCar_name() {
        return car_name;
    }

    public int getCar_hp() {
        return car_hp;
    }

    public int getCar_img() {
        return car_img;
    }
}
