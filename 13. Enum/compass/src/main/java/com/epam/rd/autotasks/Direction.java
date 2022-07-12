package com.epam.rd.autotasks;

import java.util.Optional;

public enum Direction {
    N(0), NE(45), E(90), SE(135), S(180), SW(225), W(270), NW(315);

    Direction(final int degrees) {
        this.degrees = degrees;
    }

    private int degrees;

    public static Direction ofDegrees(int degrees) {
        int temp = degrees % 360;
        if (temp < 0)
            temp += 360;

        for (Direction direction: Direction.values()) {
            if (temp == direction.degrees)
                return direction;
        }

        return null;
    }

    public static Direction closestToDegrees(int degrees) {
        int temp = degrees % 360;
        if (temp < 0)
            temp += 360;

        for (Direction direction: Direction.values()) {
            if (temp <= direction.degrees + 45 / 2 && temp >= direction.degrees - 45 /2 )
                return direction;
        }

        return null;
    }

    public Direction opposite() {
        return Direction.ofDegrees((degrees + 180) % 360);
    }

    public int differenceDegreesTo(Direction direction) {
        int diff = direction.degrees - degrees;
        if (diff < 0)
            diff = diff + 360;
        return Math.min(diff, 360 - diff);
    }
}
