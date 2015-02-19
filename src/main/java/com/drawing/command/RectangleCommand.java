package com.drawing.command;

import com.drawing.Canvas;
import com.drawing.shape.Rectangle;
import com.drawing.shape.Shape;


/**
 * Created by ee on 18/2/15.
 */
public class RectangleCommand implements Command {
    @Override
    public Canvas execute(Canvas canvas, String command) {
        String[] params = command.split(" ");
        Shape shape = new Rectangle(new Integer(params[1]), new Integer(params[2]), new Integer(params[3]), new Integer(params[4]));
        shape.draw(canvas);
        canvas.draw();
        return canvas;
    }
}
