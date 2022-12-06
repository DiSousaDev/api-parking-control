package br.dev.diego.apiparkingcontrol.services.validator;

import br.dev.diego.apiparkingcontrol.controllers.exceptions.CustomFieldError;
import br.dev.diego.apiparkingcontrol.requests.ParkingSpotRequest;
import br.dev.diego.apiparkingcontrol.services.ParkingSpotService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class ParkingSpotRequestValidator implements ConstraintValidator<ParkingSpotValidator, ParkingSpotRequest> {

    private final ParkingSpotService service;

    @Override
    public boolean isValid(ParkingSpotRequest request, ConstraintValidatorContext context) {

        List<CustomFieldError> list = new ArrayList<>();

        if (service.existsByLicensePlateCar(request.getCar().getLicensePlateCar())) {
            list.add(new CustomFieldError("car", "Veículo já cadastrado"));
        }

        if (service.existsByParkingSpotNumber(request.getParkingSpotNumber())) {
            list.add(new CustomFieldError("parkingSpotNumber", "Vaga em uso"));
        }

        if (service.existsByApartmentAndBlock(request.getApartment(), request.getBlock())) {
            list.add(new CustomFieldError("apartment", "Apartamento ja possui cadastro"));
        }

        for (CustomFieldError e : list) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(e.getFieldMessage()).addPropertyNode(e.getFieldName())
                    .addConstraintViolation();
        }
        return list.isEmpty();
    }
}
