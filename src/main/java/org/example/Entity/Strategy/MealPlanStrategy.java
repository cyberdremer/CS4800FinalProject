package org.example.Entity.Strategy;

import java.util.List;

import org.example.Entity.FoodItems.Food.AbstractFood;

public interface MealPlanStrategy {
    public AbstractFood customizeMeal(List<AbstractFood> foods);
}
