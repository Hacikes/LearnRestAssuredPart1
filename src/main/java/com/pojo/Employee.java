package com.pojo;

public class Employee {

    private int id;
    // Геттер
    public int getId() {
        return id;
    }
    // Сеттер
    public void setId(int id) {
        if(id != 0){
            this.id = id;
        }
        else{
            this.id = -1;
        }
        this.id = id;
    }

    public String Text;
    public String email;
    // Приватная переменная используется, для того, чтобы можно было использовать сложную логику,
    // например, для того, чтобы задать дефолтное значение, когда она нулевая. С переменными так не получится
    private String name;

    // Геттер для name
    public String getName() {
        return name;
    }
    // Сеттер для name
    public Employee setName(String name) {
        // if сделан, для случая, когда name будет нулевой
        if(name != null){
            this.name = name;
        }
        else{
            this.name = "Ivan";
        }
        return this;
    }

    //Конструктор
    public Employee(int id, String text, String email, String name) {
        this.id = id;
        Text = text;
        this.email = email;
        this.name = name;
    }
}
