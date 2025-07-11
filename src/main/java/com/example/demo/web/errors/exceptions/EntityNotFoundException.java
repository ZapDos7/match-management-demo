package com.example.demo.web.errors.exceptions;

public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException(String entityName, Long id) {
        super(String.format("%s with id %d was not found", entityName, id));
    }

    public EntityNotFoundException(String message) {
        super(message);
    }
}
