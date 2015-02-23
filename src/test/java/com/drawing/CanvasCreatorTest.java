package com.drawing;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by ee on 23/2/15.
 */
public class CanvasCreatorTest {

    @Test
    public void itShouldCreateCanvas() {
        CanvasCreator creator = new CanvasCreator();
        Canvas canvas = creator.createCanvas(20, 10);
        Assert.assertNotNull(canvas);
    }
}
