package org.example.ExceptionClasses;

public class InvalidTopping extends RuntimeException{
    public InvalidTopping(String string){
        super(string);
    }
}
