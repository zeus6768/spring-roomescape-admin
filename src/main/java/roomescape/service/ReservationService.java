package roomescape.service;

import java.util.List;

import org.springframework.stereotype.Service;

import roomescape.domain.Reservation;
import roomescape.dto.request.ReservationRequest;
import roomescape.dto.response.ReservationResponse;
import roomescape.repository.ReservationRepository;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public List<ReservationResponse> findAll() {
        return reservationRepository.findAll()
                .stream()
                .map(ReservationResponse::new)
                .toList();
    }

    public ReservationResponse create(ReservationRequest request) {
        Reservation reservation = request.toReservation();
        Reservation saved = reservationRepository.save(reservation);
        return new ReservationResponse(saved);
    }

    public void cancel(long id) {
        reservationRepository.deleteById(id);
    }
}
