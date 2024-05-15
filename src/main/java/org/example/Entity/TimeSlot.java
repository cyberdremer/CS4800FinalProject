package org.example.Entity;

import java.time.DateTimeException;
import java.time.LocalTime;

public class TimeSlot {
    private int lengthOfTimeSlot;
    private LocalTime startTime;
    private LocalTime endTime;

    public TimeSlot(int startHourMilitaryTime, int startMinuteMilitaryTime, int lengthOfTimeSlot){
        try{
            this.lengthOfTimeSlot = lengthOfTimeSlot;
            startTime = LocalTime.of(startHourMilitaryTime, startMinuteMilitaryTime);
            endTime = LocalTime.of(startHourMilitaryTime + this.lengthOfTimeSlot, 0);

        }
        catch (DateTimeException dateTimeException){
            throw dateTimeException;
        }
    }



    public boolean checkIfWithinTimeSlot(int startHourInMilitaryTime, int start){
        LocalTime target = LocalTime.of(startHourInMilitaryTime, start);
        return target.isAfter(startTime) && target.isBefore(endTime);

    }

}
