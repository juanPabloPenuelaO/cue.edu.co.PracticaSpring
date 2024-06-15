package cue.edu.co.PracticaSpringBoot.demo.controllers;

import model.Vehicles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.VehicleService;

import java.util.List;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @GetMapping
    public List<Vehicles> getAllVehicles() {
        return vehicleService.getAllVehicles();
    }

    @GetMapping("/{id}")
    public Vehicles getVehicleById(@PathVariable int id) {
        return vehicleService.getVehicleById(id);
    }

    @PostMapping
    public void addVehicle(@RequestBody Vehicles vehicle) {
        vehicleService.saveVehicle(vehicle);
    }

    @PutMapping("/{id}")
    public void updateVehicle(@PathVariable int id, @RequestBody Vehicles vehicle) {
        vehicle.setId(id); // Ensure the ID is set correctly
        vehicleService.updateVehicle(vehicle);
    }

    @DeleteMapping("/{id}")
    public void deleteVehicle(@PathVariable int id) {
        vehicleService.deleteVehicle(id);
    }
}

