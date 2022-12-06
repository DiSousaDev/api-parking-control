package br.dev.diego.apiparkingcontrol.services.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = ParkingSpotRequestValidator.class)
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface ParkingSpotValidator {

    String message() default "Erro de validação";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

}
