package org.example.Entity.Strategy;

import org.example.Entity.FoodItems.Food.AbstractFood;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class NoRestrictionMeal implements MealPlanStrategy {



    @Override
    public AbstractFood customizeMeal(List<AbstractFood> foods) {
        int randomIndex = ThreadLocalRandom.current().nextInt(0, foods.size());
        return foods.get(randomIndex);
    }
}
