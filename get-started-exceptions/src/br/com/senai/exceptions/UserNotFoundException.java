package br.com.senai.exceptions;

public class UserNotFoundException extends RuntimeException{


    public UserNotFoundException(String message) {
        super(message);
    }

}
