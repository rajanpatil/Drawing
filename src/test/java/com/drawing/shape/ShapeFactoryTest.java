package com.drawing.shape;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * Created by ee on 23/2/15.
 */
public class ShapeFactoryTest {

    @Test
    public void itShouldCreateALine() {
        ShapeFactory shapeFactory = new ShapeFactory();
        Line line = shapeFactory.createLine(2, 2, 6, 2);
        assertNotNull(line);
    }

    @Test
    public void itShouldCreateARectangle() {
        ShapeFactory shapeFactory = new ShapeFactory();
        Rectangle rectangle = shapeFactory.createRectangle(2, 2, 6, 6);
        assertNotNull(rectangle);
    }

    @Test
    public void itShouldCreateABucketFill() {
        ShapeFactory shapeFactory = new ShapeFactory();
        BucketFill bucketFill = shapeFactory.createBucketFill(2, 2, 'o');
        assertNotNull(bucketFill);
    }
}
