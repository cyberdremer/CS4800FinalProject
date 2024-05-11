package org.example.Entity.Strategy;

import org.example.Entity.FoodItems.Food;

import java.util.List;

public class NoNutMeal implements MealPlanStrategy{

    @Override
    public List<Food> customizeMeal() {
        return null;
    }
}
