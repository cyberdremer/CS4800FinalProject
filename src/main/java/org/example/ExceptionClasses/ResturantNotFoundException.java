package org.example.ExceptionClasses;

public class ResturantNotFoundException extends RuntimeException{
    public ResturantNotFoundException(String string){
        super(string);
    }
}
