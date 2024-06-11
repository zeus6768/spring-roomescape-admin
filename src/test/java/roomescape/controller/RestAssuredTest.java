package roomescape.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

import io.restassured.RestAssured;
import roomescape.domain.Reservation;
import roomescape.repository.ReservationRepository;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public abstract class RestAssuredTest {

    @LocalServerPort
    private int port;

    @Autowired
    private ReservationRepository reservationRepository;

    @BeforeEach
    void setUp() {
        RestAssured.port = port;
    }

    protected void assertReservationsHasSize(int expectedSize) {
        int actualSize = getReservations().size();
        assertThat(actualSize).isEqualTo(expectedSize);
    }

    protected List<Reservation> getReservations() {
        return reservationRepository.findAll();
    }

    protected void addReservation(Reservation reservation) {
        reservationRepository.save(reservation);
    }
}
