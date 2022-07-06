package com.epam.rd.autotasks.triangle;


public class Main {
    public static void main(String[] args) {
        {
            double area = new Triangle(new Point(0, 0), new Point(3, 0), new Point(0, 4)).area();
            System.out.println("Triangle with sides in points (0, 0), (3, 0), (0, 4)");
            System.out.println("Area: " + area);
            System.out.println();
        }
        {
            Point centroid = new Triangle(new Point(0, 0), new Point(3, 0), new Point(0, 3)).centroid();
            System.out.println("Triangle with sides in points (0, 0), (3, 0), (0, 3)");
            System.out.println("Centroid: (" + centroid.getX() + ", " + centroid.getY() + ")");
        }
    }
}
