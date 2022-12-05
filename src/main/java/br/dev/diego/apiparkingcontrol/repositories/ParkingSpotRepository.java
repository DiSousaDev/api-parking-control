package br.dev.diego.apiparkingcontrol.repositories;

import br.dev.diego.apiparkingcontrol.entities.ParkingSpot;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ParkingSpotRepository extends JpaRepository<ParkingSpot, UUID> {

}
