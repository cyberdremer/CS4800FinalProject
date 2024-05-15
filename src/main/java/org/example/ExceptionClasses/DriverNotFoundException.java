package org.example.ExceptionClasses;

import java.util.Dictionary;

public class DriverNotFoundException extends RuntimeException{
    public DriverNotFoundException(String string){
        super(string);
    }
}
