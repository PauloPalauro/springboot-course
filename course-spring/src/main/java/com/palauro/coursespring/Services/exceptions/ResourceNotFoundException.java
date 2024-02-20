package com.palauro.coursespring.Services.exceptions;

// Execeção personalizada para camada de Service.

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(Object id){ // Passar o id do objeto que tentei encontrar.
        super("Resource not found. ID " + id);
    }
    
}
