package com.epam.rd.autotasks.figures;

class Quadrilateral extends Figure{
    private final Point a, b, c, d;

    public Quadrilateral(Point a, Point b, Point c, Point d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    @Override
    public double area() {

        Triangle triangle1 = new Triangle(a, b, c);
        Triangle triangle2 = new Triangle(a, c, d);

        return triangle2.area() + triangle1.area();
    }

    @Override
    public String pointsToString() {
        return "(" + a.getX() + "," + a.getY() + ")("
                + b.getX() + "," + b.getY() + ")("
                + c.getX() + "," + c.getY() + ")("
                + d.getX() + "," + d.getY() + ")";
    }

    @Override
    public String toString() {
        return "Quadrilateral[" + pointsToString() + "]";
    }

    @Override
    public Point leftmostPoint() {
        Triangle triangle1 = new Triangle(a, b, c);
        Triangle triangle2 = new Triangle(a, b, d);

        Point min1 = triangle1.leftmostPoint();
        Point min2 = triangle2.leftmostPoint();

        if (min2.getX() < min1.getX())
            return min2;

        return min1;
    }
}
