package org.example.Entity.FoodItems.Vegan;

import org.example.Entity.FoodItems.Food.PadThai;

public class VeganPadThai extends PadThai {

    public VeganPadThai(double price) {
        super("Vegan Pad Thai", price);
    }

    @Override
    public boolean isVegan() {
        return true;  
    }
}