package roomescape.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.server.LocalServerPort;

import io.restassured.RestAssured;
import roomescape.domain.Reservation;
import roomescape.dto.response.ReservationResponse;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class AdminControllerTest {

    @LocalServerPort
    private int port;

    @BeforeEach
    void setUp() {
        RestAssured.port = port;
    }

    @Test
    void findAllReservations() {
        List<ReservationResponse> reservations = RestAssured.given().log().all()
                .when().get("admin/reservations")
                .then().log().all()
                .statusCode(200)
                .extract().body().jsonPath().getList(".", ReservationResponse.class);

        assertThat(reservations).hasSize(3);
    }
}
