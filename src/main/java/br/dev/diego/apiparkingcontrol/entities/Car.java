package br.dev.diego.apiparkingcontrol.entities;

import br.dev.diego.apiparkingcontrol.dto.CarDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "TB_CAR")
@AllArgsConstructor
@NoArgsConstructor
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true, length = 7)
    private String licensePlateCar;
    @Column(nullable = false, length = 70)
    private String brandCar;
    @Column(nullable = false, length = 70)
    private String modelCar;
    @Column(nullable = false, length = 70)
    private String colorCar;
    @OneToOne
    private ParkingSpot parkingSpot;

    public Car(CarDTO dto) {
        licensePlateCar = dto.getLicensePlateCar();
        brandCar = dto.getBrandCar();
        modelCar = dto.getModelCar();
        colorCar = dto.getColorCar();
    }
}
