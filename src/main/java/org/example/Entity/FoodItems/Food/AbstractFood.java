package org.example.Entity.FoodItems.Food;

public class AbstractFood implements Food{
    protected String name;
    protected double price;
    protected String category;

    public AbstractFood(String name, double price, String category){
        this.name = name;
        this.price = price;
        this.category = category;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public String getCategory() {
        return this.category;
    }

    @Override
    public boolean isVegan() {
        return false;
    }

    @Override
    public boolean containsNuts() {
        return false;
    }

    @Override
    public boolean isPaleo() {
        return false;
    }
}
