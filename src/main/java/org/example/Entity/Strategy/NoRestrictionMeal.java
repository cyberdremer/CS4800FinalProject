package org.example.Entity.Strategy;

import org.example.Entity.Factory.FoodRegistry;
import org.example.Entity.FoodItems.Food.AbstractFood;

import java.util.List;

public class NoRestrictionMeal implements MealPlanStrategy {
    private FoodRegistry registry;

    public NoRestrictionMeal(FoodRegistry registry) {
        this.registry = registry;
    }

    @Override
    public List<AbstractFood> customizeMeal() {
        return this.registry.getAllFoodItems();
    }
}
