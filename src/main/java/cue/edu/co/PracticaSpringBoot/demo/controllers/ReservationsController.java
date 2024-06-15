package cue.edu.co.PracticaSpringBoot.demo.controllers;

import model.Reservations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.ReservationsService;

import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationsController {

    @Autowired
    private ReservationsService reservationsService;

    @GetMapping
    public List<Reservations> getAllReservations() {
        return reservationsService.getAllReservations();
    }

    @GetMapping("/{id}")
    public Reservations getReservationById(@PathVariable int id) {
        return reservationsService.getReservationById(id);
    }

    @PostMapping
    public void addReservation(@RequestBody Reservations reservation) {
        reservationsService.saveReservation(reservation);
    }

    @PutMapping("/{id}")
    public void updateReservation(@PathVariable int id, @RequestBody Reservations reservation) {
        reservation.setId(id); // Ensure the ID is set correctly
        reservationsService.updateReservation(reservation);
    }

    @DeleteMapping("/{id}")
    public void deleteReservation(@PathVariable int id) {
        reservationsService.deleteReservation(id);
    }
}
