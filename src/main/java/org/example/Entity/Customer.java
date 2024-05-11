package org.example.Entity;

import org.example.Entity.Strategy.MealPlanStrategy;

public class Customer {
    private String name;
    private Address address;
    private County county;

    private MealPlanStrategy mealPlanStrategy;

    public Customer(String name, Address address, County county){
        this.name = name;
        this.address = address;
        this.county = county;
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

    public void setMealPlanStrategy(MealPlanStrategy plan){
        mealPlanStrategy = plan;
    }

    public MealPlanStrategy getMealPlanStrategy(){
        return mealPlanStrategy;
    }
}
