package org.example.Entity;

import org.example.Entity.Factory.FoodRegistry;
import org.example.Entity.Factory.NoRestrictionFactory;
import org.example.Entity.FoodItems.Food.AbstractFood;

public class Resturant {
    private String name;
    private String address;
    private FoodRegistry menu;

    public Resturant(String name) {
        this.name = name;
        this.menu = new FoodRegistry();
        NoRestrictionFactory factory = NoRestrictionFactory.getInstance(this.menu);
        printMenu();
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public void printMenu() {
        AbstractFood burger = menu.getFood("burger");
        AbstractFood burrito = menu.getFood("burrito");
        AbstractFood padthai = menu.getFood("padthai");

        if (burger != null) System.out.println("Burger: $" + burger.getPrice());
        if (burrito != null) System.out.println("Burrito: $" + burrito.getPrice());
        if (padthai != null) System.out.println("Pad Thai: $" + padthai.getPrice());
    }
}
