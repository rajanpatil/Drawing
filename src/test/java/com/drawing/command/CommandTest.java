package com.drawing.command;

import com.drawing.Canvas;
import com.drawing.shape.Rectangle;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by ee on 19/2/15.
 */
public class CommandTest {

    @Test
    public void itShouldExecuteCanvasCommand() {
        CanvasCommand canvasCommand = new CanvasCommand();
        Canvas canvas = canvasCommand.execute(null, "C 20 10");
        assertNotNull(canvas);
    }

    @Test
    public void itShouldExecuteLineCommand() {
        Canvas canvas = Canvas.newCanvas(20, 10);
        LineCommand lineCommand = new LineCommand();
        Canvas actualCanvas = lineCommand.execute(canvas, "L 10 1 10 10");
        assertEquals(canvas, actualCanvas);
    }

    @Test
    public void itShouldExecuteRectangleCommand() {
        Canvas canvas = Canvas.newCanvas(20, 10);
        RectangleCommand rectangleCommand = new RectangleCommand();
        Canvas actualCanvas = rectangleCommand.execute(canvas, "R 2 2 8 8");
        assertEquals(canvas, actualCanvas);
    }

    @Test
    public void itShouldExecuteBucketFillCommand() {
        Canvas canvas = Canvas.newCanvas(20, 10);
        BucketFillCommand bucketFillCommand = new BucketFillCommand();
        Canvas actualCanvas = bucketFillCommand.execute(canvas, "B 3 3 o");
        assertEquals(canvas, actualCanvas);
    }
}
