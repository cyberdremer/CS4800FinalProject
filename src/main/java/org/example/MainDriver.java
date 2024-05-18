package org.example;

import org.example.Entity.*;
import org.example.Entity.FoodItems.NutFree.NutFreeBurger;
import org.example.Entity.FoodItems.NutFree.NutFreeBurrito;
import org.example.Entity.FoodItems.NutFree.NutFreePadThai;
import org.example.Entity.FoodItems.Paleo.PaleoBurger;
import org.example.Entity.FoodItems.Paleo.PaleoBurrito;
import org.example.Entity.FoodItems.Paleo.PaleoPadThai;
import org.example.Entity.FoodItems.Traditional.TraditionalBurger;
import org.example.Entity.FoodItems.Traditional.TraditionalBurrito;
import org.example.Entity.FoodItems.Traditional.TraditionalPadThai;
import org.example.Entity.FoodItems.Vegan.VeganBurger;
import org.example.Entity.FoodItems.Vegan.VeganBurrito;
import org.example.Entity.FoodItems.Vegan.VeganPadThai;
import org.example.Entity.Mediator.CPPFoodDelivery;
import org.example.Entity.Strategy.NoNutMeal;
import org.example.Entity.Strategy.NoRestrictionMeal;
import org.example.Entity.Strategy.PaleoMeal;
import org.example.Entity.Strategy.VeganMeal;

public class MainDriver {

