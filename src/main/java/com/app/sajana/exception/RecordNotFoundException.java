package com.app.sajana.exception;

public class RecordNotFoundException extends RuntimeException {
    public RecordNotFoundException(int id) {
        super("No record found for id " + id);
    }
}
