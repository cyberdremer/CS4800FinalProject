package org.example.Entity.FoodItems.NutFree;

import org.example.Entity.FoodItems.Food.PadThai;

public class NutFreePadThai extends PadThai {

    public NutFreePadThai(double price) {
        super("Nut-Free Pad Thai", price);
    }

    @Override
    public boolean containsNuts() {
        return false;  
    }
}