    public static void main(String[] args) {

        Address address1 = new Address("Utopia Ave", "Culver City", "CA", "90230", "United States");
        Address address2 = new Address("MadeUp Blvd", "Anaheim", "CA", "92801", "United States");
        Address address3 = new Address("Foothill Blvd", "Glendora", "CA", "91740", "United States");
        Address address4 = new Address("Sawtelle Blvd", "Culver City", "CA", "90230", "United States");
        Address address5 = new Address("Kellogg Dr", "Pomona", "CA", "91768", "United States");
        Address address6 = new Address("Grove Ave", "Upland", "CA", "91786", "United States");
        Address address7 = new Address("Waterman Ave", "San Bernardino", "CA", "92401", "United States");
        Address address8 = new Address("Ocean Ave", "Santa Monica", "CA", "90401", "United States");
        Address address9 = new Address("4th St", "Whittier", "CA", "90601", "United States");
        Address address10 = new Address("8th Ave", "Downey", "CA", "90240", "United States");
        Address address11 = new Address("Euclid Ave", "Ontario", "CA", "91761", "United States");
        Address address12 = new Address("Rodeo Dr", "Beverly Hills", "CA", "90210", "United States");
        Address address13 = new Address("Hollywood Blvd", "Los Angeles", "CA", "90028", "United States");

        Address address14 = new Address("Universal Plaza", "Universal City", "CA", "91608", "United States");
        Address address15 = new Address("Santa Monica Pier", "Santa Monica", "CA", "90401", "United States");
        Address address16 = new Address("Disneyland Dr", "Anaheim", "CA", "92802", "United States");
        Address address17 = new Address("Riverside Dr", "Riverside", "CA", "92501", "United States");



        Driver driver1 = new Driver("Mike",address1, County.LA);
        driver1.setShift(8, 0, 8);

        Driver driver2 = new Driver("John",address2, County.LA);
        driver1.setShift(10, 0, 8);

        Driver driver3 = new Driver("Ann",address3, County.LA);
        driver1.setShift(14, 0, 8);

        Driver driver4 = new Driver("Frank",address4, County.LA);
        driver1.setShift(14, 0, 9);

        Driver driver5 = new Driver("Lucy",address5, County.LA);
        driver1.setShift(8, 0, 4);

        Driver driver6 = new Driver("Albert",address6, County.SANBERNARDINO);
        driver1.setShift(8, 0, 8);

        Driver driver7 = new Driver("Jesse",address7, County.SANBERNARDINO);
        driver1.setShift(8, 0, 8);

        Driver driver8 = new Driver("Adam",address8, County.LA);
        driver1.setShift(8, 0, 8);




        Customer customer1 = new Customer("David", address11, County.SANBERNARDINO);
        customer1.setMealPlanStrategy(new NoRestrictionMeal());

        Customer customer2 = new Customer("John", address12, County.LA);
        customer1.setMealPlanStrategy(new NoNutMeal());

        Customer customer3 = new Customer("Jared", address13, County.LA);
        customer1.setMealPlanStrategy(new PaleoMeal());

        Customer customer4 = new Customer("Laura", address4, County.LA);
        customer1.setMealPlanStrategy(new VeganMeal());

        Customer customer5 = new Customer("Jordan", address5, County.LA);
        customer1.setMealPlanStrategy(new VeganMeal());

        Customer customer6 = new Customer("Edwin", address6, County.SANBERNARDINO);
        customer1.setMealPlanStrategy(new PaleoMeal());

        Customer customer7 = new Customer("Jimena", address7, County.SANBERNARDINO);
        customer1.setMealPlanStrategy(new NoNutMeal());

        Customer customer8 = new Customer("Raymond", address8, County.LA);
        customer1.setMealPlanStrategy(new NoRestrictionMeal());

        Customer customer9 = new Customer("Pedro", address9, County.LA);
        customer1.setMealPlanStrategy(new NoRestrictionMeal());

        Customer customer10 = new Customer("Jazmin", address10, County.LA);
        customer1.setMealPlanStrategy(new NoRestrictionMeal());




        Restaurant restaurant1 = new Restaurant("Wonton Palace", address14);
        restaurant1.setHoursOfOperation(7,0, 12 );

        Restaurant restaurant2 = new Restaurant("Burger King", address15);
        restaurant2.setHoursOfOperation(8,0, 15 );

        Restaurant restaurant3 = new Restaurant("Chipotle", address16);
        restaurant3.setHoursOfOperation(7,0, 13 );

        Restaurant restaurant4 = new Restaurant("White Castle", address17);
        restaurant4.setHoursOfOperation(7,0, 14 );




        restaurant1.addFood("NutFreePadThai", new NutFreePadThai(12.49));
        restaurant1.addFood("PaleoPadThai", new PaleoPadThai(13.49));
        restaurant1.addFood("TraditionalPadThai", new TraditionalPadThai(11.49));
        restaurant1.addFood("VeganPadThai", new VeganPadThai(14.49));


        restaurant2.addFood("Burger", new TraditionalBurger(5.99));
        restaurant2.addFood("NoNutBurger", new NutFreeBurger(14.68));
        restaurant2.addFood("PaleoBurger", new PaleoBurger(9.99));
        restaurant2.addFood("VeganBurger", new VeganBurger(12.99));


        restaurant3.addFood("NutFreeBurrito", new NutFreeBurrito(16.10));
        restaurant3.addFood("PaleoBurrito", new PaleoBurrito(18.10));
        restaurant3.addFood("TraditionalBurrito", new TraditionalBurrito(15.10));
        restaurant3.addFood("VeganBurrito", new VeganBurrito(20.10));

        restaurant4.addFood("TraditionalBurger", new TraditionalBurger(2.99));
        restaurant4.addFood("NoNutBurger", new NutFreeBurger(3.99));



        CPPFoodDelivery cppFoodDelivery = CPPFoodDelivery.getInstance();
        cppFoodDelivery.registerResturant(restaurant1);
        cppFoodDelivery.registerResturant(restaurant2);
        cppFoodDelivery.registerResturant(restaurant3);
        cppFoodDelivery.registerResturant(restaurant4);

        cppFoodDelivery.registerCustomer(customer1);
        cppFoodDelivery.registerCustomer(customer2);
        cppFoodDelivery.registerCustomer(customer3);
        cppFoodDelivery.registerCustomer(customer4);
        cppFoodDelivery.registerCustomer(customer5);
        cppFoodDelivery.registerCustomer(customer6);
        cppFoodDelivery.registerCustomer(customer7);
        cppFoodDelivery.registerCustomer(customer8);
        cppFoodDelivery.registerCustomer(customer9);
        cppFoodDelivery.registerCustomer(customer10);

        cppFoodDelivery.registerDriver(driver1);
        cppFoodDelivery.registerDriver(driver2);
        cppFoodDelivery.registerDriver(driver3);
        cppFoodDelivery.registerDriver(driver4);
        cppFoodDelivery.registerDriver(driver5);
        cppFoodDelivery.registerDriver(driver6);
        cppFoodDelivery.registerDriver(driver7);
        cppFoodDelivery.registerDriver(driver8);



        cppFoodDelivery.assignDriverToResturant("Mike","Wonton Palace");
        cppFoodDelivery.assignDriverToResturant("John","Wonton Palace");
        cppFoodDelivery.assignDriverToResturant("Ann","Burger King");
        cppFoodDelivery.assignDriverToResturant("Frank","Chipotle");
        cppFoodDelivery.assignDriverToResturant("Lucy","Burger King");
        cppFoodDelivery.assignDriverToResturant("Albert","White Castle");
        cppFoodDelivery.assignDriverToResturant("Jesse","White Castle");
        cppFoodDelivery.assignDriverToResturant("Adam","Chipotle");



        //David is in san bernardino, but all drivers are in LA
        cppFoodDelivery.createOrder("David", "Wonton Palace",
                        12,0, "cheese", "crushedalmond");

        





    }
}
