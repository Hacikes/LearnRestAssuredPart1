package com.tests;
import com.github.javafaker.Faker;
import com.pojo.ForPostRequest;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class PostRequestUsingPojo2 {

    // Pojo - Plain Old Java Object
    // Для каждого массива надо создавать лист, а для каждого объекта класс
    // {} --> Class file
    // [] --> List<Type> можно использовать для сериализации
    @Test
    public void pojoTest(){
        ForPostRequest forPostRequest =
                new ForPostRequest(new Faker().name().firstName(), new Faker().job().title());
        Response response = given()
                .baseUri("https://reqres.in")

                .header("Content-Type", "application/json; charset=utf-8")
                .log()
                .all()
                .body(forPostRequest)
                .post("/api/users");
        response.prettyPrint();
        Assert.assertEquals(response.getStatusCode(),201); // Проверка статус кода
        Assert.assertEquals(response.header("Content-Type"), "application/json; charset=utf-8"); // Проверка значения заголовка
        System.out.println(response.jsonPath().getString("id")); // Вывод ответа в консоль, но тут нечего выводить

        ForPostRequest deserialisedForPostRequest = response.as(ForPostRequest.class); // JSON --> Class в классах должны быть явно
        // определены конструкторы
        System.out.println(deserialisedForPostRequest.getName());
        //response.then().body();
    }
}
