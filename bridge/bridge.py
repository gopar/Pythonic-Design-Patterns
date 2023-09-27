# Avoid creating OpenGLCircle, DirectXCircle, etc
from typing import Protocol

# Define Renderer protocol (Abstraction)
class Renderer(Protocol):
    def render_circle(self, radius: float) -> None:
        pass

# ConcreteImplementor 1
class OpenGLRenderer:
    def render_circle(self, radius: float) -> None:
        print(f"OpenGL: Rendering circle with radius {radius}")

# ConcreteImplementor 2
class DirectXRenderer:
    def render_circle(self, radius: float) -> None:
        print(f"DirectX: Rendering circle with radius {radius}")

# Refined Abstraction
class Circle:
    def __init__(self, renderer: Renderer, radius: float) -> None:
        self.renderer = renderer
        self.radius = radius

    def draw(self) -> None:
        self.renderer.render_circle(self.radius)

# Client code
opengl = OpenGLRenderer()
directx = DirectXRenderer()

circle1 = Circle(opengl, 5)
circle2 = Circle(directx, 10)

circle1.draw()
circle2.draw()
