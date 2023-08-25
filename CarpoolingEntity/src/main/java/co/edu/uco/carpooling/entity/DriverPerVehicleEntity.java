package co.edu.uco.carpooling.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "driverPerVehicle")
public class DriverPerVehicleEntity {
    @Id
    private UUID id;
    private String name;
    private String nameVehicle;

}
