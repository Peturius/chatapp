package com.example.demo;

public class ErrorrHandler extends RuntimeException{
    ErrorrHandler(Long id) {
        super("Cica " + id);
    }
}

