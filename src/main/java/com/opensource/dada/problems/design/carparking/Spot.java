package com.opensource.dada.problems.design.carparking;

public class Spot {
    Vehicle vehicle;
    int row;
    int column;
    int size;

    public Spot(int row, int column, int size) {
        this.row = row;
        this.column = column;
        this.size = size;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public int getSize() {
        return size;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public boolean isAvailable() {
        return this.vehicle==null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Spot spot = (Spot) o;

        if (row != spot.row) return false;
        if (column != spot.column) return false;
        return size == spot.size;
    }

    @Override
    public int hashCode() {
        int result = row;
        result = 31 * result + column;
        result = 31 * result + size;
        return result;
    }

    @Override
    public String toString() {
        return "Spot{" +
                "row=" + row +
                ", column=" + column +
                ", size=" + size +
                ", vehicle=" + vehicle +
                '}';
    }
}
