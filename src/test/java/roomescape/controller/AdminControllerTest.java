package roomescape.controller;

import static org.hamcrest.Matchers.is;

import static roomescape.fixture.ReservationFixture.RESERVATION_ONE;
import static roomescape.fixture.ReservationFixture.RESERVATION_TWO;

import org.junit.jupiter.api.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import roomescape.dto.request.ReservationRequest;

class AdminControllerTest extends RestAssuredTest {

    @Test
    void findAllReservations() {
        addReservation(RESERVATION_ONE);
        addReservation(RESERVATION_TWO);

        assertReservationsHasSize(2);
    }

    @Test
    void createReservation() {
        addReservation(RESERVATION_ONE);
        addReservation(RESERVATION_TWO);
        assertReservationsHasSize(2);

        var request = new ReservationRequest("브라운", "2023-08-05", "15:40");

        RestAssured.given().log().all()
                .contentType(ContentType.JSON)
                .body(request)
                .when().post("/admin/reservations")
                .then().log().all()
                .statusCode(201)
                .body("id", is(3))
                .extract().body().jsonPath()
                .get();

        assertReservationsHasSize(3);
    }

    @Test
    void deleteReservation() {
        addReservation(RESERVATION_ONE);
        addReservation(RESERVATION_TWO);
        assertReservationsHasSize(2);

        RestAssured.given().log().all()
                .when().delete("/admin/reservations/1")
                .then().log().all()
                .statusCode(204);

        assertReservationsHasSize(1);
    }
}
