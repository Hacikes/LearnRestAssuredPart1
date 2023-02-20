package com.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true) // БЕЗ ЭТОЙ Х**** Jackson НЕ РАБОТАЕТ, подробнее описано в Class ForPostRequest
@Getter
@Setter
//@AllArgsConstructor
@JsonInclude(value = JsonInclude.Include.NON_EMPTY) // Игнорирование пустых и null значений
//@JsonPropertyOrder(alphabetic = true) // Сортировка расположения по наименованию ключей
//@JsonPropertyOrder(value = {"name", "jobs", "email"}) //Сортировка параметров
//@JsonIgnoreProperties(value = {"marks", "dinner"}) // игнорирование нескольких полей
public class Employee {
    // Приватная переменная используется, для того, чтобы можно было использовать сложную логику,
    // например, для того, чтобы задать дефолтное значение, когда она нулевая. С переменными так не получится
    private int id;
    private String Text;
//    @JsonIgnore // Поле ниже будет игнорироваться, в данном случае email
    private String email;
    private String name;
    // Объект favFood, который вынесен в класс FavFood
    private FavFood favFood;
    private List<String> jobs;
    private List<Marks> marks;

    //Конструктор

    public Employee(int id, String text, String email, String name, FavFood favFood, List<String> jobs, List<Marks> marks) {
        this.id = id;
        Text = text;
        this.email = email;
        this.name = name;
        this.favFood = favFood;
        this.jobs = jobs;
        this.marks = marks;
    }

    public Employee()
    {
        super();
    }
}
