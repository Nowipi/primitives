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


    public static Vector2f newPerpendicular(Vector2f a, Vector2f b) {
        Vector2f d = Vector2f.sub(b, a);
        return new Vector2f(-d.y, d.x);
    }

    public static Vector2f newClockWisePerpendicular(Vector2f a,  Vector2f b) {
        Vector2f d = Vector2f.sub(b, a);
        return new Vector2f(d.y, -d.x);
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

    public static Vector2f mul(Vector2f v, float scalar) {
        return new Vector2f(v.x * scalar, v.y * scalar);
    }

    public Vector2f mul(float scalar) {
        x *= scalar;
        y *= scalar;
        return this;
    }

    public float squaredLength() {
        return (x * x) + (y * y);
    }

    public float length() {
        return (float) Math.sqrt(squaredLength());
    }

    public float dot(Vector2f v) {
        return dot(this, v);
    }

    public static float dot(Vector2f a, Vector2f b) {
        return a.x * b.x + a.y * b.y;
    }

    public Vector2f normalize() {
        float length = length();
        if (length == 0) {
            x = 0;
            y = 0;
        } else {
            x /= length;
            y /= length;
        }
        return this;
    }

    public static Vector2f normalize(Vector2f v) {
        float length = v.length();
        if (length == 0) {
            return newZeroVector();
        }
        return new Vector2f(v.x/ length, v.y / length);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Vector2f vector2f)) return false;

        return Float.compare(x, vector2f.x) == 0 && Float.compare(y, vector2f.y) == 0;
    }

    @Override
    public int hashCode() {
        int result = Float.hashCode(x);
        result = 31 * result + Float.hashCode(y);
        return result;
    }

    @Override
    public String toString() {
        return "Vector2f{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
