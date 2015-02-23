package com.drawing.command;

import com.drawing.Canvas;
import com.drawing.CanvasCreator;

/**
 * Created by ee on 18/2/15.
 */
public class CanvasCommand implements Command {

    private CanvasCreator canvasCreator;

    public CanvasCommand(CanvasCreator canvasCreator) {
        this.canvasCreator = canvasCreator;
    }

    @Override
    public Canvas execute(Canvas canvas, String command) {
        String[] params = command.split(" ");
        Canvas newCanvas = canvasCreator.createCanvas(new Integer(params[1]), new Integer(params[2]));
        return newCanvas;
    }
}
