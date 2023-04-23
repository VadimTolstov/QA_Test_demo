package hw_18_rest_api_Assured.lecture;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.hasKey;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SelenoidTests {

    /*
        1. Make request to https://selenoid.autotests.cloud/status
        2. Get response { total: 20, used: 0, queued: 0, pending: 0, browsers: {
                android: { 8.1: { } }, chrome: { 100.0: { }, 99.0: { } },
                chrome-mobile: { 86.0: { } }, firefox: { 97.0: { }, 98.0: { } }, opera: { 84.0: { }, 85.0: { } } } }
        3. Check total is 20
     */

    @Test
    void checkTotal() {
        get("https://selenoid.autotests.cloud/status")
                .then()
                //После блока .then() идут проверки
                .body("total", is(20));
    }

    @Test
    void checkWithGivenTotal() {
        given()
                .when()
                .get("https://selenoid.autotests.cloud/status")
                .then()  //После блока .then() идут проверки
                .body("total", is(20));
    }

    @Test
    void checkWithStatusTotal() {
        given()
                .when()
                .get("https://selenoid.autotests.cloud/status")
                .then()
                .statusCode(200)
                .body("total", is(20));
    }

    @Test
    void checkWithAllLogsTotal() {
        given()
                //залогировали запрос
                .log().all()
                .when()
                .get("https://selenoid.autotests.cloud/status")
                .then()
                //залогировали ответ
                .log().all()
                .statusCode(200)
                .body("total", is(20));
    }

    @Test
    void checkWithSomeLogsTotal() {
        given()
                .log().uri()
//              .log().body()  // для  post запроса
                .when()
                .get("https://selenoid.autotests.cloud/status")
                .then()
                //статус и тело
                .log().status()
                .log().body()
                .statusCode(200)
                .body("total", is(20));
    }

    @Test
    void checkChromeVersion() {
        given()
                .log().uri()
                .when()
                .get("https://selenoid.autotests.cloud/status")
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .body("total", is(20))
//        browsers: {       описание как получить с вложенных данных
//            android: { 8.1: { } }, chrome: { 100.0: { }, 99.0: { } },
                .body("browsers.chrome", hasKey("100.0"));
    }

    @Test
    void checkResponseBadPractice() { // BAD PRACTICE. todo move to models
        String expectedResponse = "{\"total\":20,\"used\":0,\"queued\":0,\"pending\":0,\"browsers\":" +
                                  "{\"android\":{\"8.1\":{}},\"chrome\":{\"100.0\":{},\"99.0\":{}},\"chrome-mobile\":{\"86.0\":{}}," +
                                  "\"firefox\":{\"97.0\":{},\"98.0\":{}},\"opera\":{\"84.0\":{},\"85.0\":{}}}}\n";

        String actualResponse = given()
                .log().uri()
                .when()
                .get("https://selenoid.autotests.cloud/status")
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .extract().response().asString();

        assertEquals(expectedResponse, actualResponse);
    }

    @Test
    void checkResponseGoodPractice() {
        Integer expectedTotal = 20;

        Integer actualTotal = given()
                .log().uri()
                .when()
                .get("https://selenoid.autotests.cloud/status")
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .extract().path("total");

        assertEquals(expectedTotal, actualTotal);
    }

    @Test // тестируем схему json
    void checkJsonScheme() {
        given()
                .log().uri()
                .when()
                .get("https://selenoid.autotests.cloud/status")
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .body("total", is(20))
                .body("browsers.chrome", hasKey("100.0"))
                .body(matchesJsonSchemaInClasspath("hw_18/status-scheme-responce.json"));
    }

}