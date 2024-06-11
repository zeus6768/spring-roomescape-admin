package roomescape.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import roomescape.domain.Reservation;

@Repository
public class CollectionReservationRepository implements ReservationRepository {

    private final List<Reservation> reservations;

    public CollectionReservationRepository(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public CollectionReservationRepository() {
        List<Reservation> step1 = List.of(
                new Reservation(1L, "브라운", "2024-06-11", "14:00"),
                new Reservation(2L, "리사", "2024-06-12", "15:00"),
                new Reservation(3L, "토미", "2024-06-13", "16:00")
        );
        reservations = new ArrayList<>(step1);
    }

    @Override
    public List<Reservation> findAll() {
        return List.copyOf(reservations);
    }
}
