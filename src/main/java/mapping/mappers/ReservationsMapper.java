package mapping.mappers;

import mapping.dtos.reservationsDTO;
import model.Reservations;

public class ReservationsMapper {
    public static reservationsDTO mapFromModel(Reservations reservations){
        return new reservationsDTO( reservations.getStart_Date(), reservations.getEnd_Date(), reservations.getIdVehicle(), reservations.getIdUser(), reservations.getStatus());

    }
    public static Reservations mapFromDTOo(reservationsDTO reservationsDTO){
        return Reservations.builder()
                .start_Date(reservationsDTO.start_date())
                .end_Date(reservationsDTO.end_date())
                .idVehicle(reservationsDTO.idVehicle())
                .idUser(reservationsDTO.idUser())
                .status(reservationsDTO.status())
                .build();
    }
}
