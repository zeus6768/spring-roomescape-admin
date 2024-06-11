package roomescape.dto.response;

import roomescape.domain.Reservation;

public record ReservationResponse(
        long id,
        String name,
        String date,
        String time
) {
    public ReservationResponse(Reservation reservation) {
        this(reservation.id(), reservation.name(), reservation.date().toString(), reservation.time().toString());
    }
}
