package br.dev.diego.apiparkingcontrol.services;

import br.dev.diego.apiparkingcontrol.dto.ParkingSpotDTO;
import br.dev.diego.apiparkingcontrol.entities.ParkingSpot;
import br.dev.diego.apiparkingcontrol.repositories.CarRepository;
import br.dev.diego.apiparkingcontrol.repositories.ParkingSpotRepository;
import br.dev.diego.apiparkingcontrol.services.exceptions.DataNotFoundException;
import br.dev.diego.apiparkingcontrol.services.exceptions.DatabaseException;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

import static java.lang.String.format;

@Service
@AllArgsConstructor
public class ParkingSpotService {

    private final ParkingSpotRepository repository;
    private final CarRepository carRepository;

    @Transactional(readOnly = true)
    public ParkingSpotDTO findById(UUID id) {
        ParkingSpot parkingSpot = repository.findById(id).orElseThrow(() ->
                new DataNotFoundException(format("ParkingSpot id:[%s] not found!", id)));
        return new ParkingSpotDTO(parkingSpot);
    }

    @Transactional(readOnly = true)
    public Collection<ParkingSpotDTO> findAll() {
        List<ParkingSpot> list = repository.findAll();
        return list.stream().map(ParkingSpotDTO::new).toList();
    }

    @Transactional
    public ParkingSpotDTO save(ParkingSpotDTO dto) {
        ParkingSpot parkingSpot;
        try {
            parkingSpot = repository.save(new ParkingSpot(dto));
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Erro ao persistir entidade. " + e.getCause().getCause().toString());
        }
        return new ParkingSpotDTO(parkingSpot);
    }

    @Transactional
    public void deleteById(UUID id) {
        findById(id);
        repository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public boolean existsByLicensePlateCar(String licensePlate) {
        return carRepository.existsCarByLicensePlateCar(licensePlate);
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
