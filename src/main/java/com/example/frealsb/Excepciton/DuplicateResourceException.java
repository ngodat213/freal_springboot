package com.example.frealsb.Excepciton;

public class DuplicateResourceException extends RuntimeException{

    public DuplicateResourceException(String msg){
        super(msg);
    }
}