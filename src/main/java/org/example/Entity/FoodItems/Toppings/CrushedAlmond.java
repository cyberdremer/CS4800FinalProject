package org.example.Entity.FoodItems.Toppings;

import org.example.Entity.FoodItems.Food.Food;

public class CrushedAlmond extends Topping{
    private double almondPrice;

    public CrushedAlmond(Food food, double almondPrice) {
        super(food);
        this.almondPrice = almondPrice;
    }

    @Override
    public double getPrice() {
        return super.getPrice() + almondPrice;
    }

    @Override
    public String getName() {
        return "Crushed Almond " + super.getName();
    }

    @Override
    public boolean isVegan() {
        return super.isVegan() && false;
    }

    @Override
    public boolean containsNuts() {
        return super.containsNuts() && true;
    }

    @Override
    public boolean isPaleo() {
        return super.isPaleo() && true;
    }
}
