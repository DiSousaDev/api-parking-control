package br.dev.diego.apiparkingcontrol.services.exceptions;

public class DatabaseException extends RuntimeException {

    public DatabaseException(String message) {
        super(message);
    }

}
