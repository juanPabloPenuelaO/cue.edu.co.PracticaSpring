package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.reservationsImpl.ReservationsRepositoryJDBC;
import model.Reservations;

import java.util.List;

@Service
public class ReservationsService {

    @Autowired
    private ReservationsRepositoryJDBC reservationsRepository;

    public List<Reservations> getAllReservations() {
        return reservationsRepository.list();
    }

    public Reservations getReservationById(int id) {
        return reservationsRepository.byId(id);
    }

    public void saveReservation(Reservations reservation) {
        reservationsRepository.save(reservation);
    }

    public void updateReservation(Reservations reservation) {
        reservationsRepository.update(reservation);
    }

    public void deleteReservation(int id) {
        reservationsRepository.delete(id);
    }
}

