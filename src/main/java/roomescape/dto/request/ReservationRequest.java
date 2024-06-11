package roomescape.dto.request;

import java.time.LocalDate;
import java.time.LocalTime;

import roomescape.domain.Reservation;

public record ReservationRequest(
        String name,
        String date,
        String time
) {
    public Reservation toReservation() {
        return new Reservation(null, name, LocalDate.parse(date), LocalTime.parse(time));
    }
}
