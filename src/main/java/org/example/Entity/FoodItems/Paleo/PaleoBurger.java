package org.example.Entity.FoodItems.Paleo;

import org.example.Entity.FoodItems.Food.Burger;

public class PaleoBurger extends Burger {

    public PaleoBurger(double price) {
        super("Paleo Burger", price);
    }

    @Override
    public boolean isPaleo() {
        return true;  
    }
}
