package br.dev.diego.apiparkingcontrol.responses;

import br.dev.diego.apiparkingcontrol.dto.CarDTO;
import br.dev.diego.apiparkingcontrol.dto.ParkingSpotDTO;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ParkingSpotResponse {

    private UUID id;
    @NotBlank
    private String parkingSpotNumber;
    @NotBlank
    private String responsibleName;
    @NotBlank
    private String apartment;
    @NotBlank
    private String block;
    @NotBlank
    private CarDTO car;

    public ParkingSpotResponse(ParkingSpotDTO dto) {
        id = dto.getId();
        parkingSpotNumber = dto.getParkingSpotNumber();
        responsibleName = dto.getResponsibleName();
        apartment = dto.getApartment();
        block = dto.getBlock();
        car = dto.getCar();
    }
}
