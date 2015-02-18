package com.drawing;


import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by ee on 18/2/15.
 */
public class CanvasTest {

    @Test
    public void itShouldCreateCanvasWith20HeightAnd4Width(){
        Canvas canvas = Canvas.newCanvas(20, 4);
        assertNotNull(canvas);
    }

    @Test
    public void itShouldCreateAndInitializeCanvas(){
        Canvas canvas = Canvas.newCanvas(4, 4);
        char[][] expectedCanvasArea = new char[][]{
                {'-','-','-','-','-','-'},
                {'-',' ',' ',' ',' ','-'},
                {'-',' ',' ',' ',' ','-'},
                {'-',' ',' ',' ',' ','-'},
                {'-',' ',' ',' ',' ','-'},
                {'-','-','-','-','-','-'},
        };
        char[][] canvasArea = canvas.getCanvasArea();
        assertArrayEquals(expectedCanvasArea, canvasArea);
    }

    @Test
    public void itShouldCreateAndDrawCanvas(){
        Canvas canvas = Canvas.newCanvas(4, 4);
        char[][] expectedCanvasArea = new char[][]{
                {'-','-','-','-','-','-'},
                {'-',' ',' ',' ',' ','-'},
                {'-',' ',' ',' ',' ','-'},
                {'-',' ',' ',' ',' ','-'},
                {'-',' ',' ',' ',' ','-'},
                {'-','-','-','-','-','-'},
        };
        canvas.draw();
        char[][] canvasArea = canvas.getCanvasArea();
        assertArrayEquals(expectedCanvasArea, canvasArea);
    }
}
