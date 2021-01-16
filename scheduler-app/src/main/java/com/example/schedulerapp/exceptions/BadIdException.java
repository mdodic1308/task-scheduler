package com.example.schedulerapp.exceptions;

public class BadIdException extends RuntimeException{
        public BadIdException() {
            super(String.format("Ids are different"));
        }
}
