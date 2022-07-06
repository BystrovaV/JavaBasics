package com.epam.rd.autotasks.figures;

class Point {
    private double x;
    private double y;

    public Point(final double x, final double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public boolean equals(Object obj) {

        final double error = Math.pow(10, -5);

        if (obj == null)
            return false;

        if (!(obj instanceof Point))
            return false;

        if (this == obj)
            return true;

        Point point = (Point) obj;
        return Math.abs(x - point.getX()) < error && Math.abs(y - point.getY()) < error;
    }
}
