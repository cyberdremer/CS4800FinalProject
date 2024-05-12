package org.example.Entity.FoodItems.Food;

public abstract class PadThai extends AbstractFood {

    public PadThai(String name, double price) {
        super(name, price, "Thai"); 
    }

    @Override
    public boolean isVegan() {
        return false;  
    }

    @Override
    public boolean containsNuts() {
        return true;  
    }

    @Override
    public boolean isPaleo() {
        return false;  
    }
}
