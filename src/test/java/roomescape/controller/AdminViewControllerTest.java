package roomescape.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.server.LocalServerPort;

import io.restassured.RestAssured;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class AdminViewControllerTest {

    @LocalServerPort
    private int port;

    @BeforeEach
    void setUp() {
        RestAssured.port = port;
    }

    @Test
    void index() {
        RestAssured.given().log().all()
                .when().get("/admin")
                .then().log().all()
                .statusCode(200);
    }

    @Test
    void reservation() {
        RestAssured.given().log().all()
                .when().get("/admin/reservation")
                .then().log().all()
                .statusCode(200);
    }
}
