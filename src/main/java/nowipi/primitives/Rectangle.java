package nowipi.primitives;

public final class Rectangle extends Quad {

    public Rectangle(float left, float right, float top, float bottom) {
        super(
                new Vector2f(left, top),
                new Vector2f(right, top),
                new Vector2f(left, bottom),
                new Vector2f(right, bottom)
        );
    }

    public static Rectangle fromTopLeft(Vector2f topLeft, Vector2f size) {
        return fromTopLeft(topLeft.x, topLeft.y, size.x, size.y);
    }
    public static Quad fromTopLeft(Vector2f topLeft, float width, float height) {
        return fromTopLeft(topLeft.x, topLeft.y, width, height);
    }
    public static Rectangle fromTopLeft(float left, float top, float width, float height) {
        return new Rectangle(
                left,
                left + width,
                top,
                top - height);
    }

    public static Rectangle fromCenter(Vector2f center, Vector2f size) {
        return fromTopLeft(center.x, center.y, size.x, size.y);
    }
    public static Rectangle fromCenter(Vector2f center, float width, float height) {
        return fromTopLeft(center.x, center.y, width, height);
    }
    public static Rectangle fromCenter(float centerX, float centerY, float width, float height) {
        float halfWidth = width / 2;
        float halfHeight = height / 2;
        return new Rectangle(
                centerX - halfWidth,
                centerX + halfWidth,
                centerY + halfHeight,
                centerY - halfHeight
        );
    }

    public float width() {
        return Math.abs(topLeft.x - topRight.x);
    }

    public float height() {
        return Math.abs(topLeft.y - bottomLeft.y);
    }

}
