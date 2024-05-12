package org.example.Entity.FoodItems.Vegan;

import org.example.Entity.FoodItems.Food.Burrito;

public class VeganBurrito extends Burrito {

    public VeganBurrito(double price) {
        super("Vegan Burrito", price);
    }

    @Override
    public boolean isVegan() {
        return true;
    }
}