package mapping.mappers;

import mapping.dtos.userDTO;
import mapping.dtos.vehiclesDTO;
import model.Vehicles;
public class VehicleMapper {
    public static Vehicles mapFrom(vehiclesDTO vehiclesDTO) {
        return Vehicles.builder()
                .type(vehiclesDTO.type())
                .model(vehiclesDTO.model())
                .modelYear(vehiclesDTO.modelYear())
                .brand(vehiclesDTO.brand())
                .priceDay(vehiclesDTO.priceDay())
                .plate(vehiclesDTO.plate())
                .availability(vehiclesDTO.availability())
                .build();

    }

    public static vehiclesDTO mapFrom(Vehicles vehicles) {
        return vehiclesDTO.builder()
                .type(vehicles.getType())
                .model(vehicles.getModel())
                .modelYear(vehicles.getModelYear())
                .brand(vehicles.getBrand())
                .priceDay(vehicles.getPriceDay())
                .plate(vehicles.getPlate())
                .availability(vehicles.getAvailability())
                .build();
    }
}
