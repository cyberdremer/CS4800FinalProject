package org.example.Entity.Factory;

import org.example.Entity.FoodItems.Food.AbstractFood;
import org.example.Entity.FoodItems.Paleo.PaleoBurger;
import org.example.Entity.FoodItems.Paleo.PaleoBurrito;
import org.example.Entity.FoodItems.Paleo.PaleoPadThai;

import java.util.HashMap;

public class PaleoFactory extends AbstractFoodFactory{
    private static HashMap<String, AbstractFood> foodHashMap = new HashMap<>();
    private static PaleoFactory paleoFactory = null;

    private PaleoFactory(){}
    static {
        foodHashMap.put("burger", new PaleoBurger(5.99));
        foodHashMap.put("burrito", new PaleoBurrito(6.99));
        foodHashMap.put("padthai", new PaleoPadThai(4.99));
    }

    public static PaleoFactory getInstance(){
        if (paleoFactory == null){
            paleoFactory = new PaleoFactory();
        }
        return paleoFactory;
    }
    @Override
    AbstractFood getFood(String foodName) {
        return foodHashMap.get(foodName.trim().toLowerCase());
    }
}
