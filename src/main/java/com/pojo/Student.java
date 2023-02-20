package com.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

// Нажать на Refactor(в шапке) --> Delombok --> Setter/Getter
// Генерирует Геттер и Сеттер, если введены @Getter, @Setter
// Генерирует геттер и сеттер и т д. Ими можно пользоваться в других классах, но они не видны глазу
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
//@AllArgsConstructor
public class Student {
    private  String name;
    private String Text;

    public Student(String dfdsf, String dfdfdf) {
    }
    public Student()
    {
        super();
    }
}

