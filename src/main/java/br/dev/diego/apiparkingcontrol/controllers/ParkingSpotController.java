package br.dev.diego.apiparkingcontrol.controllers;

import br.dev.diego.apiparkingcontrol.dto.ParkingSpotDTO;
import br.dev.diego.apiparkingcontrol.requests.ParkingSpotRequest;
import br.dev.diego.apiparkingcontrol.responses.ParkingSpotResponse;
import br.dev.diego.apiparkingcontrol.services.ParkingSpotService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Collection;
import java.util.UUID;

@RestController
@RequestMapping("/parkin-spot")
@AllArgsConstructor
public class ParkingSpotController {

    private final ParkingSpotService parkingSpotService;

    @GetMapping("/{id}")
    public ResponseEntity<ParkingSpotResponse> findById(@PathVariable UUID id) {
        ParkingSpotDTO dto = parkingSpotService.findById(id);
        return ResponseEntity.ok(new ParkingSpotResponse(dto));
    }

    @GetMapping
    public ResponseEntity<Collection<ParkingSpotResponse>> findAll() {
        Collection<ParkingSpotDTO> list = parkingSpotService.findAll();
        return ResponseEntity.ok(list.stream().map(ParkingSpotResponse::new).toList());
    }

    @PostMapping
    public ResponseEntity<ParkingSpotResponse> saveParkingSpot(@RequestBody @Valid ParkingSpotRequest request) {
        ParkingSpotDTO dto = parkingSpotService.save(new ParkingSpotDTO(request));
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(new ParkingSpotResponse(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable UUID id) {
        parkingSpotService.deleteById(id);
        return ResponseEntity.noContent().build();
    }


}
