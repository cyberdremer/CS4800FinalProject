package org.example.Entity.Factory;

import org.example.Entity.Driver;
import org.example.Entity.Customer;
import org.example.Entity.FoodItems.Food.Food;
import org.example.Entity.Restaurant;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import static java.lang.Math.round;

public class Order {
    private Restaurant restaurant;
    private Customer customer;
    private Driver driver;
    private LocalTime timeOfOrder, timeOfPickup, timeOfDelivery;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a", Locale.ENGLISH);

    private Food food;


    public Order(Restaurant restaurant, Customer customer, Driver driver, Food food, LocalTime timeOfOrder){
        this.restaurant = restaurant;
        this.customer = customer;
        this.driver = driver;
        this.timeOfOrder = timeOfOrder;
        this.food = food;
        generatePickUpAndDeliveryTime();
    }
    
    private void generatePickUpAndDeliveryTime(){
        timeOfPickup = timeOfOrder.plusMinutes(15);
        timeOfDelivery = timeOfPickup.plusMinutes(30);

    }

    private String moneyFormatter(double moneyAmt, int decimalPlaces){
        String result = String.format("%." + decimalPlaces + "f", moneyAmt);
        return result;
    }


    @Override
    public String toString() {
        return "Order{" +
                "Restaurant=" + restaurant.getName() + "\n" +
                "Customer=" + customer.getName() + "\n" +
                "Driver=" + driver.getName() + "\n" +
                "Food=" + food.getName() + "\n" +
                "Price= $" +   moneyFormatter(food.getPrice(), 2) + "\n" +
                "Order creation=" + timeOfOrder.format(formatter) + "\n" +
                "Order picked up=" + timeOfPickup.format(formatter)+ "\n" +
                "Order delivered=" + timeOfDelivery.format(formatter) + "\n" +
                "}\n";
    }
}
