package com.drawing;


import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * Created by ee on 18/2/15.
 */
public class CanvasTest {

    @Test
    public void itShouldCreateAnEmptyCanvas() {
        Canvas canvas = new CanvasCreator().createCanvas(4, 4);
        int expectedHeight = 4, expectedWidth = 4;
        assertEquals(expectedHeight, canvas.getHeight());
        assertEquals(expectedWidth, canvas.getWidth());
    }

    @Test
    public void itShouldCreateAndDrawCanvas() {
        Canvas canvas = new CanvasCreator().createCanvas(4, 4);
        String expectedCanvas = "------\n|    |\n|    |\n|    |\n|    |\n------\n";
        String actualCanvas = canvas.draw();
        assertEquals(expectedCanvas, actualCanvas);
    }

    @Test
    public void itShouldSetPixelInCanvas() {
        Canvas canvas = new CanvasCreator().createCanvas(4, 4);
        String expectedCanvas = "------\n|    |\n| o  |\n|    |\n|    |\n------\n";
        canvas.setPixel(1, 1, 'o');
        String actualCanvas = canvas.draw();
        assertEquals(expectedCanvas, actualCanvas);
    }

    @Test
    public void itShouldGetPixelFromCanvas() {
        Canvas canvas = new CanvasCreator().createCanvas(4, 4);
        char expectedPixel = ' ';
        char actualPixel = canvas.getPixel(2, 2);
        assertEquals(expectedPixel, actualPixel);
    }
}
