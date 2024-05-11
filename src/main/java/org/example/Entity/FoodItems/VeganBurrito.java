package org.example.Entity.FoodItems;

public class VeganBurrito extends Burrito {

    public VeganBurrito(double price) {
        super("Vegan Burrito", price);
    }

    @Override
    public boolean isVegan() {
        return true;
    }
}