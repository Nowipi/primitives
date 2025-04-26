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
}
