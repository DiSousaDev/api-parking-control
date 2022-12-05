package br.dev.diego.apiparkingcontrol.services;

import br.dev.diego.apiparkingcontrol.repositories.ParkingSpotRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ParkingSpotService {

    private final ParkingSpotRepository repository;

}
