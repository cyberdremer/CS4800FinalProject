import org.example.Entity.Factory.Menu;
import org.example.Entity.FoodItems.Food.AbstractFood;
import org.example.Entity.FoodItems.NutFree.NutFreeBurger;
import org.example.Entity.FoodItems.Paleo.PaleoBurger;
import org.example.Entity.FoodItems.Traditional.TraditionalBurger;
import org.example.Entity.FoodItems.Vegan.VeganBurger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MenuTesting {
    Menu menu = null;
    @BeforeEach
    public void setUp(){
        menu = new Menu();
        menu.registerFood("tradburger", new TraditionalBurger(5.99));
        menu.registerFood("nonutburger", new NutFreeBurger(6.99));
        menu.registerFood("paleoburger", new PaleoBurger(5.88));
        menu.registerFood("veganburger", new VeganBurger(10.88));
    }


    @Test
    public void testGetFoodClass(){
        assertEquals(PaleoBurger.class, menu.getFood("paleoburger").getClass());
    }

    @Test
    public void testGetEntireMenuSize(){
        List<AbstractFood> actual = menu.getAllFoodItems();
        assertEquals(4, actual.size());

    }

    @Test
    public void testGetMenuItems(){
        TraditionalBurger testBurger = new TraditionalBurger(0.00);
        menu.registerFood("testburger", testBurger);
        List<AbstractFood> actual = menu.getAllFoodItems();
        assertTrue(actual.contains(testBurger));
    }


    @Test
    public void testGetFoodNotFound(){
        assertNull(menu.getFood("LeBigMac"));
    }

    @Test
    public void testCaseSensitivity(){
        menu.registerFood("TEstBurGer", new TraditionalBurger(0.00));
        assertNotNull(menu.getFood("TeStBURger"));
    }
}
