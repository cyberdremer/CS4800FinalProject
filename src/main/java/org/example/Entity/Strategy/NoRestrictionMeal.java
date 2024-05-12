package org.example.Entity.Strategy;

import org.example.Entity.FoodItems.Food.Food;

import java.util.ArrayList;
import java.util.List;

public class NoRestrictionMeal implements MealPlanStrategy {
    private List<Food> availableFoods;

    public NoRestrictionMeal(List<Food> availableFoods) {
        this.availableFoods = availableFoods;
    }

    @Override
    public List<Food> customizeMeal() {
        return new ArrayList<>(availableFoods); 
    }
}
