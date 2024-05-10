package org.example.Entity.FoodItems;

public class Burrito implements Food {
    private double price;
    private final String name;
    private static final String CATEGORY = "Mexican";

    public Burrito(double price) {
        this.price = price;
        this.name = "Burrito";
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public String getCategory() {
        return CATEGORY;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
