package org.example;

import org.example.Entity.*;

import java.time.LocalTime;

public class Driver {
    private String name;

    private Address address;

    private County county;

    private TimeSlot shift;

    public Driver(String name, Address address, County county){
        this.name = name;
        this.address = address;
        this.county = county;
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    public County getCounty() {
        return county;
    }

    public void setShift(int startHoursInMilitaryTime, int shiftLengthInHours){
        shift = new TimeSlot(startHoursInMilitaryTime, shiftLengthInHours);
    }

    public boolean validWorkingTime(int hourInMilitaryTime, int minutesInMilitaryTime){
        return shift.checkIfWithinTimeSlot(hourInMilitaryTime, minutesInMilitaryTime);

    }


}
