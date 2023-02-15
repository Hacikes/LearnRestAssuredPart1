package com.tests;

import com.pojo.Employee;
import com.pojo.FavFood;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.*;

public class PostRequestUsingPojo {

    // Pojo - Plain Old Java Object
    // Для каждого массива надо создавать лист, а для каждого объекта класс
    // {} --> Class file
    // [] --> List<Type> можно использовать для сериализации
    @Test
    public void pojoTest(){
        // Создаём объект используя конструктор класса FavFood
        FavFood favFood = new FavFood("eggs", "potato",  Arrays.asList("salat", "milk"));
        // Создаём объект используя конструктор из класса Employee
        // Массив используется для статичного JSON массива
        Employee employee = new Employee(14, "British", "Josh", "Josh1972@gmail.com", favFood, Arrays.asList("tester", "trainer"));
        Response response = given()
                .header("Content-Type", "application/json")
                .log()
                .all()
                .body(employee)
                .post("https://microsoft-translator-text.p.rapidapi.com/Detect?api-version=3.0");
        response.prettyPrint();


    }
}
