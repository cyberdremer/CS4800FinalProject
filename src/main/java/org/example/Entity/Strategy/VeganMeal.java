package org.example.Entity.Strategy;

import org.example.Entity.FoodItems.Food;
import java.util.List;
import java.util.stream.Collectors;

public class VeganMeal implements MealPlanStrategy {
    private List<Food> availableFoods;

    public VeganMeal(List<Food> availableFoods) {
        this.availableFoods = availableFoods;
    }

    @Override
    public List<Food> customizeMeal() {
        return availableFoods.stream()
                             .filter(Food::isVegan)
                             .collect(Collectors.toList());
    }
}
