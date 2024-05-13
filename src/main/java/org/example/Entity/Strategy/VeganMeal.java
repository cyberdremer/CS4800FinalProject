package org.example.Entity.Strategy;

import org.example.Entity.Factory.FoodRegistry;
import org.example.Entity.FoodItems.Food.AbstractFood;

import java.util.List;
import java.util.stream.Collectors;

public class VeganMeal implements MealPlanStrategy {
    private FoodRegistry registry;

    public VeganMeal(FoodRegistry registry) {
        this.registry = registry;
    }

    @Override
    public List<AbstractFood> customizeMeal() {
        return this.registry.getAllFoodItems().stream()
                            .filter(AbstractFood::isVegan)
                            .collect(Collectors.toList());
    }
}
