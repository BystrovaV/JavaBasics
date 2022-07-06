package com.epam.rd.autotasks.figures;

class Quadrilateral extends Figure {
    private final Point a, b, c, d;

    public Quadrilateral(Point a, Point b, Point c, Point d) {
        if (a == null || b == null || c == null || d == null)
            throw new IllegalArgumentException();

        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;

        Point point = intersection();
        if (point == null)
            throw new IllegalArgumentException();

        Triangle tr1 = new Triangle(a, point, b);
        Triangle tr2 = new Triangle(c, point, b);
        Triangle tr3 = new Triangle(a, point, d);
        Triangle tr4 = new Triangle(c, point, d);
    }

    @Override
    public Point centroid() {
        Triangle triangle1 = new Triangle(a, b, c);
        Triangle triangle2 = new Triangle(a, c, d);

        Triangle triangle3 = new Triangle(a, b, d);
        Triangle triangle4 = new Triangle(b, c, d);

        Point p1 = triangle1.centroid();
        Point p2 = triangle2.centroid();

        Point p3 = triangle3.centroid();
        Point p4 = triangle4.centroid();

        Quadrilateral q = new Quadrilateral(p1, p4, p2, p3);
        //q.intersection();

        return q.intersection();
    }

    @Override
    public boolean isTheSame(Figure figure) {
        if (figure == null)
            return false;

        if (!(figure instanceof Quadrilateral))
            return false;

        Quadrilateral q = (Quadrilateral) figure;
        Point [] points = {q.a, q.b, q.c, q.d};
        Point [] thisPoints = {a, b, c, d};

        int count ;
        for (int i = 0; i < 4; i++) {
            count = 0;
            for (int j = 0; j < 4; j++) {
                if (thisPoints[j].equals(points[(i + j) % 4]))
                    count++;
            }
            if (count == 4)
                return true;

            for (int j = 3; j >= 0; j--) {
                if (thisPoints[j].equals(points[(i + j) % 4]))
                    count++;
            }
            if (count == 4)
                return true;
        }

        return false;
    }

    Point intersection() {
        double x1 = a.getX(), y1 = a.getY(), x2 = c.getX(), y2 = c.getY(),
                x3 = b.getX(), y3 = b.getY(), x4 = d.getX(), y4 = d.getY();

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

}
