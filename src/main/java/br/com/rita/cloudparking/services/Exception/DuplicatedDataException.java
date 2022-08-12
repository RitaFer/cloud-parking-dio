package br.com.rita.cloudparking.services.Exception;

public class DuplicatedDataException extends RuntimeException{

    public DuplicatedDataException(String message) {
        super("message");
    }
}
