package org.example.ExceptionClasses;

public class InvalidMealPlan extends RuntimeException{
    public InvalidMealPlan(String string){
        super(string);

    }
}
