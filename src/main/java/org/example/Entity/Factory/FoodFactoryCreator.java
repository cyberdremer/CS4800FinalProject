package org.example.Entity.Factory;

import java.util.HashMap;

public class FoodFactoryCreator {
    private static FoodFactoryCreator foodFactoryCreator = null;
    private static HashMap<String, AbstractFoodFactory> factoryHashMap = new HashMap<>();
    static {
        factoryHashMap.put("paleo", PaleoFactory.getInstance());
        factoryHashMap.put("vegan", VeganFactory.getInstance());
        factoryHashMap.put("norestriction", NoRestrictionFactory.getInstance());
    }
    private FoodFactoryCreator(){}

    public static FoodFactoryCreator getInstance(){
        if (foodFactoryCreator == null){
            foodFactoryCreator = new FoodFactoryCreator();
        }
        return foodFactoryCreator;

    }

    public AbstractFoodFactory getFactory(String factoryType){
        return factoryHashMap.get(factoryType);

    }





}
