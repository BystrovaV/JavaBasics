package com.epam.rd.autotasks.figures;

class Triangle extends Figure{

    private final Point a, b, c;

    public Triangle (Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double area() {
        double side1 = getLengthSide(a, b), side2 = getLengthSide(a, c), side3 = getLengthSide(b, c);
        double p =  (side1 + side2 + side3) / 2;

        return Math.sqrt(p * (p - side1) * (p - side2) * (p - side3));
    }

    @Override
    public String pointsToString() {
        return "(" + a.getX() + "," + a.getY() + ")("
                + b.getX() + "," + b.getY() + ")("
                + c.getX() + "," + c.getY() + ")";
    }

    @Override
    public Point leftmostPoint() {
        Point left;

        if (a.getX() < b.getX())
            left = a;
        else
            left = b;

        if (left.getX() < c.getX())
            return left;
        else
            return c;
    }

    @Override
    public String toString() {
        return "Triangle[" + pointsToString() + "]";
    }

    private double getLengthSide(Point a, Point b) {
        return Math.sqrt(Math.pow(a.getX() - b.getX(), 2) + Math.pow(a.getY() - b.getY(), 2));
    }

}
