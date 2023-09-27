// Abstraction
interface Renderer {
    void renderCircle(float radius);
}

// Concrete Implementations
class OpenGLRenderer implements Renderer {
    @Override
    public void renderCircle(float radius) {
        System.out.println("Drawing a circle with OpenGL with radius " + radius);
    }
}

class DirectXRenderer implements Renderer {
    @Override
    public void renderCircle(float radius) {
        System.out.println("Drawing a circle with DirectX with radius " + radius);
    }
}

// Refined Abstraction
class Circle {
    private float radius;
    private Renderer renderer;

    public Circle(float radius, Renderer renderer) {
        this.radius = radius;
        this.renderer = renderer;
    }

    public void draw() {
        renderer.renderCircle(radius);
    }
}

// Client code
public class Main {
    public static void main(String[] args) {
        Renderer openGL = new OpenGLRenderer();
        Renderer directX = new DirectXRenderer();

        Circle circle1 = new Circle(5, openGL);
        Circle circle2 = new Circle(10, directX);

        circle1.draw();
        circle2.draw();
    }
}
