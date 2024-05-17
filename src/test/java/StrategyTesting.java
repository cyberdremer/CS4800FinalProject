import org.example.Entity.Address;
import org.example.Entity.County;
import org.example.Entity.Customer;
import org.example.Entity.Factory.Menu;
import org.example.Entity.FoodItems.Food.AbstractFood;
import org.example.Entity.FoodItems.Food.Burger;
import org.example.Entity.FoodItems.NutFree.NutFreeBurger;
import org.example.Entity.FoodItems.Paleo.PaleoBurger;
import org.example.Entity.FoodItems.Traditional.TraditionalBurger;
import org.example.Entity.FoodItems.Vegan.VeganBurger;
import org.example.Entity.Restaurant;
import org.example.Entity.Strategy.NoNutMeal;
import org.example.Entity.Strategy.NoRestrictionMeal;
import org.example.Entity.Strategy.PaleoMeal;
import org.example.Entity.Strategy.VeganMeal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StrategyTesting {
    Restaurant restaurant = null;
    Customer customer = null;
    Address address = null;



    @BeforeEach
    public void setUp(){
        address = new Address("Holt Ave", "Pomona", "CA", "91111", "United States");
        customer = new Customer("John", address, County.SANBERNARDINO);
        restaurant = new Restaurant("InNOut", address);


        restaurant.addFood("tradburger", new TraditionalBurger(5.99));
        restaurant.addFood("nonutburger", new NutFreeBurger(6.99));
        restaurant.addFood("paleoburger", new PaleoBurger(5.88));
        restaurant.addFood("veganburger", new VeganBurger(10.88));





    }

    @Test
    public void testNoNutPlan(){
        customer.setMealPlanStrategy(new NoNutMeal());
        AbstractFood actualFood = customer.executeMealPlan(restaurant.getMenu());
        assertFalse(actualFood.containsNuts());

    }


    @Test
    public void testPaleo(){
        customer.setMealPlanStrategy(new PaleoMeal());
        AbstractFood actualFood = customer.executeMealPlan(restaurant.getMenu());
        AbstractFood expectedFood = new PaleoBurger(0.00);
        assertEquals(expectedFood.getClass(), actualFood.getClass());
    }



    @Test
    public void testVegan(){
        customer.setMealPlanStrategy(new VeganMeal());
        AbstractFood actualFood = customer.executeMealPlan(restaurant.getMenu());
        AbstractFood expectedFood = new VeganBurger(0.00);
        assertEquals(expectedFood.getClass(), actualFood.getClass());
    }


    @Test
    /**
     * I am not sure on how to test this one.
     */
    public void testNoRestriction(){
        customer.setMealPlanStrategy(new NoRestrictionMeal());
        AbstractFood actualFood = customer.executeMealPlan(restaurant.getMenu());
        assertEquals(Burger.class, actualFood.getClass());
    }

}
