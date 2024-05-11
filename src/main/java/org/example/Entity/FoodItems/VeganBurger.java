package org.example.Entity.FoodItems;

public class VeganBurger extends Burger {

    public VeganBurger(double price) {
        super("Vegan Burger", price);
    }

    @Override
    public boolean isVegan() {
        return true;  
    }
}