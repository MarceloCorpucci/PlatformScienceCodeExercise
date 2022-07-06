package com.example.domain;

import java.util.ArrayList;
import java.util.List;

public class Destinations {
    private List<Destination> destinations = new ArrayList<>();
    
    public void addDestination(Destination destination) {
    	destinations.add(destination);
    }
    
    public void removeDestination(Destination destination) {
    	destinations.remove(destination);
    }
    
    public List<Destination> getDestinations() {
    	return this.destinations;
    }
}
