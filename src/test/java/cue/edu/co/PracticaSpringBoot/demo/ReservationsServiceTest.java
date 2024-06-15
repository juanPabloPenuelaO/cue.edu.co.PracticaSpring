package cue.edu.co.PracticaSpringBoot.demo;

import model.Reservations;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import repository.reservationsImpl.ReservationsRepositoryJDBC;
import service.ReservationsService;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ReservationsServiceTest {

    @Mock
    private ReservationsRepositoryJDBC reservationsRepository;

    @InjectMocks
    private ReservationsService reservationsService;

    private Reservations reservation;

    @BeforeEach
    void setUp() {
        reservation = new Reservations();
        reservation.setId(1);
        reservation.setStart_Date(new Date());
        reservation.setEnd_Date(new Date());
        reservation.setIdVehicle(1);
        reservation.setIdUser(1);
        reservation.setStatus("Active");

        when(reservationsRepository.byId(1)).thenReturn(reservation);
        when(reservationsRepository.list()).thenReturn(Arrays.asList(reservation));
        doNothing().when(reservationsRepository).save(any(Reservations.class));
        doNothing().when(reservationsRepository).update(any(Reservations.class));
        doNothing().when(reservationsRepository).delete(1);
    }

    @Test
    void testGetAllReservations() {
        List<Reservations> reservationsList = reservationsService.getAllReservations();
        assertEquals(1, reservationsList.size());
        assertEquals(reservation.getId(), reservationsList.get(0).getId());
    }

    @Test
    void testGetReservationById() {
        Reservations foundReservation = reservationsService.getReservationById(1);
        assertEquals(reservation.getId(), foundReservation.getId());
    }

    @Test
    void testSaveReservation() {
        reservationsService.saveReservation(reservation);
        verify(reservationsRepository, times(1)).save(any(Reservations.class));
    }

    @Test
    void testUpdateReservation() {
        reservationsService.updateReservation(reservation);
        verify(reservationsRepository, times(1)).update(any(Reservations.class));
    }

    @Test
    void testDeleteReservation() {
        reservationsService.deleteReservation(1);
        verify(reservationsRepository, times(1)).delete(1);
    }
}

