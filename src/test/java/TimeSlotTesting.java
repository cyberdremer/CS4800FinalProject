import org.example.Entity.TimeSlot;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.DateTimeException;

import static org.junit.jupiter.api.Assertions.*;


public class TimeSlotTesting {
    TimeSlot timeSlot = null;

    @BeforeEach
    public void setUp(){
        timeSlot = new TimeSlot(8, 0, 8);
    }

    @Test
    public void testWithinTimeSlot(){
        assertTrue(timeSlot.checkIfWithinTimeSlot(10, 0));
    }

    @Test
    public void testTimeThatIsNotWithinTimeSlot(){
        assertFalse(timeSlot.checkIfWithinTimeSlot(5,0));
    }

    @Test
    public void testInvalidTime(){
        Exception exception =  assertThrows(DateTimeException.class,()-> new TimeSlot(23,59,1));
    }



}
