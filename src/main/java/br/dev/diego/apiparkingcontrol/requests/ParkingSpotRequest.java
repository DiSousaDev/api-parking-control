package br.dev.diego.apiparkingcontrol.requests;

import br.dev.diego.apiparkingcontrol.dto.CarDTO;
import br.dev.diego.apiparkingcontrol.services.validator.ParkingSpotValidator;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ParkingSpotValidator
public class ParkingSpotRequest {

    @NotBlank
    private String parkingSpotNumber;
    @NotBlank
    private String responsibleName;
    @NotBlank
    private String apartment;
    @NotBlank
    private String block;
    @NotNull
    private CarDTO car;

}
