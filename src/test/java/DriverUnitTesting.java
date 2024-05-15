import org.example.Entity.Address;
import org.example.Entity.County;
import org.example.Entity.Driver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DriverUnitTesting {
    Driver driver = null;

    @BeforeEach
    public void driverSetup(){
        Address address = new Address("Utopia Ave", "Culver City", "CA", "90230", "US");
        driver = new Driver("Costin", address, County.LA);

    }

    @Test
    public void testForTimeOutOfShift(){
       driver.setShift(9, 0, 8);
       assertFalse(driver.validWorkingTime(7,0));
    }



    @Test
    public void testForTimeWithinShift(){
        driver.setShift(9, 0, 8);
        assertTrue(driver.validWorkingTime(15, 0));
    }

    @Test
    public void testForValidDeliveryCounty(){
        assertTrue(driver.validDeliveryCounty(County.LA));
    }

    @Test
    public void testForInvalidDeliveryCounty(){
        assertFalse(driver.validDeliveryCounty(County.ORANGE));
    }
}
