package com.drawing.shape;

import com.drawing.Canvas;
import com.drawing.CanvasCreator;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by ee on 18/2/15.
 */
public class ShapeTest {

    @Test
    public void itShouldDrawALineOnCanvas() {
        Shape line = new Line(0,2,2,2);
        Canvas canvas = new CanvasCreator().createCanvas(4, 4);
        String expectedCanvas = "------\n|  x |\n|  x |\n|  x |\n|    |\n------\n";
        line.draw(canvas);
        String actualCanvas = canvas.draw();

        assertEquals(expectedCanvas, actualCanvas);
    }

    @Test
    public void itShouldDrawARectangleOnCanvas() {
        Shape rectangle = new Rectangle(0,0,2,2);
        Canvas canvas = new CanvasCreator().createCanvas(4, 4);
        String expectedCanvas = "------\n|xxx |\n|x x |\n|xxx |\n|    |\n------\n";
        rectangle.draw(canvas);
        String canvasArea = canvas.draw();

        assertEquals(expectedCanvas, canvasArea);
    }

    @Test
    public void itShouldDrawABucketFillOnCanvas() {
        Shape bucketFill = new BucketFill(1,1, 'o');
        Canvas canvas = new CanvasCreator().createCanvas(4, 4);
        String expectedCanvas = "------\n|oooo|\n|oooo|\n|oooo|\n|oooo|\n------\n";
        bucketFill.draw(canvas);
        String canvasArea = canvas.draw();

        assertEquals(expectedCanvas, canvasArea);
    }

    @Test
    public void itShouldDrawARectangleAndBucketFillOnCanvas() {
        Shape rectangle = new Rectangle(0,0,2,2);
        Shape bucketFill = new BucketFill(1,1, 'o');
        Canvas canvas = new CanvasCreator().createCanvas(4, 4);
        String expectedCanvas = "------\n|xxx |\n|xox |\n|xxx |\n|    |\n------\n";
        rectangle.draw(canvas);
        bucketFill.draw(canvas);
        String canvasArea = canvas.draw();

        assertEquals(expectedCanvas, canvasArea);
    }
}
