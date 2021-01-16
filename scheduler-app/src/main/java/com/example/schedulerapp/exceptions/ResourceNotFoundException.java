package com.example.schedulerapp.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(Long id) {
        super(String.format("Resource with id=%s not found", id));
    }
}
