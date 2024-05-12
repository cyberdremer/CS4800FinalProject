package org.example.Entity.FoodItems.Vegan;

import org.example.Entity.FoodItems.Food.Burger;

public class VeganBurger extends Burger {

    public VeganBurger(double price) {
        super("Vegan Burger", price);
    }

    @Override
    public boolean isVegan() {
        return true;  
    }
}