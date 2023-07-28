package com.example.eatyet.core.utils;

public class TimeRange {
    private Long start;
    private Long end;

    public TimeRange() {

    }

    public TimeRange(Long start, Long end) {
        this.start = start;
        this.end = end;
    }

    public Long getStart() {
        return start;
    }

    public void setStart(Long start) {
        this.start = start;
    }

    public Long getEnd() {
        return end;
    }

    public void setEnd(Long end) {
        this.end = end;
    }
}
