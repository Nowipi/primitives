package nowipi.primitives;

public final class Vector2f {

    public float x;
    public float y;

    public Vector2f(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public static Vector2f newZeroVector() {
        return new Vector2f(0, 0);
    }

    public static Vector2f newUniformVector(float uniform) {
        return new Vector2f(uniform, uniform);
    }

    public static Vector2f newCopyOf(Vector2f v) {
        return new Vector2f(v.x, v.y);
    }

    public static Vector2f add(Vector2f v1, Vector2f v2) {
        return new Vector2f(v1.x + v2.x, v1.y + v2.y);
    }

    public Vector2f add(Vector2f v) {
        x += v.x;
        y += v.y;
        return this;
    }

    public static Vector2f sub(Vector2f v1, Vector2f v2) {
        return new Vector2f(v1.x - v2.x, v1.y - v2.y);
    }

    public Vector2f sub(Vector2f v) {
        x -= v.x;
        y -= v.y;
        return this;
    }
}
