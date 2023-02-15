package com.pojo;

import java.util.List;

public class Employee {
    // Приватная переменная используется, для того, чтобы можно было использовать сложную логику,
    // например, для того, чтобы задать дефолтное значение, когда она нулевая. С переменными так не получится
    private int id;
    private String Text;
    private String email;
    private String name;
    // Объект favFood, который вынесен в класс FavFood
    private FavFood favFood;
    private List<String> jobs;

    public List<String> getJobs() {
        return jobs;
    }

    public void setJobs(List<String> jobs) {
        this.jobs = jobs;
    }

    public FavFood getFavFood() {
        return favFood;
    }
    public void setFavFood(FavFood favFood) {
        this.favFood = favFood;
    }

    public int getId() {
        return id;
    }
    public String getText() {
        return Text;
    }
    public String getEmail() {
        return email;
    }
    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setText(String text) {
        Text = text;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setName(String name) {
        this.name = name;
    }

    //Конструктор
    public Employee(int id, String text, String email, String name, FavFood favFood, List<String> jobs) {
        this.id = id;
        Text = text;
        this.email = email;
        this.name = name;
        this.favFood = favFood;
        this.jobs = jobs;
    }

}
