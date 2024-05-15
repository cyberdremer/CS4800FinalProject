package org.example.ExceptionClasses;

public class InvalidFood extends RuntimeException{
    public InvalidFood(String string){
        super(string);
    }
}
