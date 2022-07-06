package com.epam.rd.autotasks.triangle;

class Triangle {

    private Point a;
    private Point b;
    private Point c;

    public Triangle(Point a, Point b, Point c) {
        if (getLengthSide(a, b) + getLengthSide(a, c) > getLengthSide(b, c) &&
                getLengthSide(a, c) + getLengthSide(b, c) > getLengthSide(a, b) &&
                getLengthSide(a, b) + getLengthSide(b, c) > getLengthSide(a, c)) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
        else {
            throw new IllegalArgumentException();
        }
    }

    private double getLengthSide(Point a, Point b) {
        return Math.sqrt(Math.pow(a.getX() - b.getX(), 2) + Math.pow(a.getY() - b.getY(), 2));
    }

    public double area() {
        double side1 = getLengthSide(a, b), side2 = getLengthSide(a, c), side3 = getLengthSide(b, c);
        double p =  (side1 + side2 + side3) / 2;

        return Math.sqrt(p * (p - side1) * (p - side2) * (p - side3));
    }

    public Point centroid(){
        return new Point((a.getX() + b.getX() + c.getX())/3, (a.getY() + b.getY() + c.getY())/3);
    }

}
