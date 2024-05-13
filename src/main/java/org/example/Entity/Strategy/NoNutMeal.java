package org.example.Entity.Strategy;

import java.util.List;
import java.util.stream.Collectors;

import org.example.Entity.Factory.FoodRegistry;
import org.example.Entity.FoodItems.Food.AbstractFood;

public class NoNutMeal implements MealPlanStrategy {
    private FoodRegistry registry;

    public NoNutMeal(FoodRegistry registry) {
        this.registry = registry;
    }

    @Override
    public List<AbstractFood> customizeMeal() {
        return this.registry.getAllFoodItems().stream()
                            .filter(food -> !food.containsNuts())
                            .collect(Collectors.toList());
    }
}
