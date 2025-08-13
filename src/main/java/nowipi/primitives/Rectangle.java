package nowipi.primitives;

/**
 * {P,P+u,P+u+v,P+v}
 * ⟨u,v⟩ = 0
 */
public class Rectangle implements Quad {

    private static final float EPSILON = 1e-6f;

    public final Vector2f a;
    public final Vector2f b;
    public final Vector2f c;
    public final Vector2f d;

    public Rectangle(Vector2f p, Vector2f u, Vector2f v) {
        if (Math.abs(u.dot(v)) > EPSILON) {
            throw new IllegalArgumentException("u and v must be perpendicular");
        }
        if (u.squaredLength() == 0 || v.squaredLength() == 0) {
            throw new IllegalArgumentException("u and v must be non-zero");
        }

        this.a = p;
        this.b = Vector2f.add(p, u);
        this.c = Vector2f.add(p, u).add(v);
        this.d = Vector2f.add(p, v);
    }

    public static Rectangle fromAxisAligned(float left, float right, float top, float bottom) {
        return new Rectangle(new Vector2f(left, top), new Vector2f(right - left, 0), new Vector2f(0, bottom - top));
    }

    public static Rectangle fromTopLeft(Vector2f topLeft, Vector2f size) {
        return fromTopLeft(topLeft.x, topLeft.y, size.x, size.y);
    }
    public static Quad fromTopLeft(Vector2f topLeft, float width, float height) {
        return fromTopLeft(topLeft.x, topLeft.y, width, height);
    }
    public static Rectangle fromTopLeft(float left, float top, float width, float height) {
        return fromAxisAligned(
                left,
                left + width,
                top,
                top - height);
    }

    public static Rectangle fromBottomLeft(Vector2f bottomLeft, Vector2f size) {
        return fromBottomLeft(bottomLeft.x, bottomLeft.y, size.x, size.y);
    }
    public static Quad fromBottomLeft(Vector2f bottomLeft, float width, float height) {
        return fromBottomLeft(bottomLeft.x, bottomLeft.y, width, height);
    }
    public static Rectangle fromBottomLeft(float left, float bottom, float width, float height) {
        return fromAxisAligned(
                left,
                left + width,
                bottom + height,
                bottom);
    }

    public static Rectangle fromCenter(Vector2f center, Vector2f size) {
        return fromCenter(center.x, center.y, size.x, size.y);
    }
    public static Rectangle fromCenter(Vector2f center, float width, float height) {
        return fromCenter(center.x, center.y, width, height);
    }
    public static Rectangle fromCenter(float centerX, float centerY, float width, float height) {
        float halfWidth = width / 2;
        float halfHeight = height / 2;
        return fromAxisAligned(
                centerX - halfWidth,
                centerX + halfWidth,
                centerY + halfHeight,
                centerY - halfHeight
        );
    }

    public float area() {
        return width() * height();
    }

    public float width() {
        return Vector2f.sub(b, a).length();
    }

    public float height() {
        return Vector2f.sub(d, a).length();
    }

    @Override
    public Vertices vertices() {
        return new Vertices(a, b, c, d);
    }
}
