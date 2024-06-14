package model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "reservations")
@Entity
public class Reservations {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Date start_Date;
    private Date end_Date;
    private int idVehicle;
    private int idUser;
    private String status;

    @ManyToOne
    @JoinColumn(name = "id_vehicle", referencedColumnName = "id")
    @JsonIgnoreProperties("reservations")
    private Vehicles vehicles;

    @ManyToOne
    @JoinColumn(name = "id_user", referencedColumnName = "id")
    @JsonIgnoreProperties("reservations")
    private User user;
}

