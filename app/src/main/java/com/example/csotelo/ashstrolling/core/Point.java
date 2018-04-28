package com.example.csotelo.ashstrolling.core;

public class Point {
    long x, y = 0;

    public Point() {
        x = 0;
        y = 0;
    }

    public Point(long x, long y) {
        this.x = x;
        this.y = y;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return new Point(x, y);
    }

    @Override
    public String toString() {
        return "" + x + "," + y;
    }
}
