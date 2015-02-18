package com.drawing.command;

import com.drawing.Canvas;
import junit.framework.Assert;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

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
    public void itShouldExecuteShapeCommand() {
        Canvas canvas = Canvas.newCanvas(20, 10);
        ShapeCommand shapeCommand = new ShapeCommand();
        Canvas actualCanvas = shapeCommand.execute(canvas, "L 10 1 10 10");
        assertEquals(canvas, actualCanvas);
    }
}
