package com.drawing.command;

import com.drawing.Canvas;
import com.drawing.shape.BucketFill;
import com.drawing.shape.Shape;


/**
 * Created by ee on 18/2/15.
 */
public class BucketFillCommand implements Command {
    @Override
    public Canvas execute(Canvas canvas, String command) {
        String[] params = command.split(" ");
        Shape shape = new BucketFill(new Integer(params[1]), new Integer(params[2]), params[3].charAt(0));
        shape.draw(canvas);
        canvas.draw();
        return canvas;
    }
}
