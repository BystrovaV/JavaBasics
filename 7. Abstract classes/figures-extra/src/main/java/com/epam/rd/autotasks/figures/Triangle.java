package com.epam.rd.autotasks.figures;

class Triangle extends Figure {
    private final Point a, b, c;

    public Triangle (Point a, Point b, Point c) {
        if (a == null || b == null || c == null)
            throw new IllegalArgumentException();

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

        final double error = Math.pow(10, -5);
        if (area() < error) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public Point centroid() {
        return new Point((a.getX() + b.getX() + c.getX())/3, (a.getY() + b.getY() + c.getY())/3);
    }

    @Override
    public boolean isTheSame(Figure figure) {
        if (figure == null)
            return false;

        if (!(figure instanceof Triangle))
            return false;

        Triangle triangle = (Triangle) figure;

        return (a.equals(triangle.a) && b.equals(triangle.b) &&
                c.equals(triangle.c)) ||
                (a.equals(triangle.b) && b.equals(triangle.c) &&
                        c.equals(triangle.a)) ||
                (a.equals(triangle.c) && b.equals(triangle.a) &&
                        c.equals(triangle.b));
    }

    private double getLengthSide(Point a, Point b) {
        return Math.sqrt(Math.pow(a.getX() - b.getX(), 2) + Math.pow(a.getY() - b.getY(), 2));
    }

    public double area() {
        double side1 = getLengthSide(a, b), side2 = getLengthSide(a, c), side3 = getLengthSide(b, c);
        double p =  (side1 + side2 + side3) / 2;

        return Math.sqrt(p * (p - side1) * (p - side2) * (p - side3));
    }
}
