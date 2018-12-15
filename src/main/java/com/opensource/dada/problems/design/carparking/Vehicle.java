package com.opensource.dada.problems.design.carparking;

public abstract class Vehicle {
    int uniqueNumber;
    int size;
    Spot spot;

    public Vehicle(int uniqueNumber, int size) {
        this.uniqueNumber = uniqueNumber;
        this.size = size;
    }

    public int getUniqueNumber() {
        return uniqueNumber;
    }

    public int getSize() {
        return size;
    }

    public Spot getSpot() {
        return spot;
    }

    public void setSpot(Spot spot) {
        this.spot = spot;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vehicle vehicle = (Vehicle) o;

        return uniqueNumber == vehicle.uniqueNumber;
    }

    @Override
    public int hashCode() {
        return uniqueNumber;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "uniqueNumber=" + uniqueNumber +
                ", size=" + size +
                '}';
    }
}