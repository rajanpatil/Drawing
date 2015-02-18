package com.drawing.command;

import com.drawing.Canvas;

import static com.drawing.Canvas.newCanvas;

/**
 * Created by ee on 18/2/15.
 */
public class CanvasCommand implements Command {
    @Override
    public Canvas execute(Canvas canvas, String command) {
        String[] params = command.split(" ");
        Canvas newCanvas = newCanvas(new Integer(params[1]), new Integer(params[2]));
        newCanvas.draw();
        return newCanvas;
    }
}
