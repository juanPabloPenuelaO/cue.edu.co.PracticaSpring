package service;

import model.Reservations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.reservationsImpl.ReservationsRepositoryJDBC;

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

    @Transactional
    public void saveReservation(Reservations reservation) {
        reservationsRepository.save(reservation);
    }

    @Transactional
    public void updateReservation(Reservations reservation) {
        reservationsRepository.update(reservation);
    }

    @Transactional
    public void deleteReservation(int id) {
        reservationsRepository.delete(id);
    }
}

