package org.example.Entity.Factory;

import org.example.Entity.Driver;
import org.example.Entity.Customer;
import org.example.Entity.FoodItems.Food.AbstractFood;
import org.example.Entity.FoodItems.Food.Food;
import org.example.Entity.Restaurant;

import java.time.LocalTime;

public class Order {
    private Restaurant restaurant;
    private Customer customer;
    private Driver driver;
    private LocalTime localTime;

    private Food food;


    public Order(Restaurant restaurant, Customer customer, Driver driver, Food food, LocalTime timeOfOrder){
        this.restaurant = restaurant;
        this.customer = customer;
        this.driver = driver;
        this.localTime = timeOfOrder;
        this.food = food;
    }


    @Override
    public String toString() {
        return "Order{" +
                "restaurant=" + restaurant.getName() +
                ", customer=" + customer.getName() +
                ", driver=" + driver.getName() +
                ", food=" + food.getName() +
                ", localTime=" + localTime +
                '}';
    }
}
