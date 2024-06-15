package cue.edu.co.PracticaSpringBoot.demo;

import model.Vehicles;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import repository.vehicleImpl.VehicleRepositoryJDBC;
import service.VehicleService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class VehicleServiceTest {

    /*@Mock
    private VehicleRepositoryJDBC vehicleRepository;

    @InjectMocks
    private VehicleService vehicleService;

    private Vehicles vehicle;

    @BeforeEach
    void setUp() {
        vehicle = new Vehicles();
        vehicle.setId(1);
        vehicle.setType("Sedan");
        vehicle.setModel("Toyota Camry");
        vehicle.setModelYear(2023);
        vehicle.setBrand("Toyota");
        vehicle.setPriceDay(50);
        vehicle.setPlate("ABC123");
        vehicle.setAvailability("Available");

        // Simulate the behavior of VehicleRepositoryJDBC
        when(vehicleRepository.byId(1)).thenReturn(vehicle);
        when(vehicleRepository.list()).thenReturn(List.of(vehicle));
        when(vehicleRepository.save(any(Vehicles.class))).thenReturn(vehicle);
    }

    @Test
    void testGetAllVehicles() {
        // Call the service method
        List<Vehicles> vehicles = vehicleService.getAllVehicles();

        // Verify that the service method returns the correct list of vehicles
        assertEquals(1, vehicles.size());
        Vehicles foundVehicle = vehicles.get(0);
        assertEquals("Sedan", foundVehicle.getType());
        assertEquals("Toyota Camry", foundVehicle.getModel());
        assertEquals(2023, foundVehicle.getModelYear());
        assertEquals("Toyota", foundVehicle.getBrand());
        assertEquals(50, foundVehicle.getPriceDay());
        assertEquals("ABC123", foundVehicle.getPlate());
        assertEquals("Available", foundVehicle.getAvailability());

        // Verify that VehicleRepositoryJDBC's list method was called exactly once
        verify(vehicleRepository, times(1)).list();
    }

    @Test
    void testGetVehicleById() {
        // Call the service method
        Vehicles foundVehicle = vehicleService.getVehicleById(1);

        // Verify that the service method returns the correct vehicle
        assertEquals("Sedan", foundVehicle.getType());
        assertEquals("Toyota Camry", foundVehicle.getModel());
        assertEquals(2023, foundVehicle.getModelYear());
        assertEquals("Toyota", foundVehicle.getBrand());
        assertEquals(50, foundVehicle.getPriceDay());
        assertEquals("ABC123", foundVehicle.getPlate());
        assertEquals("Available", foundVehicle.getAvailability());

        // Verify that VehicleRepositoryJDBC's byId method was called exactly once with ID 1
        verify(vehicleRepository, times(1)).byId(1);
    }

    @Test
    void testSaveVehicle() {
        // Call the service method to save a new vehicle
        Vehicles newVehicle = new Vehicles();
        newVehicle.setType("SUV");
        newVehicle.setModel("Honda CR-V");
        newVehicle.setModelYear(2022);
        newVehicle.setBrand("Honda");
        newVehicle.setPriceDay(60);
        newVehicle.setPlate("XYZ789");
        newVehicle.setAvailability("Available");

        Vehicles savedVehicle = vehicleService.saveVehicle(newVehicle);

        // Verify that the saved vehicle has the correct attributes
        assertEquals("SUV", savedVehicle.getType());
        assertEquals("Honda CR-V", savedVehicle.getModel());
        assertEquals(2022, savedVehicle.getModelYear());
        assertEquals("Honda", savedVehicle.getBrand());
        assertEquals(60, savedVehicle.getPriceDay());
        assertEquals("XYZ789", savedVehicle.getPlate());
        assertEquals("Available", savedVehicle.getAvailability());

        // Verify that VehicleRepositoryJDBC's save method was called exactly once with any Vehicles object
        verify(vehicleRepository, times(1)).save(any(Vehicles.class));
    }

    @Test
    void testUpdateVehicle() {
        // Update the availability of the vehicle
        vehicle.setAvailability("Booked");

        // Call the service method to update the vehicle
        vehicleService.updateVehicle(vehicle);

        // Verify that VehicleRepositoryJDBC's update method was called exactly once with the updated vehicle
        verify(vehicleRepository, times(1)).update(vehicle);
    }

    @Test
    void testDeleteVehicle() {
        // Call the service method to delete the vehicle with ID 1
        vehicleService.deleteVehicle(1);

        // Verify that VehicleRepositoryJDBC's delete method was called exactly once with ID 1
        verify(vehicleRepository, times(1)).delete(1);
    }
    */

}
