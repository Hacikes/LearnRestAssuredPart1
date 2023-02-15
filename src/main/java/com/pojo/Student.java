package com.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

// Нажать на Refactor(в шапке) --> Delombok --> Setter/Getter
// Генерирует Геттер и Сеттер, если введены @Getter, @Setter


@Getter
@Setter
@AllArgsConstructor
public class Student {
    // генерирует геттер и сеттер и ими можно пользоваться в других классах

    private  String name;
    private String Text;

}
