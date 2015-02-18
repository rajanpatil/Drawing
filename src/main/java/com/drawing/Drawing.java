package com.drawing;

import com.drawing.shape.Shape;

import java.util.Scanner;

import static com.drawing.shape.ShapeFactory.newShape;

/**
 * Created by ee on 18/2/15.
 */
public class Drawing {

    public static void main(String[] args) {
        Drawing drawing = new Drawing();
        Canvas canvas = null;
        while (true) {
            System.out.print("Enter command:");
            Scanner in = new Scanner(System.in);
            String[] command = in.nextLine().split(" ");

            if (command[0].equals("Q")) {
                break;
            }

            canvas = drawing.perform(canvas, command);
        }
    }

    public Canvas perform(Canvas canvas, String[] command) {
        switch (command[0]) {
            case "C":
                Canvas newCanvas = Canvas.newCanvas(new Integer(command[1]), new Integer(command[2]));
                newCanvas.draw();
                return newCanvas;
            case "L":
                Shape line = newShape("Line", new Integer(command[1]), new Integer(command[2]), new Integer(command[3]), new Integer(command[4]));
                line.draw(canvas);
                canvas.draw();
                return canvas;
            case "R":
                Shape rectangle = newShape("Rectangle", new Integer(command[1]), new Integer(command[2]), new Integer(command[3]), new Integer(command[4]));
                rectangle.draw(canvas);
                canvas.draw();
                return canvas;
            case "B":
                Shape bucketFill = newShape("BucketFill", new Integer(command[1]), new Integer(command[2]), command[3].charAt(0));
                bucketFill.draw(canvas);
                canvas.draw();
                return canvas;
            default:
                return canvas;
        }
    }
}
