package com.drawing.command;

import com.drawing.Canvas;
import com.drawing.shape.Line;
import com.drawing.shape.Shape;
import com.drawing.shape.ShapeFactory;


/**
 * Created by ee on 18/2/15.
 */
public class LineCommand implements Command {

    private ShapeFactory shapeFactory;

    public LineCommand(ShapeFactory shapeFactory){
        this.shapeFactory = shapeFactory;
    }
    @Override
    public Canvas execute(Canvas canvas, String command) {
        String[] params = command.split(" ");
        Shape shape = shapeFactory.createLine(new Integer(params[1]), new Integer(params[2]), new Integer(params[3]), new Integer(params[4]));
        shape.draw(canvas);
        return canvas;
    }
}
