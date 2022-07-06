package com.epam.rd.autotasks.figures;

class Circle extends Figure{
    private final Point center;
    private final double diameter;

    public Circle(Point center, double diameter) {
        this.center = center;
        this.diameter = diameter;
    }

    @Override
    public double area() {
        return Math.PI * diameter * diameter;
    }

    @Override
    public String pointsToString() {
        return "(" + center.getX() + "," + center.getY() + ")";
    }

    @Override
    public String toString() {
        return "Circle[" + pointsToString() + diameter + "]";
    }

    @Override
    public Point leftmostPoint() {
        return new Point(center.getX() - diameter, center.getY());
    }
}
