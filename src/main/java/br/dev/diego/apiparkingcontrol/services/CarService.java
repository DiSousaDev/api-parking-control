package br.dev.diego.apiparkingcontrol.services;

import br.dev.diego.apiparkingcontrol.repositories.CarRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CarService {

    private CarRepository repository;

}
