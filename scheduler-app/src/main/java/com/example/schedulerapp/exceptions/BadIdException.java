package com.example.schedulerapp.exceptions;

public class BadIdException extends RuntimeException{
        public BadIdException() {
            super("Ids are different");
        }
}
