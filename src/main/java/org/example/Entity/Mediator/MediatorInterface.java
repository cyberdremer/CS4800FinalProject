package org.example.Entity.Mediator;

import org.example.Driver;
import org.example.Entity.Customer;
import org.example.Entity.Resturant;

public interface MediatorInterface {

    public void registerResturant(Resturant resturant);
    public void registerDriver(Driver driver);

    public void registerCustomer(Customer customer);
}
