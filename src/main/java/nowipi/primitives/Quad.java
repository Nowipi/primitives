package nowipi.primitives;

import java.util.Iterator;

public interface Quad {

    record Vertices(Vector2f a, Vector2f b, Vector2f c, Vector2f d) implements Iterable<Vector2f> {
        @Override
        public Iterator<Vector2f> iterator() {
            return new Iterator<>() {

                private int cursor = 0;

                @Override
                public boolean hasNext() {
                    return cursor < 4;
                }

                @Override
                public Vector2f next() {
                    return switch (cursor++) {
                        case 0 -> a;
                        case 1 -> b;
                        case 2 -> c;
                        case 3 -> d;
                        default -> throw new IllegalStateException("Unexpected value: " + cursor);
                    };
                }
            };
        }
    }

    Vertices vertices();
}
