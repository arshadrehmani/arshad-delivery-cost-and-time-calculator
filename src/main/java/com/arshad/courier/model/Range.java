package com.arshad.courier.model;

/**
 * This is basically a class that can hold any starting(min) and ending(max) range.
 * It can also validate if the passed in value is within the range.
 * 
 * @author Arshad
 */
public class Range {
    private final int min;
    private final int max;

    public Range(int min, int max) {
        this.min = min;
        this.max = max;
    }

    /**
     * Checks if a value lies within the given range.
     * @param value the number to check
     * @return true if value is between min and max (inclusive)
     */
    public boolean isWithinRange(int value) {
        return value >= min && value <= max;
    }
}

