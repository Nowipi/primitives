package nowipi.primitives;

public final class Circle {

    public Vector2f center;
    public float radius;

    public Circle(float centerX, float centerY, float radius) {
        this(new Vector2f(centerX, centerY), radius);
    }

    public Circle(Vector2f center, float radius) {
        this.center = center;
        this.radius = radius;
    }

    public float diameter() {
        return radius * 2;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "center=" + center +
                ", radius=" + radius +
                '}';
    }

    public Rectangle toRectangle() {
        float diameter = diameter();
        return Rectangle.fromCenter(center, diameter, diameter);
    }
}
