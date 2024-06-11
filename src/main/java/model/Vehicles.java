package  model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Vehicles {
    private int id;
    private String type;
    private String model;
    private int modelYear;
    private String brand;
    private int priceDay;
    private String plate;
    private String availability;
}