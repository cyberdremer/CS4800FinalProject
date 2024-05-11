package org.example.Entity.Strategy;

import org.example.Entity.FoodItems.Food;

import java.util.List;

public interface MealPlanStrategy {
    public List<Food> customizeMeal();
}
