package org.example.Entity.FoodItems;

public abstract class Burrito extends AbstractFood {

    public Burrito(String name, double price) {
        super(name, price, "Mexican");  
    }

    @Override
    public boolean isVegan() {
        return false;  
    }

    @Override
    public boolean isPaleo() {
        return false;  
    }

    @Override
    public boolean containsNuts() {
        return false; 
    }
}
