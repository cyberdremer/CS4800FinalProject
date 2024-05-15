package org.example.Entity.Factory;

import org.example.Entity.FoodItems.Food.Food;
import org.example.Entity.FoodItems.Toppings.Cheese;
import org.example.Entity.FoodItems.Toppings.CrushedAlmond;
import org.example.Entity.FoodItems.Toppings.Guac;
import org.example.Entity.FoodItems.Toppings.Topping;
import org.example.ExceptionClasses.InvalidTopping;

public class ToppingFactory {
    private static ToppingFactory factory = null;
    private ToppingFactory(){}

    public static ToppingFactory getInstance() {
        if (factory == null){
            factory = new ToppingFactory();
        }
        return factory;
    }

    public Food getTopping(String topping, Food food){
        switch (topping.toLowerCase()){
            case "cheese" -> {
                return new Cheese(food, 5.99);
            }
            case "crushedalmond" ->{
                return new CrushedAlmond(food, 5.99);
            }
            case "guac" ->{
                return new Guac(food, 5.99);
            }
            default -> {
                throw new InvalidTopping(topping + " is not a valid topping!\n");
            }
        }

    }


}
