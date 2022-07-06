package com.example.domain;

import java.util.ArrayList;
import java.util.List;

public class Drivers {
    private List<Driver> drivers = new ArrayList<>();
    
    public void addDriver(Driver driver) {
    	drivers.add(driver);
    }
    
    public List<Driver> getDrivers() {
    	return this.drivers;
    }
}
