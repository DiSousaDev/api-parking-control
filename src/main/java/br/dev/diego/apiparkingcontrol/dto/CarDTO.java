package br.dev.diego.apiparkingcontrol.dto;

import br.dev.diego.apiparkingcontrol.entities.Car;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class CarDTO {

    private Long id;
    @NotBlank
    @Size(max = 7)
    private String licensePlateCar;
    @NotBlank
    private String brandCar;
    @NotBlank
    private String modelCar;
    @NotBlank
    private String colorCar;

    public CarDTO(Car entity) {
        id = entity.getId();
        licensePlateCar = entity.getLicensePlateCar();
        brandCar = entity.getBrandCar();
        modelCar = entity.getModelCar();
        colorCar = entity.getColorCar();
    }
}

