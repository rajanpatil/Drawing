package com.drawing;

import org.junit.Test;

import static junit.framework.Assert.assertNotNull;

/**
 * Created by ee on 18/2/15.
 */
public class DrawingAppTest {

    @Test
    public void itShouldPerform_C_20_10_Command() {
        Canvas canvas = null;
        String command = "C 20 10";
        DrawingApp drawing = new DrawingApp();
        canvas = drawing.perform(canvas, command);
        assertNotNull(canvas);
    }

    @Test
    public void itShouldPerform_L_2_4_8_4_Command() {
        Canvas canvas = null;
        String createCanvasCommand = "C 20 10";
        DrawingApp drawing = new DrawingApp();
        canvas = drawing.perform(canvas, createCanvasCommand);

        String drawLineCommand = "L 2 4 8 4";
        drawing.perform(canvas, drawLineCommand);
    }

    @Test
    public void itShouldPerform_R_2_2_8_8_Command() {
        Canvas canvas = null;
        String createCanvasCommand = "C 20 10";
        DrawingApp drawing = new DrawingApp();
        canvas = drawing.perform(canvas, createCanvasCommand);

        String drawRectangleCommand = "R 2 2 8 8";
        drawing.perform(canvas, drawRectangleCommand);
    }

    @Test
    public void itShouldPerform_B_6_8_o_Command() {
        Canvas canvas = null;
        String createCanvasCommand = "C 20 10";
        DrawingApp drawing = new DrawingApp();
        canvas = drawing.perform(canvas, createCanvasCommand);

        String drawBucketFillCommand = "B 6 8 o";
        drawing.perform(canvas, drawBucketFillCommand);
    }

    @Test
    public void itShouldPerform_L_2_4_8_4_R_2_2_8_8__B_6_8_o_Commands() {
        Canvas canvas = null;
        String createCanvasCommand = "C 20 10";
        DrawingApp drawing = new DrawingApp();
        canvas = drawing.perform(canvas, createCanvasCommand);

        String drawLineCommand = "L 2 4 8 4";
        drawing.perform(canvas, drawLineCommand);

        String drawRectangleCommand = "R 2 2 8 8";
        drawing.perform(canvas, drawRectangleCommand);

        String drawBucketFillCommand = "B 10 8 o";
        drawing.perform(canvas, drawBucketFillCommand);
    }
}
