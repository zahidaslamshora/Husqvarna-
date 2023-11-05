package com.Husqvarna.assignment.exception;

public class StudentsNotFoundException extends RuntimeException {
    public StudentsNotFoundException(String message) {
        super(message);
    }
}