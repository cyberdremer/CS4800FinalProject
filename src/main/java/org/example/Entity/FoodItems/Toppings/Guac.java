package org.example.Entity.FoodItems.Toppings;

import org.example.Entity.FoodItems.Food.Food;

public class Guac extends Topping {
    private double guacPrice;

    public Guac(Food food, double guacPrice) {
        super(food);
        this.guacPrice = guacPrice;
    }

    @Override
    public double getPrice() {
        return super.getPrice() + guacPrice;
    }

    @Override
    public String getName() {
        return "Guac " + super.getName(); 
    }

    @Override
    public boolean isVegan() {
        return super.isVegan();
    }

    @Override
    public boolean containsNuts() {
        return super.containsNuts();
    }

    @Override
    public boolean isPaleo() {
        return super.isPaleo();
    }
}
