package br.dev.diego.apiparkingcontrol.repositories;

import br.dev.diego.apiparkingcontrol.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {

}
