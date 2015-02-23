package com.drawing.shape;

import com.drawing.Canvas;

/**
 * Created by ee on 18/2/15.
 */
public class Line implements Shape {
    private final int x1;
    private final int y1;
    private final int x2;
    private final int y2;

    public Line(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    @Override
    public void draw(Canvas canvas) {
        for (int i = 0; i < canvas.getHeight(); i++) {
            for (int j = 0; j < canvas.getWidth(); j++) {
                if ((x2 >= j && j >= x1) && (y2 >= i && i >= y1))
                    canvas.setPixel(i, j,'x');
            }
        }
    }
}
