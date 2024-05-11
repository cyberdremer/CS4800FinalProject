package org.example.Entity.FoodItems;

public class PaleoPadThai extends PadThai {

    public PaleoPadThai(double price) {
        super("Paleo Pad Thai", price);
    }

    @Override
    public boolean isPaleo() {
        return true;  
    }

    @Override
    public boolean containsNuts() {
        return false;
    }
}