package  model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "vehicles")
@Entity

public class Vehicles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String type;
    private String model;
    private int modelYear;
    private String brand;
    private int priceDay;
    private String plate;
    private String availability;


    @OneToMany(mappedBy = "vehicle")
    @JsonIgnoreProperties("vehicle")
    private List<Reservations> reservations;

}