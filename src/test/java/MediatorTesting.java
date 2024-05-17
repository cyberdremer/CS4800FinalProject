import org.example.Entity.*;
import org.example.Entity.FoodItems.NutFree.NutFreeBurger;
import org.example.Entity.FoodItems.Traditional.TraditionalBurger;
import org.example.Entity.Mediator.CPPFoodDelivery;
import org.example.Entity.Strategy.NoNutMeal;
import org.example.Entity.Strategy.NoRestrictionMeal;
import org.example.ExceptionClasses.CustomerNotFoundException;
import org.example.ExceptionClasses.DriverNotFoundException;
import org.example.ExceptionClasses.ResturantNotFoundException;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MediatorTesting {
    CPPFoodDelivery cppFoodDelivery = null;
    Address address1, address2 = null;
    Restaurant restaurant = null;
    Customer customer1, customer2 = null;

    Driver driver1 = null;

    @BeforeEach
    public void setUp(){
        cppFoodDelivery = CPPFoodDelivery.getInstance();
        Address address = new Address("Utopia Ave", "Culver City", "CA", "90230", "United States");
        driver1 = new Driver("Mike", address, County.LA );
        driver1.setShift(8, 0, 8);



        Address address2 = new Address("Sawtelle Blvd", "Culver City", "CA", "90230", "United States");
        restaurant = new Restaurant("Wonton Palace", address2);
        restaurant.setHoursOfOperation(7,0, 12 );


        customer1 = new Customer("David", address, County.LA);
        customer1.setMealPlanStrategy(new NoRestrictionMeal());
        customer2 = new Customer("John", address, County.SANBERNARDINO);



        restaurant.addFood("Burger", new TraditionalBurger(5.99));
        restaurant.addFood("NoNutBurger", new NutFreeBurger(14.68));

        cppFoodDelivery.registerResturant(restaurant);
        cppFoodDelivery.registerDriver(driver1);
        cppFoodDelivery.registerCustomer(customer1);
        cppFoodDelivery.registerCustomer(customer2);



        Customer customer = new Customer("Costin",address, County.LA);
        customer.setMealPlanStrategy(new NoNutMeal());
    }


    @AfterEach
    public void cleanUp(){
        cppFoodDelivery = null;
        address1 = null;
        address2 = null;
        restaurant = null;
        customer1 = null;
        customer2 = null;

    }

    @Test
    public void testSingleton(){
        CPPFoodDelivery instance1 = CPPFoodDelivery.getInstance();
        CPPFoodDelivery instance2 = CPPFoodDelivery.getInstance();
        assertSame(instance2, instance1);
    }


    @Test
    public void testDriverResturantPair(){
        assertDoesNotThrow(()-> cppFoodDelivery.assignDriverToResturant("Mike Ma", "InNout"));
    }


    @Test
    public void testOrderFromTwoDifferentCounty(){
        cppFoodDelivery.assignDriverToResturant("Mike", "Wonton Palace");
        restaurant = cppFoodDelivery.getResturant("Wonton Palace");
        assertThrows(DriverNotFoundException.class, ()-> cppFoodDelivery.getWorkingDeliveryDriver(restaurant, County.SANBERNARDINO, 9, 10));
    }


    @Test
    public void testOrderThatIsNotWithinDriverShift(){
        cppFoodDelivery.assignDriverToResturant("Mike", "Wonton Palace");
        restaurant = cppFoodDelivery.getResturant("Wonton Palace");
        assertThrows(DriverNotFoundException.class, ()-> cppFoodDelivery.getWorkingDeliveryDriver(restaurant, County.LA, 18, 0));

    }



    @Test
    public void testOrderFromWithinTheSameCounty(){
        cppFoodDelivery.assignDriverToResturant("Mike", "Wonton Palace");
        restaurant = cppFoodDelivery.getResturant("Wonton Palace");
        assertDoesNotThrow(() ->cppFoodDelivery.getWorkingDeliveryDriver(restaurant, County.LA, 9,0));
    }



    @Test
    public void testGetNonExistentResturant(){
        assertThrows(ResturantNotFoundException.class, ()-> cppFoodDelivery.getResturant("Jollibee"));
    }


    @Test
    public void testGetExistentResturant(){
        assertDoesNotThrow(()-> cppFoodDelivery.getResturant("Wonton Palace"));
    }


    @Test
    public void testGetNonExistentCustomer(){
        assertThrows(CustomerNotFoundException.class, ()-> cppFoodDelivery.getCustomer("Davy"));
    }



    @Test
    public void testGetExistentCustomer(){
        assertDoesNotThrow(()-> cppFoodDelivery.getCustomer("John"));
    }


    @Test
    public void testGetNonExistentDriver(){
        assertThrows(DriverNotFoundException.class, ()-> cppFoodDelivery.getDriver("Ian"));
    }


    @Test
    public void testGetExistingDriver(){
        assertDoesNotThrow(()-> cppFoodDelivery.getDriver("Mike"));
    }


    @Test
    public void testOrder(){
        cppFoodDelivery.assignDriverToResturant("Mike", "Wonton Palace");
       assertDoesNotThrow(()->  cppFoodDelivery.createOrder("David", "Wonton Palace", 12,0, "cheese", "crushedalmond"));

    }


}
