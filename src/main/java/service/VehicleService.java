package service;

import model.Vehicles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.vehicleImpl.VehicleRepositoryJDBC;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepositoryJDBC vehicleRepository;

    public List<Vehicles> getAllVehicles() {
        return vehicleRepository.list();
    }

    public Vehicles getVehicleById(int id) {
        return vehicleRepository.byId(id);
    }

    @Transactional
    public void saveVehicle(Vehicles vehicle) {
        vehicleRepository.save(vehicle);
    }

    @Transactional
    public void updateVehicle(Vehicles vehicle) {
        vehicleRepository.update(vehicle);
    }

    @Transactional
    public void deleteVehicle(int id) {
        vehicleRepository.delete(id);
    }
}

