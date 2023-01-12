package com.example.demo;

public class ChatNotFoundException extends RuntimeException {

    public ChatNotFoundException(String message) {
        super(message);
    }

}