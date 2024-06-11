package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Reservations {
    private int id;
    private Date start_Date;
    private Date end_Date;
    private int idVehicle;
    private int idUser;
    private String status;
}
