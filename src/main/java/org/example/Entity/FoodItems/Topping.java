package org.example.Entity.FoodItems;

public abstract class Topping implements Food{
    private Food food;
    public Topping (Food food){
        this.food = food;
    }

    @Override
    public double getPrice() {
        return food.getPrice();
    }

    @Override
    public String getCategory() {
        return food.getCategory();
    }

    @Override
    public String getName() {
        return food.getName();
    }
}
