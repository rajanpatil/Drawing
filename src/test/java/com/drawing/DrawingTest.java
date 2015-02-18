package com.drawing;

import junit.framework.Assert;
import org.junit.Test;

import java.util.Arrays;

import static junit.framework.Assert.assertNotNull;

/**
 * Created by ee on 18/2/15.
 */
public class DrawingTest {

    @Test
    public void itShouldPerform_C_20_10_Command(){
        Canvas canvas = null;
        String[] command = "C 20 10".split(" ");
        Drawing drawing = new Drawing();
        canvas = drawing.perform(canvas,command);
        assertNotNull(canvas);
    }

    @Test
    public void itShouldPerform_L_2_4_8_4_Command(){
        Canvas canvas = null;
        String[] createCanvasCommand = "C 20 10".split(" ");
        Drawing drawing = new Drawing();
        canvas = drawing.perform(canvas,createCanvasCommand);
        String[] drawLineCommand = "L 2 4 8 4".split(" ");
        drawing.perform(canvas, drawLineCommand);
    }

    @Test
    public void itShouldPerform_R_2_2_8_8_Command(){
        Canvas canvas = null;
        String[] createCanvasCommand = "C 20 10".split(" ");
        Drawing drawing = new Drawing();
        canvas = drawing.perform(canvas,createCanvasCommand);
        String[] drawRectangleCommand = "R 2 2 8 8".split(" ");
        drawing.perform(canvas, drawRectangleCommand);
    }

    @Test
    public void itShouldPerform_B_6_8_o_Command(){
        Canvas canvas = null;
        String[] createCanvasCommand = "C 20 10".split(" ");
        Drawing drawing = new Drawing();
        canvas = drawing.perform(canvas,createCanvasCommand);
        String[] drawBucketFillCommand = "B 6 8 o".split(" ");
        drawing.perform(canvas, drawBucketFillCommand);
    }
}
