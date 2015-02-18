package com.drawing.shape;

/**
 * Created by ee on 18/2/15.
 */
public class ShapeFactory {
    public static Shape newShape(String shapeType, int x1, int y1, int x2, int y2) {
        Shape shape = null;
        if (shapeType.equals("Line")) {
            shape = new Line(x1, y1, x2, y2);
        } else if (shapeType.equals("Rectangle")) {
            shape = new Rectangle(x1, y1, x2, y2);
        }
        return shape;
    }

    public static Shape newShape(String shapeType, int x1, int y1, char fillChar) {
        Shape shape = null;
        if (shapeType.equals("BucketFill")) {
            shape = new BucketFill(x1, y1, fillChar);
        }
        return shape;
    }
}
