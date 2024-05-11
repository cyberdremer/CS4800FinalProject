package org.example.Entity.FoodItems;

public class PaleoBurrito extends Burrito{
    public PaleoBurrito(double price) {
        super("Paleo Burrito", price);
    }

    @Override
    public boolean isPaleo() {
        return true;
    }
}
