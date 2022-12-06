package br.dev.diego.apiparkingcontrol.controllers;

import br.dev.diego.apiparkingcontrol.services.ParkingSpotService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/parkin-spot")
@AllArgsConstructor
public class ParkingSpotController {

    private final ParkingSpotService parkingSpotService;


}
