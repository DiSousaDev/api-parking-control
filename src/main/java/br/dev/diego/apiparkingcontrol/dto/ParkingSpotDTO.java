package br.dev.diego.apiparkingcontrol.dto;

import br.dev.diego.apiparkingcontrol.entities.ParkingSpot;
import br.dev.diego.apiparkingcontrol.requests.ParkingSpotRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ParkingSpotDTO {

    private UUID id;
    private String parkingSpotNumber;
    private String responsibleName;
    private String apartment;
    private String block;
    private CarDTO car;

    public ParkingSpotDTO(ParkingSpot entity) {
        id = entity.getId();
        parkingSpotNumber = entity.getParkingSpotNumber();
        responsibleName = entity.getResponsibleName();
        apartment = entity.getApartment();
        block = entity.getBlock();
        car = new CarDTO(entity.getCar());
    }

    public ParkingSpotDTO(ParkingSpotRequest request) {
        parkingSpotNumber = request.getParkingSpotNumber();
        responsibleName = request.getResponsibleName();
        apartment = request.getApartment();
        block = request.getBlock();
        car = request.getCar();
    }
}
