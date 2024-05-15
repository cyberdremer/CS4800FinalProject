package org.example.Entity.Strategy;

import org.example.Entity.FoodItems.Food.AbstractFood;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class VeganMeal implements MealPlanStrategy {


    @Override
    public AbstractFood customizeMeal(List<AbstractFood> foods) {

        List<AbstractFood> possibleFoods =  foods.stream()
                .filter(AbstractFood::isVegan)
                .collect(Collectors.toList());
        int randomIndex = ThreadLocalRandom.current().nextInt(0, possibleFoods.size());

        return possibleFoods.get(randomIndex);
    }
}
