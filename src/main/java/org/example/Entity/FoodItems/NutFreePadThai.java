package org.example.Entity.FoodItems;

public class NutFreePadThai extends PadThai {

    public NutFreePadThai(double price) {
        super("Nut-Free Pad Thai", price);
    }

    @Override
    public boolean containsNuts() {
        return false;  
    }
}