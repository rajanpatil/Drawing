package com.drawing.command;

import com.drawing.Canvas;
import com.drawing.shape.BucketFill;
import com.drawing.shape.Shape;
import com.drawing.shape.ShapeFactory;


/**
 * Created by ee on 18/2/15.
 */
public class BucketFillCommand implements Command {

    private ShapeFactory shapeFactory;

    public BucketFillCommand(ShapeFactory shapeFactory){
        this.shapeFactory = shapeFactory;
    }

    @Override
    public Canvas execute(Canvas canvas, String command) {
        String[] params = command.split(" ");
        Shape shape = this.shapeFactory.createBucketFill(new Integer(params[1]), new Integer(params[2]), params[3].charAt(0));
        shape.draw(canvas);
        return canvas;
    }
}
