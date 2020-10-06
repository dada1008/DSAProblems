package com.opensource.dada.problems.pattern.mergeIntervals;

import java.util.Objects;

public class EmployeeInterval {
    public int employeeIndex, intervalIndex;
    public Interval interval;

    public EmployeeInterval() {
    }

    public EmployeeInterval(int employeeIndex, int intervalIndex, Interval interval) {
        this.employeeIndex = employeeIndex;
        this.intervalIndex = intervalIndex;
        this.interval = interval;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeInterval that = (EmployeeInterval) o;
        return employeeIndex == that.employeeIndex &&
                intervalIndex == that.intervalIndex &&
                interval.equals(that.interval);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeIndex, intervalIndex, interval);
    }

    @Override
    public String toString() {
        return "EmployeeInterval{" +
                "employeeIndex=" + employeeIndex +
                ", intervalIndex=" + intervalIndex +
                ", interval=" + interval +
                '}';
    }
}
