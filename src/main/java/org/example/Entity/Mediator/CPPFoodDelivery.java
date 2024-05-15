package org.example.Entity.Mediator;

import org.example.Entity.Driver;
import org.example.Entity.County;
import org.example.Entity.Customer;
import org.example.Entity.Factory.Order;
import org.example.Entity.FoodItems.Food.AbstractFood;
import org.example.Entity.FoodItems.Food.Food;
import org.example.Entity.FoodItems.Traditional.TraditionalBurger;
import org.example.Entity.Restaurant;
import org.example.ExceptionClasses.CustomerNotFoundException;
import org.example.ExceptionClasses.DriverNotFoundException;
import org.example.ExceptionClasses.InvalidTopping;
import org.example.ExceptionClasses.ResturantNotFoundException;

import java.time.LocalTime;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class CPPFoodDelivery implements MediatorInterface{
    private static CPPFoodDelivery cppFoodDelivery = null;

    Map<String, Restaurant> resturantMap;
    Map<Restaurant, List<Driver>> resturantDriverMap;
    Map<String, Driver> driverMap;
    Map<String, Customer> customerMap;

    private CPPFoodDelivery(){
        resturantMap = new HashMap<>();
        resturantDriverMap = new HashMap<>();
        driverMap = new HashMap<>();
        customerMap = new HashMap<>();
    }

    public static CPPFoodDelivery getInstance() {
        if (cppFoodDelivery == null){
            cppFoodDelivery = new CPPFoodDelivery();
        }
        return cppFoodDelivery;
    }

    @Override
    public void registerResturant(Restaurant restaurant){
        if (resturantMap.containsKey(restaurant.getName())){
            return;
        }
        resturantMap.put(restaurant.getName(), restaurant);

    }


    public Restaurant getResturant(String name){
        if (!resturantMap.containsKey(name)){
            throw new ResturantNotFoundException(name + "is not a registered restaurant!\n");
        }
        return resturantMap.get(name);
    }


    @Override
    public void registerDriver(Driver driver) {
        if (driverMap.containsKey(driver.getName())){
            return;
        }
        driverMap.put(driver.getName(), driver);

    }

    public Driver getDriver(String name){
        if (!driverMap.containsKey(name)){
            throw new DriverNotFoundException(name + " is not a registered driver!\n");
        }
        return driverMap.get(name);
    }



    @Override
    public void registerCustomer(Customer customer){
        if(customerMap.containsKey(customer.getName())){
            return;
        }
        customerMap.put(customer.getName(), customer);

    }

    public Customer getCustomer(String name){
        if (!customerMap.containsKey(name)){
            throw new CustomerNotFoundException(name + " is not a registered customer");
        }
        return customerMap.get(name);
    }





    public void assignDriverToResturant(String driverName, String restaurantName){
        try{
            if (validDriverRestaurantPair(driverName, restaurantName)){
                Driver driver = getDriver(driverName);
                Restaurant restaurant = getResturant(restaurantName);
                createResturantDriverRelationShip(restaurant, driver);
            }

        }
        catch (DriverNotFoundException e) {
            System.out.print(e);
        }
        catch (ResturantNotFoundException e){
            System.out.print(e);

        }
    }

    private boolean validDriverRestaurantPair(String driverName, String restaurantName){
        return driverMap.containsKey(driverName) && resturantMap.containsKey(restaurantName);

    }

    private void createResturantDriverRelationShip(Restaurant restaurant, Driver driver){
        if(!resturantDriverMap.containsKey(restaurant)){
            resturantDriverMap.put(restaurant, new ArrayList<>());
        }
        resturantDriverMap.get(restaurant).add(driver);

    }


    public void createOrder(String customerName, String restaurantName, int orderTimeHours, int orderTimeMinutes, String... toppings){
        try{
            Customer customer = getCustomer(customerName);
            Restaurant restaurant = getResturant(restaurantName);
            Driver driver = getWorkingDeliveryDriver(restaurant, customer.getCounty(), orderTimeHours, orderTimeMinutes);

            AbstractFood preToppingFood = customer.executeMealPlan(restaurant.getMenu());
            Food postToppingFood = restaurant.applyTopping(preToppingFood, toppings);
            Order order = new Order(restaurant, customer, driver, postToppingFood, LocalTime.of(orderTimeHours, orderTimeMinutes));
            System.out.print(order);

        }
        catch (CustomerNotFoundException e){
            System.out.print(e);
        }
        catch (ResturantNotFoundException e){
            System.out.print(e);

        }
        catch (DriverNotFoundException e){
            System.out.print(e);
        }

        catch (InvalidTopping e){
            System.out.print(e);
        }




    }


    public Driver getWorkingDeliveryDriver(Restaurant restaurant, County county, int orderTimeHours, int orderTimeMinutes){
        try {
            List<Driver> driversList = driverListFilter(restaurant, county, orderTimeHours, orderTimeMinutes);
            int randIndex = ThreadLocalRandom.current().nextInt(0, driversList.size());
            return driversList.get(randIndex);
        }
        catch (NullPointerException e){
            throw new ResturantNotFoundException("Resturant is not registered!");
        }
        catch (IllegalArgumentException e){
            throw new DriverNotFoundException("No driver found that can take this order from: " + restaurant.getName() + "\n");
        }
    }

    private List<Driver> driverListFilter(Restaurant restaurant, County county, int orderTimeHours, int orderTimeMinutes){
        try{
            List<Driver> driverList = resturantDriverMap.get(restaurant).stream().filter(driver -> driver.validDeliveryCounty(county))
                    .filter(driver -> driver.validWorkingTime(orderTimeHours, orderTimeMinutes))
                    .collect(Collectors.toList());
            return driverList;
        }
        catch (NullPointerException e){
            throw e;
        }
    }







}
