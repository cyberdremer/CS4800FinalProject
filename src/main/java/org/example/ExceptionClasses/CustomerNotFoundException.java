package org.example.ExceptionClasses;

import org.example.Entity.Customer;

public class CustomerNotFoundException extends RuntimeException{
    public CustomerNotFoundException(String string){
        super(string);
    }

}
