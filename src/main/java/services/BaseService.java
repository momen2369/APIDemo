package services;

import io.restassured.RestAssured;
import io.restassured.config.HttpClientConfig;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utils.readers.ConfigReader;

import static io.restassured.RestAssured.given;


public class BaseService {
    protected ConfigReader configReader = new ConfigReader("src/main/resources/config.properties");

    protected Response getRequest(String endpoint) {
        return given()
                .config(RestAssured.config()
                        .httpClient(HttpClientConfig.httpClientConfig()
                                .setParam("http.connection.timeout", 5000) // Set timeout (5 seconds)
                                .setParam("http.socket.timeout", 5000)))
                .contentType(ContentType.JSON)
                .when()
                .get(endpoint);
    }

    protected Response getRequest(String endpoint, int id) {
        return given()
                .config(RestAssured.config()
                        .httpClient(HttpClientConfig.httpClientConfig()
                                .setParam("http.connection.timeout", 5000) // Set timeout (5 seconds)
                                .setParam("http.socket.timeout", 5000)))
                .contentType(ContentType.JSON)
                .when()
                .get(endpoint + "/" + id);
    }

    protected Response postRequest(String endpoint, Object body) {
        return given()
                .config(RestAssured.config()
                        .httpClient(HttpClientConfig.httpClientConfig()
                                .setParam("http.connection.timeout", 5000) // Set timeout (5 seconds)
                                .setParam("http.socket.timeout", 5000)))
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .post(endpoint);
    }

    protected Response putRequest(String endpoint, int id, Object body) {
        return given()
                .config(RestAssured.config()
                        .httpClient(HttpClientConfig.httpClientConfig()
                                .setParam("http.connection.timeout", 5000) // Set timeout (5 seconds)
                                .setParam("http.socket.timeout", 5000)))
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .put(endpoint + "/" + id);
    }

    protected Response deleteRequest(String endpoint, int id) {
        return given()
                .config(RestAssured.config()
                        .httpClient(HttpClientConfig.httpClientConfig()
                                .setParam("http.connection.timeout", 5000) // Set timeout (5 seconds)
                                .setParam("http.socket.timeout", 5000)))
                .contentType(ContentType.JSON)
                .when()
                .delete(endpoint + "/" + id);
    }
}
