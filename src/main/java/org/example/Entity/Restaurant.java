package org.example.Entity;

import org.example.Entity.Factory.Menu;
import org.example.Entity.Factory.ToppingFactory;
import org.example.Entity.FoodItems.Food.AbstractFood;
import org.example.Entity.FoodItems.Food.Food;

import java.util.List;

public class Restaurant {
    private String name;
    private Address address;
    private Menu menu;
    private ToppingFactory toppingFactory = ToppingFactory.getInstance();
    private TimeSlot hoursOfOperation = null;




    public Restaurant(String name, Address address) {
        this.name = name;
        this.address = address;
        this.menu = new Menu();
        printMenu();
    }


    public void setHoursOfOperation(int openingHourMilitaryTime, int openingMinuteMilitaryTime, int numberOfHoursOpen){
        hoursOfOperation = new TimeSlot(openingHourMilitaryTime, openingMinuteMilitaryTime, numberOfHoursOpen);
    }

    public boolean checkIfOpen(int hourMilitaryTime, int minutesMilitaryTime){
        return hoursOfOperation.checkIfWithinTimeSlot(hourMilitaryTime, minutesMilitaryTime);
    }
    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    public void printMenu() {
        try {
            AbstractFood burger = menu.getFood("burger");
            AbstractFood burrito = menu.getFood("burrito");
            AbstractFood padthai = menu.getFood("padthai");

            if (burger != null) System.out.println("Burger: $" + burger.getPrice());
            if (burrito != null) System.out.println("Burrito: $" + burrito.getPrice());
            if (padthai != null) System.out.println("Pad Thai: $" + padthai.getPrice());

        }
        catch (NullPointerException e){
            System.out.print("Menu is under construction!");
        }

    }


    public void addFood(String foodname, AbstractFood food){
        menu.registerFood(foodname, food);

    }

    public Food applyTopping(Food food,String... toppings){
        Food foodItem = food;
        for (String topping: toppings){
            foodItem = toppingFactory.getTopping(topping, foodItem);

        }
        return foodItem;
    }



    public List<AbstractFood> getMenu() {
        return menu.getAllFoodItems();
    }


    @Override
    public String toString() {
        return "Restaurant{" +
                "name='" + name + '\'' +
                ", address=" + address +
                ", hoursOfOperation=" + hoursOfOperation +
                '}';
    }
}
