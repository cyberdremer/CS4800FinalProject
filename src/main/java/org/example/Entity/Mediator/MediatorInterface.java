package org.example.Entity.Mediator;

import org.example.Entity.Driver;
import org.example.Entity.Customer;
import org.example.Entity.Restaurant;

public interface MediatorInterface {

    public void registerResturant(Restaurant restaurant);
    public void registerDriver(Driver driver);

    public void registerCustomer(Customer customer);
}
