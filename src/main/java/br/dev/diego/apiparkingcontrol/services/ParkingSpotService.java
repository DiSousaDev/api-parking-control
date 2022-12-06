package br.dev.diego.apiparkingcontrol.services;

import br.dev.diego.apiparkingcontrol.dto.ParkingSpotDTO;
import br.dev.diego.apiparkingcontrol.entities.Car;
import br.dev.diego.apiparkingcontrol.entities.ParkingSpot;
import br.dev.diego.apiparkingcontrol.repositories.CarRepository;
import br.dev.diego.apiparkingcontrol.repositories.ParkingSpotRepository;
import br.dev.diego.apiparkingcontrol.services.exceptions.DatabaseException;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class ParkingSpotService {

    private final ParkingSpotRepository repository;
    private final CarRepository carRepository;

    @Transactional
    public ParkingSpotDTO save(ParkingSpotDTO dto) {
        Car car;
        ParkingSpot parkingSpot;
        try {
            car = carRepository.save(new Car(dto.getCar()));
            parkingSpot = repository.save(new ParkingSpot(dto, car));
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Erro ao persistir entidade. " + e.getCause().getCause().toString());
        }
        return new ParkingSpotDTO(parkingSpot);
    }

    @Transactional(readOnly = true)
    public boolean existsByLicensePlateCar(String licensePlate) {
        return carRepository.findCarByLicensePlateCar(licensePlate).isPresent();
    }

    @Transactional(readOnly = true)
    public boolean existsByParkingSpotNumber(String parkingSpotNumber) {
        return repository.findParkingSpotByParkingSpotNumber(parkingSpotNumber).isPresent();
    }

    @Transactional(readOnly = true)
    public boolean existsByApartmentAndBlock(String apartment, String block) {
        return repository.findParkingSpotByApartmentAndBlock(apartment, block).isPresent();
    }

}
