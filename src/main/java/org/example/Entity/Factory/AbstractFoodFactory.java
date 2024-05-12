package org.example.Entity.Factory;

import org.example.Entity.FoodItems.Food.AbstractFood;

public abstract class AbstractFoodFactory {
    abstract AbstractFood getFood(String foodName);
}
