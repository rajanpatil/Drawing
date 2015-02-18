package com.drawing.command;

import com.drawing.Canvas;

/**
 * Created by ee on 18/2/15.
 */
public interface Command {

    public Canvas execute(Canvas canvas, String command);
}
