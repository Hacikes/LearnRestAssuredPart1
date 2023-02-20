package com.tests;

import static io.restassured.RestAssured.*;

import com.github.javafaker.Faker;
import io.restassured.response.Response;
import jdk.jfr.ContentType;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;


public class PostRequest {
    // 1)
    // Превращение json тела в строку --> Не рекомендуется так делать,
    // так как, если тело большое с этим будет неудобно работать
    // Можно использовать для быстрой демонстрации, но не когда у нас
    // большой или динамический запрос

    @Test
    public void test() {
        // В переменную response запишется запрос и ответ с заголовками на POST запрос
        Response response = given()
                // Устанавливаем отправляем заголовок
                .header("Content-Type", "application/json")
                // Устанавливаем отправляемое тело
                .body("[\n" +
                "                {\n" +
                "                    \"Text\":\"Sometimes the questions are complicated and the answers are simple.\"\n" +
                "                }\n" +
                "        ]")
                // Выводим всю информацию в консоль
                .log().all()
                // URL источника
                .post("https://microsoft-translator-text.p.rapidapi.com/Detect?api-version=3.0");
        response.prettyPrint();
        System.out.println(response.getStatusCode( ));
    }

    @Test
    public void test1(){
        // 2)
        // Передача из внешнего файла
        // Из минусов: нельзя напечатать запрос в консоли
        // можно использовать только статические данные
        Response response = given()
                .header("Content-Type", "application/json")
                .log()
                .all()
                // Извлечение содержимого файла test.json в тело POST запроса
                .body(new File(System.getProperty("user.dir")+"/test.json"))
                .post("https://microsoft-translator-text.p.rapidapi.com/Detect?api-version=3.0");
        response.prettyPrint();
    }

    @Test
    public void test2() throws IOException {
        // 3)
        // Это логируется в консоль
        // Можно динамически изменять небольшой объём данные, так как необходимо написать много реплейсов

        // Записываем в переменную запрос из файла в формате byte
        byte[] bytes =  Files.readAllBytes(Paths.get(System.getProperty("user.dir")+"/test.json"));
        // Преобразовываем тело запроса в строку
        String reqBody = new String(bytes);
        // Ищет значение в JSON файле и заменяет его
        String replace = reqBody.replace("Hello", "World");
        Response response = given()
                .header("Content-Type", "application/json")
                .log()
                .all()
                // Извлечение содержимого файла test.json в тело POST запроса, в данном случае после изменения значения
                // с помощью replace
                .body(replace)
                .post("https://microsoft-translator-text.p.rapidapi.com/Detect?api-version=3.0");
        response.prettyPrint();
    }

    @Test
    public void test3() throws IOException {
        // 3.1)
        // Это логируется в консоль
        // Записываем в переменную запрос из файла в формате byte
        byte[] bytes =  Files.readAllBytes(Paths.get(System.getProperty("user.dir")+"/test.json"));
        // Преобразовываем тело запроса в строку
        String reqBody = new String(bytes);
        // Ищет значение в JSON файле и заменяет его
        String replace = reqBody.replace("Hello", String.valueOf(new Faker().name().firstName()));
        // если надо добавить несколько значений на изменение, то убери коммент
        //                      .replace("Hello", String.valueOf(new Faker().number().numberBetween(100,1000)));
        Response response = given()
                .header("Content-Type", "application/json")
                .log()
                .all()
                // Извлечение содержимого файла test.json в тело POST запроса, в данном случае после изменения значения
                // с помощью replace
                .body(replace)
                .post("https://microsoft-translator-text.p.rapidapi.com/Detect?api-version=3.0");
        response.prettyPrint();
    }

    @Test
    public void test4() {
        // 4)
        //
        // Хэш карта в данном случае используется для конвертации объекта на языке Java в поток байт,
        // а затем преобразование в требуемый формат, в данном случае в JSON
        // Это называется СЕРИАЛИЗАЦИЕЙ
        Map<String,Object> obj = new HashMap<>();
        // Изменение значений в JSON. Можно обращаться к нескольким парам ключ:значение
        // Для генерации рандомных значений используется Faker
        obj.put("Text", String.valueOf(new Faker().name().firstName()));
        //obj.put("Next Key", "Next value");

        Response response = given()
                .header("Content-Type", "application/json")
                .log()
                .all()
                .body(obj)
                .post("https://microsoft-translator-text.p.rapidapi.com/Detect?api-version=3.0");
        response.prettyPrint();

    }

