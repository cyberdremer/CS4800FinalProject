package org.example.Entity.FoodItems.Toppings;

import org.example.Entity.FoodItems.Food.Food;

public class Cheese extends Topping{
    private double cheesePrice;

    public Cheese(Food food, double cheesePrice) {
        super(food);
        this.cheesePrice = cheesePrice;
    }

    @Override
    public double getPrice() {
        return super.getPrice() + cheesePrice;
    }

    @Override
    public String getName() {
        return "Cheese " + super.getName();
    }

    @Override
    public boolean isVegan() {
        return super.isVegan() && false;
    }

    @Override
    public boolean containsNuts() {
        return super.containsNuts();
    }

    @Override
    public boolean isPaleo() {
        return super.isPaleo() && false;
    }
}
