package com.pojo;

public class Employee {
    // Приватная переменная используется, для того, чтобы можно было использовать сложную логику,
    // например, для того, чтобы задать дефолтное значение, когда она нулевая. С переменными так не получится
    private int id;
    private String Text;
    private String email;
    private String name;

    // В данном случае сеттеры отсутствуют, так как мы устанавливаем значения конструктором.
    // Конструктор в свою очередь создаёт неизменяемые объекты
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


    //Конструктор
    public Employee(int id, String text, String email, String name) {
        this.id = id;
        Text = text;
        this.email = email;
        this.name = name;
    }
}
