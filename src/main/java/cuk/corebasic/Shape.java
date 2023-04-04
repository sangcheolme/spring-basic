package cuk.corebasic;

import java.util.ArrayList;
import java.util.List;

public class Shape {
    private String type;

    public Shape(String type) {
        this.type = type;
    }

    public double area() {
        if (type.equals("circle")) {
            double radius = 2.0;
            return Math.PI * radius * radius;
        } else if (type.equals("square")) {
            double side = 3.0;
            return side * side;
        } else if (type.equals("triangle")) {
            double base = 4.0;
            double height = 5.0;
            return 0.5 * base * height;
        } else {
            throw new IllegalArgumentException("Unknown shape type: " + type);
        }
    }

    public static void main(String[] args) {

        List<Shape> shapes = new ArrayList<Shape>();
        shapes.add(new Shape("circle"));
        shapes.add(new Shape("triangle"));
        shapes.add(new Shape("square"));

        double totalArea = 0.0;
        for (Shape shape : shapes) {
            totalArea += shape.area();
        }
        System.out.println("Total area: " + totalArea);
    }
}
