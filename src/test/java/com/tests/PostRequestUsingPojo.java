/*
package com.tests;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.github.javafaker.Faker;
import com.pojo.Employee;
import com.pojo.FavFood;
import com.pojo.Marks;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import static io.restassured.RestAssured.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PostRequestUsingPojo {

    // Pojo - Plain Old Java Object
    // Для каждого массива надо создавать лист, а для каждого объекта класс
    // {} --> Class file
    // [] --> List<Type> можно использовать для сериализации
    @Test
    public void pojoTest(){
        // Созданы 2 массива
        Marks marks = new Marks(80,40);
        Marks mark1 = new Marks(75,60);
        // Массивы записали в общий массив и далее используем его в Employee
        List<Marks> listofmarks = Arrays.asList(marks, mark1);
        // Создаём объект используя конструктор класса FavFood
        FavFood favFood = new FavFood("eggs", "potato",  Arrays.asList("salat", "milk"));
        // Создаём объект используя конструктор из класса Employee
        // Массив используется для статичного JSON массива
        Employee employee =
                new Employee(new Faker().number().numberBetween(100,1000), "Chelovek", "Josh", "Kelvin");
        Response response = given()
                .baseUri("https://microsoft-translator-text.p.rapidapi.com")
                .header("Content-Type", "application/json")
                .log()
                .all()
                .body(employee)
                .post("/Detect?api-version=3.0");
        response.prettyPrint();
        Assert.assertEquals(response.getStatusCode(),401); // Проверка статус кода
        Assert.assertEquals(response.header("Content-Type"), "application/json"); // Проверка значения заголовка
        System.out.println(response.jsonPath().getString("message")); // Вывод ответа в консоль, но тут нечего выводить
        System.out.println(response.jsonPath().getList("jobs")); //
        List<String> jobs = (response.jsonPath().getList("jobs"));//  \
        //    > получение объекта из ответа и вывод в консоль
        System.out.println(jobs);                                      //  /
        System.out.println(response.jsonPath().getString("x[0].favFoods.lunch")); // Проверка, которая определяет,
        // что существует элемент lunch в ответе
        Employee deserialisedEmployee = response.as(Employee.class); // JSON --> Class в классах должны быть явно
        // определены конструкторы
        // По сути это ссылка на пользователя
        System.out.println(deserialisedEmployee.getEmail());// Десиариализованная почта
        System.out.println(deserialisedEmployee.getMarks());// Десиариализованные языки

        // Проверка тела ответа на соответствие JSON Схемы
//        response.then().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schema.json"));// Провал
        // Или проверка может осуществляться таким образом, используя файл, а не строку
        */
/*response.then().body(JsonSchemaValidator.matchesJsonSchema(
                new File(System.getProperty(System.getProperty("user.dir")
                        +"src/test/resources/jsonschema/schema.json"))));*//*

    }
}
*/
