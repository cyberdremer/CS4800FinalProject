package org.example.Entity.FoodItems;

public class VeganPadThai extends PadThai {

    public VeganPadThai(double price) {
        super("Vegan Pad Thai", price);
    }

    @Override
    public boolean isVegan() {
        return true;  
    }
}