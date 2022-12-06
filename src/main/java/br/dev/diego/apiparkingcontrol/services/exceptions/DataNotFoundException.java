package br.dev.diego.apiparkingcontrol.services.exceptions;

public class DataNotFoundException extends RuntimeException {

    public DataNotFoundException(String message) {
        super(message);
    }

}
