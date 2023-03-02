package com.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

// Нажать на Refactor(в шапке) --> Delombok --> Setter/Getter
// Генерирует Геттер и Сеттер, если введены @Getter, @Setter
// Генерирует геттер и сеттер и т д. Ими можно пользоваться в других классах, но они не видны глазу
@Getter
@ToString
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@AllArgsConstructor
//@Setter // Не нужен так как мы хотим сохранить неизменность
@JsonIgnoreProperties(ignoreUnknown = true)
// Создаёт сеттеры и дополнительный метод, возвращающий Студента и т д
//@Builder(setterPrefix = "set") // в скобках установлен дополнительный префикс, можно так же менять название метода и т д
@Builder(buildMethodName = "getStudent")
//@AllArgsConstructor
public class Student {
    private int id;
    private String Text;
    private String email;
    private String name;
    //public static String address;//static field

}