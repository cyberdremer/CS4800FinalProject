package org.example.Entity.Strategy;

import org.example.Entity.FoodItems.Food;
import java.util.List;
import java.util.stream.Collectors;

public class PaleoMeal implements MealPlanStrategy {
    private List<Food> availableFoods;

    public PaleoMeal(List<Food> availableFoods) {
        this.availableFoods = availableFoods;
    }

    @Override
    public List<Food> customizeMeal() {
        return availableFoods.stream()
                             .filter(Food::isPaleo)
                             .collect(Collectors.toList());
    }
}
