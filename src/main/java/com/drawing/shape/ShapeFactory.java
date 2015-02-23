package com.drawing.shape;

/**
 * Created by ee on 23/2/15.
 */
public class ShapeFactory {

    public Line createLine(int x1, int y1, int x2, int y2) {
        return new Line(x1, y1, x2, y2);
    }

    public Rectangle createRectangle(int x1, int y1, int x2, int y2) {
        return new Rectangle(x1, y1, x2, y2);
    }

    public BucketFill createBucketFill(int x, int y, char ch) {
        return new BucketFill(x, y, ch);
    }
}
