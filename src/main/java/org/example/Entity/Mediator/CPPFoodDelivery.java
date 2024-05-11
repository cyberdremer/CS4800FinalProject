package org.example.Entity.Mediator;

import org.example.Driver;
import org.example.Entity.Customer;
import org.example.Entity.Resturant;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CPPFoodDelivery implements MediatorInterface{
    Map<String, Resturant> resturantMap;
    Map<Resturant, List<Driver>> resturantDriverMap;
    Map<String, Driver> driverMap;
    Map<String, Customer> customerMap;
    CPPFoodDelivery(){
        resturantMap = new HashMap<>();
        resturantDriverMap = new HashMap<>();
        driverMap = new HashMap<>();
        customerMap = new HashMap<>();
    }

    @Override
    public void registerResturant(Resturant resturant){
        if (resturantMap.containsKey(resturant.getName())){
            return;
        }
        resturantMap.put(resturant.getName(), resturant);

    }

    @Override
    public void registerDriver(Driver driver) {
        if (driverMap.containsKey(driver.getName())){
            return;
        }
        driverMap.put(driver.getName(), driver);


    }

    @Override
    public void registerCustomer(Customer customer){
        if(customerMap.containsKey(customer.getName())){
            return;
        }
        customerMap.put(customer.getName(), customer);

    }


    public void assignDriverToResturant(String driverName, String restaurantName){
        if (validDriverRestaurantPair(driverName, restaurantName)){
            Driver driver = driverMap.get(driverName);
            Resturant resturant = resturantMap.get(restaurantName);
            createResturantDriverRelationShip(resturant, driver);
        }
    }

    private boolean validDriverRestaurantPair(String driverName, String restaurantName){
        return driverMap.containsKey(driverName) && resturantMap.containsKey(restaurantName);

    }

    private void createResturantDriverRelationShip(Resturant resturant, Driver driver){
        if(!resturantDriverMap.containsKey(resturant)){
            resturantDriverMap.put(resturant, new ArrayList<>());
        }
        resturantDriverMap.get(resturant).add(driver);

    }







}
