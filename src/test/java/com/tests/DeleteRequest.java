package com.tests;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
// Для того чтобы ссылаться на класс, а не на метод можно использовать статический импорт, как в примере ниже
// import static org.testng.annotations.*;
import java.util.List;
import java.util.concurrent.TimeUnit;
import static io.restassured.RestAssured.*;

public class DeleteRequest {
    @Test
    public void getEmployees() {
        Response response = given()
                .pathParams("id", 1) // устанавливает значение id
                .baseUri("http://localhost:3000/")
                .log()
                .all()
                .delete("/postrequest/{id}") // используем метод put для обновления данных
                ;
        response.prettyPrint();




    }
}


