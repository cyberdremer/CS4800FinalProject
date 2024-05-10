package org.example;

import java.time.DateTimeException;
import java.time.LocalTime;

public class TimeSlot {
    private int lengthOfTimeSlot;
    private LocalTime startTime;
    private LocalTime endTime;

    public TimeSlot(int startHourMilitaryTime, int lengthOfTimeSlot){
        try{
            this.lengthOfTimeSlot = lengthOfTimeSlot;
            startTime = LocalTime.of(startHourMilitaryTime, 0);
            endTime = LocalTime.of(startHourMilitaryTime + this.lengthOfTimeSlot, 0);

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
