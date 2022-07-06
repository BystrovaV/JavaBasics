package com.epam.rd.autotasks.intersection;

public class Line {

    private int k;
    private int b;

    public Line(int k, int b) {
        this.k = k;
        this.b = b;
    }

    public Point intersection(Line other) {
        int x, y;
        int temp = this.k - other.getK();

        if (temp == 0) {
            return null;
        }

        x = (other.getB() - this.b) / temp;
        y = this.k * x + this.b;
        return new Point(x, y);
    }

    public int getB() {
        return b;
    }

    public int getK() {
        return k;
    }
}
