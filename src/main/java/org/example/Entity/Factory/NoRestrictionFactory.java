package org.example.Entity.Factory;

import org.example.Entity.FoodItems.Food.AbstractFood;
import org.example.Entity.FoodItems.Traditional.TraditionalBurger;
import org.example.Entity.FoodItems.Traditional.TraditionalBurrito;
import org.example.Entity.FoodItems.Traditional.TraditionalPadThai;

public class NoRestrictionFactory extends AbstractFoodFactory {
    private static NoRestrictionFactory noRestrictionFactory = null;
    private FoodRegistry foodRegistry;

    private NoRestrictionFactory(FoodRegistry foodRegistry) {
        this.foodRegistry = foodRegistry;
        registerFoods();
    }

    private void registerFoods() {
        this.foodRegistry.registerFood("burger", new TraditionalBurger(5.99));
        this.foodRegistry.registerFood("burrito", new TraditionalBurrito(6.99));
        this.foodRegistry.registerFood("padthai", new TraditionalPadThai(4.99));
    }

    public static NoRestrictionFactory getInstance(FoodRegistry foodRegistry) {
        if (noRestrictionFactory == null) {
            noRestrictionFactory = new NoRestrictionFactory(foodRegistry);
        }
        return noRestrictionFactory;
    }

    @Override
    public AbstractFood getFood(String foodName) {
        return this.foodRegistry.getFood(foodName);
    }
}
