package com.tests;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.testng.annotations.Test;
// Для того чтобы ссылаться на класс, а не на метод можно использовать статический импорт, как в примере ниже
// import static org.testng.annotations.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;
import static io.restassured.RestAssured.*;

public class GetRequest {
    @Test
    public void getEmployees() throws IOException {
        Response response = given()
                .queryParam("Josh", 1) // устанавливает значение id
                .baseUri("http://localhost:3004/")
                .log()
                .all()
                .get("posts"); // используем метод put для обновления данных

        // Создаётся файл response.json, в который сохраняется ответ
        Files.write(Paths.get(System.getProperty("user.dir")+"/response.json"),response.asByteArray());

        // В этот раз будет изучен шаблон проектирования Builder

    }
}


