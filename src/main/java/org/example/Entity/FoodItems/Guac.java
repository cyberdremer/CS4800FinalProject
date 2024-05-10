package org.example.Entity.FoodItems;

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
        return "Guac" + super.getName();
    }
}

