package com.example.huiswerk_les10_techiteasy.exceptions;

import org.springframework.http.HttpStatus;

public class RecordNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    public RecordNotFoundException() {
        super();
    }
    public RecordNotFoundException(String message) {
        super(message);
    }


    public RecordNotFoundException(String no_found, HttpStatus notFound) {
    }
}
