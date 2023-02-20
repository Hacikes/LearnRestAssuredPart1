package com.tests;

import com.pojo.Employee;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;
import static  io.restassured.RestAssured.*;

public class UpdateRequest {

    @Test
    public void updateTest(){

        JSONObject object  = new JSONObject();
        object.put("name", "Bak");
        object.put("email", "bak@gmail.com");


        Response response = given()
                .pathParams("id", 3) // устанавливает значение id
                .baseUri("http://localhost:3000/")
                .header("Content-Type", "application/json")
                .log()
                .all()
                .body(object.toMap())
                .put("/postrequest/{id}") // используем метод put для обновления данных
                ;



    }
}