    @Test
    public void test5() {
        // 4)
        // Сложный вариант, который будет тяжело реализовать с большими JSONами
        // Тип должен быть упомянут
        // { } --> Map interface
        // [] --> List
        // Хэш карта в данном случае используется для конвертации объекта на языке Java в поток байт,
        // а затем преобразование в требуемый формат, в данном случае в JSON
        // Это называется СЕРИАЛИЗАЦИЕЙ
        Map<String,Object> obj = new HashMap<>();
        // Изменение значений в JSON. Можно обращаться к нескольким парам ключ:значение
        // Для генерации рандомных значений используется Faker
        obj.put("id", String.valueOf(new Faker().number().randomDigit()));
        obj.put("Text", String.valueOf(new Faker().code().imei()));
        obj.put("email", String.valueOf(new Faker().funnyName().name() + "@mail.ru"));
        obj.put("name", String.valueOf(new Faker().name().firstName()));

        // Инициализуем список listOfJobs
//        List<String> listOfJobs = new ArrayList<>();
        // Создаём список с работой
//        listOfJobs.add("tester");
//        listOfJobs.add("trainer");

        // Строка ниже заменяет инициализуцию и создание списка, то есть, что закоменчено выше
        obj.put("jobs", Arrays.asList("tester", "trainer"));

//        obj.put("jobs", listOfJobs);
        // Снова используем хэш-карту, так как breakfast и lunch - строки, а dinner - массив

        Map<String, Object> food = new HashMap<>();
        food.put("breakfast", "eggs");
        food.put("lunch", "potato");
        // Для ужина снова создаём список и вносим значения массива
//        List<String> dinnerFood = new ArrayList<>();
//        dinnerFood.add("salat");
//        dinnerFood.add("meet");

        // Закоментил строки, выше, так как это можно сделать в одну строку

        // А после вызываем его, как обычно, указывая вместо значения карту dinnerFood

        food.put("dinner", Arrays.asList("salat", "meet"));

        Response response = given()
                .header("Content-Type", "application/json")
                .log()
                .all()
                .body(obj)
                .post("https://microsoft-translator-text.p.rapidapi.com/Detect?api-version=3.0");
        response.prettyPrint();
    }

    @Test
    public void test6(){
        // Используется внешняя библиотека JSON
        // Помогают работать с хэш-картами и списками
        // {} --> JsonObject
        // [] --> JsonArray

        JSONObject obj = new JSONObject();
        obj.put("id", String.valueOf(new Faker().number().randomDigit()));
        obj.put("Text", String.valueOf(new Faker().code().imei()));
        obj.put("email", String.valueOf(new Faker().funnyName().name() + "@gmail.com"));
        obj.accumulate("email", "test1234@mail.eu"); // (накопление) добавляет что-то к значению ключа и получается массив
        // к строке выше: Если всего одно значение, то вернётся строка, а не массив
        obj.append("email13", "6543214@mail.eu"); // в любом случае вернётся массив
        obj.put("name", String.valueOf(new Faker().name().firstName()));
        obj.putOpt("email12", null); // Если нужно проигрнорировать ключ, то можно использовать эту конструкцию
        //obj.putOnce("Text", "dont see becose putOnce don't repeat");// При использовании putOnce одинакового поля
        // второй раз не появится

        JSONArray listOfJobs = new JSONArray();
        listOfJobs.put("tester");
        listOfJobs.put("trainer");
        obj.put("jobs", listOfJobs);

        JSONObject food = new JSONObject();
        food.put("breakfast", "eggs");
        food.put("lunch", "potato");

        JSONArray listOfFoods = new JSONArray();
        listOfFoods.put("salat");
        listOfFoods.put("meet");

        food.put("favFood", listOfFoods);
        obj.put("dinner", listOfFoods);

        Response response = given()
                .header("Content-Type", "application/json")
                .log()
                .all()
                .body(obj.toMap()) // Jackson helps to serializable. Но можно так же явно указать toString()
                //Чтобы этого не делал Jackson
                .post("https://microsoft-translator-text.p.rapidapi.com/Detect?api-version=3.0");
        response.prettyPrint();
        System.out.println(response.jsonPath().getString("message")); // Вывод ответа в консоль

    }






}
