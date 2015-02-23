package com.drawing;

import com.drawing.command.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by ee on 18/2/15.
 */
public class DrawingAppTest {

    @Test
    public void itShouldGetCanvasCommand() {
        Canvas canvas = null;
        String command = "C 20 10";
        DrawingApp drawing = new DrawingApp();
        Command commandObj = drawing.getCommand(command);
        assertTrue(commandObj instanceof CanvasCommand);
    }

    @Test
    public void itShouldGetLineCommand() {
        String command = "L 0 2 6 2";
        DrawingApp drawing = new DrawingApp();
        Command commandObj = drawing.getCommand(command);
        assertTrue(commandObj instanceof LineCommand);
    }

    @Test
    public void itShouldGetRectangleCommand() {
        String command = "R 2 2 6 6";
        DrawingApp drawing = new DrawingApp();
        Command commandObj = drawing.getCommand(command);
        assertTrue(commandObj instanceof RectangleCommand);
    }

    @Test
    public void itShouldGetBucketFillCommand() {
        String command = "B 2 4 o";
        DrawingApp drawing = new DrawingApp();
        Command commandObj = drawing.getCommand(command);
        assertTrue(commandObj instanceof BucketFillCommand);
    }

    @Test
    public void itShouldCreateACanvas() {
        Canvas canvas = null;
        String command = "C 20 10";
        DrawingApp drawing = new DrawingApp();
        canvas = drawing.perform(canvas, command);
        int expectedHeight = 20, expectedWidth = 10;
        assertEquals(expectedHeight, canvas.getHeight());
        assertEquals(expectedWidth, canvas.getWidth());
    }


    /*
        Drawing application integration tests.
     */

    @Test
    public void integration_itShouldDrawALineOnCanvas() {
        Canvas canvas = null;
        String createCanvasCommand = "C 4 4";
        DrawingApp drawing = new DrawingApp();
        canvas = drawing.perform(canvas, createCanvasCommand);

        String drawLineCommand = "L 0 2 2 2";
        drawing.perform(canvas, drawLineCommand);

        String expectedCanvas = "------\n|  x |\n|  x |\n|  x |\n|    |\n------\n";
        String actualCanvas = canvas.draw();

        assertEquals(expectedCanvas, actualCanvas);
    }

    @Test
    public void integration_itShouldDrawARectangleOnCanvas() {
        Canvas canvas = null;
        String createCanvasCommand = "C 4 4";
        DrawingApp drawing = new DrawingApp();
        canvas = drawing.perform(canvas, createCanvasCommand);

        String drawRectangleCommand = "R 1 1 2 2";
        drawing.perform(canvas, drawRectangleCommand);

        String expectedCanvas = "------\n|    |\n| xx |\n| xx |\n|    |\n------\n";
        String actualCanvas = canvas.draw();

        assertEquals(expectedCanvas, actualCanvas);
    }

    @Test
    public void integration_itShouldDrawABucketFillOnCanvas() {
        Canvas canvas = null;
        String createCanvasCommand = "C 4 4";
        DrawingApp drawing = new DrawingApp();
        canvas = drawing.perform(canvas, createCanvasCommand);

        String drawBucketFillCommand = "B 0 0 o";
        drawing.perform(canvas, drawBucketFillCommand);

        String expectedCanvas = "------\n|oooo|\n|oooo|\n|oooo|\n|oooo|\n------\n";
        String actualCanvas = canvas.draw();

        assertEquals(expectedCanvas, actualCanvas);
    }

    @Test
    public void integration_itShouldDrawALine_Rectangle_And_BucketFill_OnCanvas() {
        Canvas canvas = null;
        String createCanvasCommand = "C 8 8";
        DrawingApp drawing = new DrawingApp();
        canvas = drawing.perform(canvas, createCanvasCommand);

        String drawLineCommand = "L 0 2 2 2";
        drawing.perform(canvas, drawLineCommand);

        String drawRectangleCommand = "R 3 3 6 6";
        drawing.perform(canvas, drawRectangleCommand);

        String drawBucketFillCommand = "B 4 4 o";
        drawing.perform(canvas, drawBucketFillCommand);

        String expectedCanvas = "----------\n|  x     |\n|  x     |\n|  x     |\n|   xxxx |\n|   xoox |\n|   xoox |\n|   xxxx |\n|        |\n----------\n";
        String actualCanvas = canvas.draw();
        assertEquals(expectedCanvas, actualCanvas);
    }
}
