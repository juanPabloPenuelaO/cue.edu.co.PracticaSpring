package repository.reservationsImpl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import model.Reservations;

@Repository
public interface ReservationsRepository extends JpaRepository<Reservations, Integer> {
}
