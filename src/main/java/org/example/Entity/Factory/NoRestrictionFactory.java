package org.example.Entity.Factory;

import org.example.Entity.FoodItems.Food.AbstractFood;
import org.example.Entity.FoodItems.Traditional.TraditionalBurger;
import org.example.Entity.FoodItems.Traditional.TraditionalBurrito;
import org.example.Entity.FoodItems.Traditional.TraditionalPadThai;

import java.util.HashMap;

public class NoRestrictionFactory extends AbstractFoodFactory{
    private static HashMap<String, AbstractFood> foodHashMap = new HashMap<>();
    private static NoRestrictionFactory noRestrictionFactory = null;
    private NoRestrictionFactory(){}

    static {
        foodHashMap.put("burger", new TraditionalBurger(5.99));
        foodHashMap.put("burrito", new TraditionalBurrito(6.99));
        foodHashMap.put("padthai", new TraditionalPadThai(4.99));
    }
    public static NoRestrictionFactory getInstance() {
        if (noRestrictionFactory == null){
            noRestrictionFactory = new NoRestrictionFactory();
        }
        return noRestrictionFactory;
    }
    @Override
    AbstractFood getFood(String foodName) {
        return foodHashMap.get(foodName.trim().toLowerCase());
    }
}
