package br.dev.diego.apiparkingcontrol.repositories;

import br.dev.diego.apiparkingcontrol.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CarRepository extends JpaRepository<Car, Long> {

    Optional<Car> findCarByLicensePlateCar(String licensePlate);


}
