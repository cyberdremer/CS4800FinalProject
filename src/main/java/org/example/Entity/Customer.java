package org.example.Entity;

import org.example.Entity.FoodItems.Food.AbstractFood;
import org.example.Entity.FoodItems.Food.Food;
import org.example.Entity.Strategy.MealPlanStrategy;
import org.example.ExceptionClasses.InvalidMealPlan;

import java.util.List;

public class Customer {
    private String name;
    private Address address;
    private County county;

    private MealPlanStrategy mealPlanStrategy;

    public Customer(String name, Address address, County county){
        this.name = name;
        this.address = address;
        this.county = county;
        this.mealPlanStrategy = null;
    }


    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    public County getCounty() {
        return county;
    }


    public void setMealPlanStrategy(MealPlanStrategy mealPlan){
        this.mealPlanStrategy = mealPlan;
    }

    public AbstractFood executeMealPlan(List<AbstractFood> foods){
        try{
            return mealPlanStrategy.customizeMeal(foods);
        }
        catch (NullPointerException e){
            throw new InvalidMealPlan("No meal plan has been provided by the customer!");
        }
    }


}
