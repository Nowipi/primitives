A Java library that has some mutable data structures.
The main purpose is performant intrinsic data structures.
The primitives are mutable because it is more performant to mutate classes in Java rather than create new ones at the moment of the library's creation.
But there are also immutable versions of any method.
No primitive should depend on anything. For example Quad has 4 vertices, not a position, width and height. Because a position could be the top left corner, but it also could be the top right or any other vertex.
