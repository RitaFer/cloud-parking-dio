package br.com.rita.cloudparking.services.Exception;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(Long id) {
        super("Resource not found! Id: " + id);
    }
}
