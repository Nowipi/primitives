package nowipi.primitives;

public class Quad {

    public Vector2f topLeft;
    public Vector2f topRight;
    public Vector2f bottomLeft;
    public Vector2f bottomRight;

    public Quad(Vector2f topLeft, Vector2f topRight, Vector2f bottomLeft, Vector2f bottomRight) {
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}
