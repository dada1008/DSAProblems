package com.opensource.dada.problems.pattern.mergeIntervals;

import java.util.Objects;

public class Job {
    public int start, end, cpuLoad;

    public Job() {
    }

    public Job(int start, int end, int cpuLoad) {
        this.start = start;
        this.end = end;
        this.cpuLoad = cpuLoad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return start == job.start &&
                end == job.end &&
                cpuLoad == job.cpuLoad;
    }

    @Override
    public int hashCode() {
        return Objects.hash(start, end, cpuLoad);
    }

    @Override
    public String toString() {
        return "Job{" +
                "start=" + start +
                ", end=" + end +
                ", cpuLoad=" + cpuLoad +
                '}';
    }
}
