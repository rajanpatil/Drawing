package com.drawing.shape;

/**
 * Created by ee on 18/2/15.
 */
public class ShapeFactory {

    public static Shape newShape(String command) {
        Shape shape = null;
        String[] params = command.split(" ");
        if (params[0].equals("B")) {
            shape = new BucketFill(new Integer(params[1]), new Integer(params[2]), params[3].charAt(0));
        } else if (params[0].equals("L")) {
            shape = new Line(new Integer(params[1]), new Integer(params[2]), new Integer(params[3]), new Integer(params[4]));
        } else if (params[0].equals("R")) {
            shape = new Rectangle(new Integer(params[1]), new Integer(params[2]), new Integer(params[3]), new Integer(params[4]));
        }

        return shape;
    }
}
