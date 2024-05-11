package org.example.Entity.FoodItems;

public abstract class Burger extends AbstractFood {

    public Burger(String name, double price) {
        super(name, price, "American");  
    }

    @Override
    public boolean isVegan() {
        return false; 
    }

    @Override
    public boolean containsNuts() {
        return false;  
    }

    @Override
    public boolean isPaleo() {
        return false;  
    }
}
