package com.macv.fastfood.service;

public class EmailException extends RuntimeException{
    public EmailException() {
        super("Error enviando Email");
    }
}
