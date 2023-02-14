package com.tests;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.testng.annotations.Test;
// Для того, чтобы ссылаться на класс, а не на метод можно использовать статический импорт, как в примере ниже
// import static org.testng.annotations.*;
import java.util.concurrent.TimeUnit;
import static io.restassured.RestAssured.*;

public class GetRequest {
    @Test
    public void getTest(){
        // Отправляем GETзапрос и записываем ответ в переменню response
        Response response = given().get("http://localhost:3000/comments");
        // Получение заголовка
        System.out.println(response.header("Content-Type"));
        // Получение наименований и значений всех заголовков
        Headers headers = response.headers();
        for (Header header: headers) {
            System.out.println(header.getName() + ": " + header.getValue());
        }
        // Выводим ответ
        response.prettyPrint();
        // Выводим статус код
        System.out.println(response.getStatusCode());
        // Выводим время ответа в милисекундах
        System.out.println(response.getTime());
        // Выводит время ответа в других единицах измерения
        System.out.println(response.getTimeIn(TimeUnit.SECONDS));
    }
}
