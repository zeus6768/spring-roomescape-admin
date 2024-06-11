package roomescape.fixture;

import java.time.LocalDate;
import java.time.LocalTime;

import roomescape.domain.Reservation;

public class ReservationFixture {

    public static final Reservation RESERVATION_ONE = new Reservation(
            1L, "ONE", LocalDate.parse("2024-01-01"), LocalTime.parse("13:00"));

    public static final Reservation RESERVATION_TWO = new Reservation(
            2L, "TWO", LocalDate.parse("2024-01-02"), LocalTime.parse("14:00"));
}
