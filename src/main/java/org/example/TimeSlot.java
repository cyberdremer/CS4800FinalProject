package org.example;

import java.time.DateTimeException;
import java.time.LocalTime;

public class TimeSlot {
    private final int lengthOfShiftInHours = 8;
    private LocalTime startTime;
    private LocalTime endTime;

    public TimeSlot(int startHourMilitaryTime){
        try{
            startTime = LocalTime.of(startHourMilitaryTime, 0);
            endTime = LocalTime.of(startHourMilitaryTime + lengthOfShiftInHours, 0);

        }
        catch (DateTimeException dateTimeException){
            throw dateTimeException;
        }
    }



    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }
}
