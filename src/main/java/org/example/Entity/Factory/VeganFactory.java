package org.example.Entity.Factory;

import org.example.Entity.FoodItems.Food.AbstractFood;
import org.example.Entity.FoodItems.Vegan.VeganBurger;
import org.example.Entity.FoodItems.Vegan.VeganBurrito;
import org.example.Entity.FoodItems.Vegan.VeganPadThai;

import java.util.HashMap;

public class VeganFactory extends AbstractFoodFactory {
    private static HashMap<String, AbstractFood> foodHashMap = new HashMap<>();
    private static VeganFactory veganFactory = null;
    private VeganFactory(){}
    static {
        foodHashMap.put("burger", new VeganBurger(5.99));
        foodHashMap.put("burrito", new VeganBurrito(6.99));
        foodHashMap.put("padthai", new VeganPadThai(4.99));
    }

    public static VeganFactory getInstance(){
        if (veganFactory == null){
            veganFactory = new VeganFactory();
        }
        return veganFactory;
    }


    @Override
    AbstractFood getFood(String foodName) {
        return foodHashMap.get(foodName.trim().toLowerCase());
    }
}
