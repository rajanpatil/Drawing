package com.drawing.shape;

import com.drawing.Canvas;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by ee on 18/2/15.
 */
public class ShapeTest {

    @Test
    public void itShouldCreateLine() {
        Shape line = ShapeFactory.newShape("L 2 4 10 4");
        assertNotNull(line);
        assertTrue(line instanceof Line);
    }

    @Test
    public void itShouldCreateARectangle() {
        Shape rectangle = ShapeFactory.newShape("R 2 2 10 10");
        assertNotNull(rectangle);
        assertTrue(rectangle instanceof Rectangle);
    }

    @Test
    public void itShouldCreateABucketFill() {
        Shape bucketFill = ShapeFactory.newShape("B 2 10 o");
        assertNotNull(bucketFill);
        assertTrue(bucketFill instanceof BucketFill);
    }

    @Test
    public void itShouldDrawALineOnCanvas() {
        Shape line = ShapeFactory.newShape("L 1 3 3 3");
        Canvas canvas = Canvas.newCanvas(4, 4);
        char[][] expectedCanvasArea = new char[][]{
                {'-', '-', '-', '-', '-', '-'},
                {'|', ' ', ' ', ' ', ' ', '|'},
                {'|', ' ', ' ', ' ', ' ', '|'},
                {'|', 'x', 'x', 'x', ' ', '|'},
                {'|', ' ', ' ', ' ', ' ', '|'},
                {'-', '-', '-', '-', '-', '-'},
        };
        line.draw(canvas);
        canvas.draw();
        char[][] canvasArea = canvas.getCanvasArea();

        assertArrayEquals(expectedCanvasArea, canvasArea);
    }

    @Test
    public void itShouldDrawARectangleOnCanvas() {
        Shape rectangle = ShapeFactory.newShape("R 1 1 3 3");
        Canvas canvas = Canvas.newCanvas(4, 4);
        char[][] expectedCanvasArea = new char[][]{
                {'-', '-', '-', '-', '-', '-'},
                {'|', 'x', 'x', 'x', ' ', '|'},
                {'|', 'x', ' ', 'x', ' ', '|'},
                {'|', 'x', 'x', 'x', ' ', '|'},
                {'|', ' ', ' ', ' ', ' ', '|'},
                {'-', '-', '-', '-', '-', '-'},
        };
        rectangle.draw(canvas);
        canvas.draw();
        char[][] canvasArea = canvas.getCanvasArea();

        assertArrayEquals(expectedCanvasArea, canvasArea);
    }

    @Test
    public void itShouldDrawABucketFillOnCanvas() {
        Shape bucketFill = ShapeFactory.newShape("B 2 2 o");
        Canvas canvas = Canvas.newCanvas(4, 4);
        char[][] expectedCanvasArea = new char[][]{
                {'-', '-', '-', '-', '-', '-'},
                {'|', 'o', 'o', 'o', 'o', '|'},
                {'|', 'o', 'o', 'o', 'o', '|'},
                {'|', 'o', 'o', 'o', 'o', '|'},
                {'|', 'o', 'o', 'o', 'o', '|'},
                {'-', '-', '-', '-', '-', '-'},
        };
        bucketFill.draw(canvas);
        canvas.draw();
        char[][] canvasArea = canvas.getCanvasArea();

        assertArrayEquals(expectedCanvasArea, canvasArea);
    }
}
