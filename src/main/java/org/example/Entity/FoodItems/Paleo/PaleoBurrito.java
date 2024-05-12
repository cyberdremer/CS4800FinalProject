package org.example.Entity.FoodItems.Paleo;

import org.example.Entity.FoodItems.Food.Burrito;

public class PaleoBurrito extends Burrito {
    public PaleoBurrito(double price) {
        super("Paleo Burrito", price);
    }

    @Override
    public boolean isPaleo() {
        return true;
    }
}
