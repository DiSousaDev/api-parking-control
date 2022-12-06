package br.dev.diego.apiparkingcontrol.services;

import br.dev.diego.apiparkingcontrol.dto.ParkingSpotDTO;
import br.dev.diego.apiparkingcontrol.entities.Car;
import br.dev.diego.apiparkingcontrol.entities.ParkingSpot;
import br.dev.diego.apiparkingcontrol.repositories.CarRepository;
import br.dev.diego.apiparkingcontrol.repositories.ParkingSpotRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class ParkingSpotService {

    private final ParkingSpotRepository repository;
    private final CarRepository carRepository;

    @Transactional
    public ParkingSpotDTO save(ParkingSpotDTO parkingSpotInsertRCD) {
        Car car = carRepository.save(new Car(parkingSpotInsertRCD.getCar()));
        ParkingSpot parkingSpot = repository.save(new ParkingSpot(parkingSpotInsertRCD, car));
        return new ParkingSpotDTO(parkingSpot);
    }

}
