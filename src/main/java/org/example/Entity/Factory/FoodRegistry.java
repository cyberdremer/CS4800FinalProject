package org.example.Entity.Factory;

import org.example.Entity.FoodItems.Food.AbstractFood;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FoodRegistry {
    private Map<String, AbstractFood> foods = new HashMap<>();

    public void registerFood(String key, AbstractFood food) {
        foods.put(key.toLowerCase(), food);
    }

    public AbstractFood getFood(String key) {
        return foods.get(key.toLowerCase());
    }

    public List<AbstractFood> getAllFoodItems() {
        return new ArrayList<>(foods.values());
    }
}
