package br.dev.diego.apiparkingcontrol.entities;

import br.dev.diego.apiparkingcontrol.dto.ParkingSpotDTO;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.UUID;

@Data
@Entity
@Table(name = "TB_PARKING_SPOT")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ParkingSpot {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(nullable = false, unique = true, length = 10)
    private String parkingSpotNumber;
    @Column(nullable = false, length = 130)
    private String responsibleName;
    @Column(nullable = false, length = 30)
    private String apartment;
    @Column(nullable = false, length = 30)
    private String block;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "car_id", referencedColumnName = "id")
    private Car car;
    private LocalDateTime registrationDate;

    public ParkingSpot(ParkingSpotDTO dto, Car car) {
        parkingSpotNumber = dto.getParkingSpotNumber();
        responsibleName = dto.getResponsibleName();
        apartment = dto.getApartment();
        block = dto.getBlock();
        this.car = car;
    }

    @PrePersist
    private void setRegistrationDate() {
        registrationDate = LocalDateTime.now(ZoneId.of("UTC"));
    }

}
