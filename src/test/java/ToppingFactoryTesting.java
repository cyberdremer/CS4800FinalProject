import org.example.Entity.Factory.ToppingFactory;
import org.example.Entity.FoodItems.Food.AbstractFood;
import org.example.Entity.FoodItems.Food.Food;
import org.example.ExceptionClasses.InvalidTopping;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class ToppingFactoryTesting {
    ToppingFactory toppingFactory = null;
    Food testFood = null;
    Double delta = null;
    @BeforeEach
    public void setUp(){
        toppingFactory = ToppingFactory.getInstance();
        testFood = new AbstractFood("Durr Burger", 7.88, "American");
        delta = 0.00001;
    }

    @Test
    public void testSingleton(){
        ToppingFactory instance1 = ToppingFactory.getInstance();
        ToppingFactory instance2 = ToppingFactory.getInstance();
        assertSame(instance2, instance1);
    }

    @Test
    public void testGuacTopping(){
        testFood = toppingFactory.getTopping("Guac", testFood);
        Double expectedPrice = 13.87;
        assertEquals(testFood.getPrice(), expectedPrice,delta);
    }

    @Test
    public void testCheeseTopping(){
        testFood = toppingFactory.getTopping("Cheese", testFood);
        Double expectedPrice = 13.87;
        assertEquals(testFood.getPrice(), expectedPrice, delta);
    }


    @Test
    public void testAlmondTopping(){
        testFood = toppingFactory.getTopping("CrushedAlmond", testFood);
        Double expectedPrice = 13.87;
        assertEquals(testFood.getPrice(), expectedPrice, delta);

    }


    @Test
    public void testInvalidTopping(){
        assertThrows(InvalidTopping.class, ()-> toppingFactory.getTopping("Seaweed", testFood));
    }
}
