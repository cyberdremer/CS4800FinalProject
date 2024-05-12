package org.example.Entity.FoodItems.Food;

public interface Food {
    public String getName();
    public double getPrice();
    public String getCategory();

    public boolean isVegan();
    public boolean containsNuts();
    public boolean isPaleo();
} 