package com.drawing.shape;

import com.drawing.Canvas;

/**
 * Created by ee on 18/2/15.
 */
public class BucketFill implements Shape {
    private final int x1;
    private final int y1;
    private final char fillChar;

    public BucketFill(int x1, int y1, char fillChar) {
        this.x1 = x1;
        this.y1 = y1;
        this.fillChar = fillChar;
    }

    @Override
    public void draw(Canvas canvas) {
        fillArea(canvas.getCanvasArea(), this.x1, this.y1);
    }

    private void fillArea(char[][] canvas, int x1, int y1) {
        int yLength = canvas.length;
        int xLength = canvas[0].length;
        int newX = x1, newY = y1;

        if (canvas[newY][newX] == ' ') {
            canvas[newY][newX] = fillChar;
        }

        // x+1 y+1
        if (x1 + 1 < xLength && y1 + 1 < yLength && canvas[y1 + 1][x1 + 1] == ' ') {
            newX = x1 + 1;
            newY = y1 + 1;
            canvas[newY][newX] = fillChar;
            fillArea(canvas, newX, newY);
        }

        // x y+1
        if (y1 + 1 < yLength && canvas[y1 + 1][x1] == ' ') {
            newY = y1 + 1;
            canvas[newY][x1] = fillChar;
            fillArea(canvas, x1, newY);
        }

        // x+1 y-1
        if (x1 + 1 < xLength && y1 - 1 > 0 && canvas[y1 - 1][x1 + 1] == ' ') {
            newX = x1 + 1;
            newY = y1 - 1;
            canvas[newY][newX] = fillChar;
            fillArea(canvas, newX, newY);
        }

        // x y-1
        if (y1 - 1 > 0 && canvas[y1 - 1][x1] == ' ') {
            newY = y1 - 1;
            canvas[newY][x1] = fillChar;
            fillArea(canvas, x1, newY);
        }

        // x-1 y-1
        if (x1 - 1 > 0 && y1 - 1 > 0 && canvas[y1 - 1][x1 - 1] == ' ') {
            newX = x1 - 1;
            newY = y1 - 1;
            canvas[newY][newX] = fillChar;
            fillArea(canvas, newX, newY);
        }

        //x+1 y
        if (x1 + 1 > 0 && canvas[y1][x1 + 1] == ' ') {
            newX = x1 + 1;
            canvas[y1][newX] = fillChar;
            fillArea(canvas, newX, y1);
        }

        //x-1 y+1
        if (x1 - 1 > 0 && y1 + 1 < yLength && canvas[y1 + 1][x1 - 1] == ' ') {
            newX = x1 - 1;
            newY = y1 + 1;
            canvas[newY][newX] = fillChar;
            fillArea(canvas, newX, newY);
        }

        //x-1 y
        if (x1 - 1 < xLength && canvas[y1][x1 - 1] == ' ') {
            newX = x1 - 1;
            canvas[newY][x1] = fillChar;
            fillArea(canvas, newX, y1);
        }
    }
}
