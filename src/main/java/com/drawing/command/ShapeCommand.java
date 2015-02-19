package com.drawing.command;

import com.drawing.Canvas;
import com.drawing.shape.Shape;

import static com.drawing.shape.ShapeFactory.newShape;

/**
 * Created by ee on 18/2/15.
 */
public class ShapeCommand implements Command {
    @Override
    public Canvas execute(Canvas canvas, String command) {
        Shape shape = newShape(command);
        shape.draw(canvas);
        canvas.draw();
        return canvas;
    }
}
