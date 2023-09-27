public interface Shape {
    void draw();
}

public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a circle");
    }
}

public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a rectangle");
    }
}

import java.util.ArrayList;
import java.util.List;

public class CompositeShape implements Shape {
    private List<Shape> shapes = new ArrayList<>();

    public void add(Shape shape) {
        shapes.add(shape);
    }

    public void remove(Shape shape) {
        shapes.remove(shape);
    }

    @Override
    public void draw() {
        for (Shape shape : shapes) {
            shape.draw();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Shape circle1 = new Circle();
        Shape circle2 = new Circle();
        Shape rectangle = new Rectangle();

        CompositeShape compositeShape = new CompositeShape();
        compositeShape.add(circle1);
        compositeShape.add(circle2);
        compositeShape.add(rectangle);

        // Drawing individual shapes
        circle1.draw();
        rectangle.draw();

        // Drawing composite shape (which includes circle1, circle2, and rectangle)
        compositeShape.draw();
    }
}
