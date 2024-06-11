package roomescape.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Repository;

import roomescape.domain.Reservation;

@Repository
public class CollectionReservationRepository implements ReservationRepository {

    private static final long INITIAL_ID = 1;

    private final AtomicLong counter = new AtomicLong(INITIAL_ID);

    private final List<Reservation> reservations;

    public CollectionReservationRepository() {
        this.reservations = new ArrayList<>();
    }

    public CollectionReservationRepository(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    @Override
    public List<Reservation> findAll() {
        return List.copyOf(reservations);
    }

    @Override
    public Reservation save(Reservation reservation) {
        long id = counter.getAndIncrement();
        Reservation saved = new Reservation(id, reservation.name(), reservation.date(), reservation.time());
        reservations.add(saved);
        return saved;
    }

    @Override
    public void deleteById(long id) {
        reservations.removeIf(it -> it.id() == id);
    }
}
