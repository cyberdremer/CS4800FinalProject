package org.example.Entity.FoodItems.Food;

public abstract class Topping implements Food {
    protected Food food;

    public Topping(Food food) {
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

    @Override
    public boolean containsNuts() {
        return food.containsNuts();  
    }

    @Override
    public boolean isVegan() {
        return food.isVegan();  
    }

    @Override
    public boolean isPaleo() {
        return food.isPaleo();  
    }
}
