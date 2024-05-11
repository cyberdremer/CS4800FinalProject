package org.example.Entity.FoodItems;

public class PaleoBurger extends Burger {

    public PaleoBurger(double price) {
        super("Paleo Burger", price);
    }

    @Override
    public boolean isPaleo() {
        return true;  
    }
}
