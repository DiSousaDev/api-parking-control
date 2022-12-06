package br.dev.diego.apiparkingcontrol.records;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CarRCD(
        @NotBlank
        @Size(max = 7)
        String licencePlateCar,
        @NotBlank
        String brandCar,
        @NotBlank
        String modelCar,
        @NotBlank
        String colorCar
) {
}
