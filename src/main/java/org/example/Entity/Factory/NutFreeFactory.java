package org.example.Entity.Factory;

import org.example.Entity.FoodItems.Food.AbstractFood;
import org.example.Entity.FoodItems.NutFree.NutFreeBurger;
import org.example.Entity.FoodItems.NutFree.NutFreeBurrito;
import org.example.Entity.FoodItems.NutFree.NutFreePadThai;

import java.util.HashMap;

public class NutFreeFactory {
    private static NutFreeFactory nutFreeFactory = null;
    private static HashMap<String, AbstractFood> foodHashMap = new HashMap<>();
    private NutFreeFactory(){}

    static {
        foodHashMap.put("padthai", new NutFreePadThai(4.88));
        foodHashMap.put("burger", new NutFreeBurger(6.55));
        foodHashMap.put("burrito", new NutFreeBurrito(14.84));
    }

    public static NutFreeFactory getInstance(){
        if (foodHashMap == null){
            nutFreeFactory = new NutFreeFactory();
        }
        return nutFreeFactory;
    }

}
