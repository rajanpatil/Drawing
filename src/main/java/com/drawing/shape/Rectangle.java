package com.drawing.shape;

import com.drawing.Canvas;

/**
 * Created by ee on 18/2/15.
 */
public class Rectangle implements Shape {
    private final int x1;
    private final int y1;
    private final int x2;
    private final int y2;

    public Rectangle(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    @Override
    public void draw(Canvas canvas) {
        char[][] canvasArea = canvas.getCanvasArea();
        for (int i = 0; i < canvasArea.length; i++) {
            for (int j = 0; j < canvasArea[0].length; j++) {
                if ((x2 >= j && j >= x1) && (y2 >= i && i >= y1))
                    if (y1 == i || y2 == i || x1 == j || x2 == j)
                        canvasArea[i][j] = 'x';
                    else
                        canvasArea[i][j] = ' ';
            }
        }
    }
}
