package org.example.Entity.Strategy;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

import org.example.Entity.FoodItems.Food.AbstractFood;
import org.example.Entity.FoodItems.Food.Food;

public class NoNutMeal implements MealPlanStrategy {

    @Override
    public AbstractFood customizeMeal(List<AbstractFood> meals) {

       List<AbstractFood> possibleFoods =  meals.stream()
                            .filter(food -> !food.containsNuts())
                            .collect(Collectors.toList());
       int randomIndex = ThreadLocalRandom.current().nextInt(0, possibleFoods.size());
       return  possibleFoods.get(randomIndex);
    }
}
