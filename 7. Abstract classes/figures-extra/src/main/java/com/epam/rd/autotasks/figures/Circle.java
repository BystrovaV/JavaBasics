package com.epam.rd.autotasks.figures;

class Circle extends Figure{
    private final Point center;
    private final double radius;

    public Circle(Point center, double radius) {
        if (radius <= 0 || center == null)
            throw new IllegalArgumentException();

        this.center = center;
        this.radius = radius;
    }

    @Override
    public Point centroid() {
        return center;
    }

    @Override
    public boolean isTheSame(Figure figure) {
        if (figure == null)
            return false;

        if (!(figure instanceof Circle))
            return false;

        Circle circle = (Circle) figure;

        final double error = Math.pow(10, -5);
        return Math.abs(radius - circle.radius) < error && center.equals(circle.center);
    }
}
