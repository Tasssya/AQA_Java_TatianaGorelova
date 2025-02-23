package Lesson17;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import static io.restassured.RestAssured.given;

public class PostmanTests {
    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://postman-echo.com";
    }


    @Test
    public void getRequestTest() {
        Response response = given()
                .queryParam("animal1", "dog")
                .queryParam("animal2", "cat")
                .when()
                .get("/get")
                .then()
                .extract().response();

        // Проверка ответа
        Assert.assertEquals(response.getStatusCode(), 200, "Некорректный статус-код");

        // Проверка значений параметров в ответе
        String animal1Value = response.jsonPath().getString("args.animal1");
        String animal2Value = response.jsonPath().getString("args.animal2");

        Assert.assertEquals(animal1Value, "dog", "Параметр animal1 не совпадает");
        Assert.assertEquals(animal2Value, "cat", "Параметр animal2 не совпадает");
    }

    @Test
    public void postRequestTest() {
        String requestBody = "{ \"animal1\": \"cat\", \"animal2\": \"dog\" }";

        Response response = given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when()
                .post("/post")
                .then()
                .extract().response();

        // Проверка ответа
        Assert.assertEquals(response.getStatusCode(), 200, "Некорректный статус-код");

        // Проверка тела ответа
        String animal1 = response.jsonPath().getString("data.animal1");
        String animal2 = response.jsonPath().getString("data.animal2");

        Assert.assertEquals(animal1, "cat", "Значение animal1 не совпадает");
        Assert.assertEquals(animal2, "dog", "Значение animal2 не совпадает");
    }

    @Test
    public void postFormDataTest() {
        Response response = given()
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .formParam("animal1", "dog")
                .formParam("animal2", "cat")
                .when()
                .post("/post")
                .then()
                .extract().response();

        // Проверка ответа
        Assert.assertEquals(response.getStatusCode(), 200, "Некорректный статус-код");

        // Проверка значений параметров в ответе
        String animal1 = response.jsonPath().getString("form.animal1");
        String animal2 = response.jsonPath().getString("form.animal2");

        Assert.assertEquals(animal1, "dog", "Параметр animal1 не совпадает");
        Assert.assertEquals(animal2, "cat", "Параметр animal2 не совпадает");
    }


    @Test
    public void putRequestTest() {
        String requestBody = "{ \"animal1\": \"lion\", \"animal2\": \"tiger\" }";


        Response response = given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when()
                .put("/put")
                .then()
                .extract().response();

        // Проверка ответа
        Assert.assertEquals(response.getStatusCode(), 200, "Некорректный статус-код");

        // Проверка тела ответа
        String animal1 = response.jsonPath().getString("data.animal1");
        String animal2 = response.jsonPath().getString("data.animal2");

        Assert.assertEquals(animal1, "lion", "Значение animal1 не совпадает");
        Assert.assertEquals(animal2, "tiger", "Значение animal2 не совпадает");
    }

    @Test
    public void patchRequestTest() {
        String requestBody = "{ \"animal1\": \"elephant\", \"animal2\": \"giraffe\" }";

        Response response = given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when()
                .patch("/patch")
                .then()
                .extract().response();

        // Проверка ответа
        Assert.assertEquals(response.getStatusCode(), 200, "Некорректный статус-код");

        // Проверка тела ответа
        String animal1 = response.jsonPath().getString("data.animal1");
        String animal2 = response.jsonPath().getString("data.animal2");

        Assert.assertEquals(animal1, "elephant", "Значение animal1 не совпадает");
        Assert.assertEquals(animal2, "giraffe", "Значение animal2 не совпадает");
    }

    @Test
    public void deleteRequestTest() {

        Response response = given()
                .queryParam("animal", "fox")
                .when()
                .delete("/delete")
                .then()
                .extract().response();

        // Проверка ответа
        Assert.assertEquals(response.getStatusCode(), 200, "Некорректный статус-код");

        // Проверка тела ответа
        String animal = response.jsonPath().getString("args.animal");
        Assert.assertEquals(animal, "fox", "Значение параметра animal не совпадает");
    }
}



