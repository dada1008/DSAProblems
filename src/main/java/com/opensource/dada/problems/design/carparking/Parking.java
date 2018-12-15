package com.opensource.dada.problems.design.carparking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Parking {

    static int levels = 10;
    static List<List<Spot>> spots = new ArrayList<>();
    static Map<Vehicle, Spot> vehicleSpotMap = new HashMap<>();
    static {
        init();
    }
    public Parking(){

    }

    public static void main(String[] args) {

    }
    private static void init() {
        for (int i=0; i< levels; i++) {
            List<Spot> levelSpots = new ArrayList<>();
            for (int j=0; j< levels; j++) {
                Spot spot = new Spot(i,j,1);
                levelSpots.add(spot);
            }
            spots.add(levelSpots);
        }
    }

    public void parkVehicle(Vehicle vehicle) {
        Spot foundSpot = findSpot();
        foundSpot.setVehicle(vehicle);
        vehicle.setSpot(foundSpot);
        vehicleSpotMap.put(vehicle,foundSpot);
    }

    public Spot findSpot() {
        Spot foundSpot = null;
        for (int i=0; i< spots.size(); i++) {
            List<Spot> levelSpots = spots.get(i);
            for (int j=0; j< levelSpots.size(); j++) {
                Spot spot = levelSpots.get(j);
                if (spot.isAvailable()) {
                    foundSpot = spot;
                    break;
                }
            }

            if (foundSpot!=null) {
                break;
            }
        }
        if (foundSpot==null) {
            throw new RuntimeException("No spot available");
        }
        return foundSpot;
    }

    public void removeVehicle(Vehicle vehicle) {
        Spot foundSpot = vehicleSpotMap.remove(vehicle);
        foundSpot.setVehicle(null);
        vehicle.setSpot(null);
    }
    public void statistics() {
        System.out.println(spots);
    }
}
