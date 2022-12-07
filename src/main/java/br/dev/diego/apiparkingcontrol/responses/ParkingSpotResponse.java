package br.dev.diego.apiparkingcontrol.responses;

import br.dev.diego.apiparkingcontrol.dto.CarDTO;
import br.dev.diego.apiparkingcontrol.dto.ParkingSpotDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ParkingSpotResponse {

    private UUID id;
    private String parkingSpotNumber;
    private String responsibleName;
    private String apartment;
    private String block;
    private LocalDateTime registrationDate;
    private CarDTO car;

    public ParkingSpotResponse(ParkingSpotDTO dto) {
        id = dto.getId();
        parkingSpotNumber = dto.getParkingSpotNumber();
        responsibleName = dto.getResponsibleName();
        apartment = dto.getApartment();
        block = dto.getBlock();
        registrationDate= dto.getRegistrationDate();
        car = dto.getCar();
    }
}
