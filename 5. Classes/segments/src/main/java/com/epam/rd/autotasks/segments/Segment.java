package com.epam.rd.autotasks.segments;

import static java.lang.Math.abs;
import static java.lang.Math.sqrt;
import static java.lang.StrictMath.pow;

class Segment {

    private Point start;
    private Point end;

    public Segment(Point start, Point end) {
        if (start.getX() == end.getX() && start.getY() == end.getY()) {
            throw new IllegalArgumentException();
        }
        else {
            this.start = start;
            this.end = end;
        }
    }

    double length() {
        return sqrt(pow(start.getX() - end.getX(), 2) + pow(start.getY() - end.getY(), 2));
    }

    Point middle() {
        return new Point ((start.getX() + end.getX()) / 2, (start.getY() + end.getY()) / 2);
    }

    Point intersection(Segment another) {
        double x1 = this.start.getX(), x2 = this.end.getX(),
                x3 = another.getStart().getX(), x4 = another.getEnd().getX(),
                y1 = this.start.getY(), y2 = this.end.getY(),
                y3 = another.getStart().getY(), y4 = another.getEnd().getY();

        double t = (x1 - x2) * (y3 - y4) - (y1 - y2) * (x3 - x4);
        //System.out.print("temp = " + t);
        if (t == 0) {
            return null;
        }

        double u = ((x1 - x3) * (y1 - y2) - (y1 - y3) * (x1 - x2)) / t;
        //System.out.print("u = " + u);
        t = ((x1 - x3) * (y3 - y4) - (y1 - y3) * (x3 - x4) )/ t;
        //System.out.print("t = " + t);

        if ( t >= 0 && t <= 1 && u >= 0 && u <= 1) {
            return new Point(x1 + t * (x2 - x1), y1 + t * (y2 - y1));
        }

        return null;
    }

    public Point getEnd() {
        return end;
    }

    public Point getStart() {
        return start;
    }
}
