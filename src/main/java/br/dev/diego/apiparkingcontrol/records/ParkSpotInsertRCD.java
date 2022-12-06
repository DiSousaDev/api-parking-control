package br.dev.diego.apiparkingcontrol.records;

import jakarta.validation.constraints.NotBlank;

public record ParkSpotInsertRCD(
        @NotBlank
        String parkingSpotNumer,
        @NotBlank
        String responsibleName,
        @NotBlank
        String apartment,
        @NotBlank
        String block,
        @NotBlank
        CarRCD car
) {}
