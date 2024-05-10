package org.example;

public class Resturant {
    private String name;
    private Address address;
    private County county;

    public Resturant(String name, Address address, County county){
        this.name = name;
        this.address = address;
        this.county =county;
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

    public void printMenu(){

    }
}
