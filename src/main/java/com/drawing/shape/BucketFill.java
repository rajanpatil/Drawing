package com.drawing.shape;

import com.drawing.Canvas;

/**
 * Created by ee on 18/2/15.
 */
public class BucketFill implements Shape {
    private final int x1;
    private final int y1;
    private final char fillChar;

    private static final int[][] neighboursX = {{-1, 0, +1}, {-1, 0, +1}, {-1, 0, +1}};
    private static final int[][] neighboursY = {{+1, +1, +1}, {0, 0, 0}, {-1, -1, -1}};

    public BucketFill(int x1, int y1, char fillChar) {
        this.x1 = x1;
        this.y1 = y1;
        this.fillChar = fillChar;
    }

    @Override
    public void draw(Canvas canvas) {
        fillArea(canvas, this.x1, this.y1);
    }

    private void fillArea(Canvas canvas, int x, int y) {

        if (isCanvasPixelUnfilled(canvas, x, y)) {
            canvas.setPixel(x, y, fillChar);
        } else {
            return;
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int neighbourX = x + neighboursX[i][j];
                int neighbourY = y + neighboursY[i][j];
                if (isNeighbourWithinCanvasBoundary(neighbourX, neighbourY, canvas) && isCanvasPixelUnfilled(canvas, neighbourX, neighbourY)) {
                    fillArea(canvas, neighbourX, neighbourY);
                }
            }
        }
    }

    private boolean isCanvasPixelUnfilled(Canvas canvas, int neighbourX, int neighbourY) {
        return (canvas.getPixel(neighbourX, neighbourY) == ' ');
    }

    private boolean isNeighbourWithinCanvasBoundary(int x, int y, Canvas canvas) {
        return isXNeighbourWithinCanvasBoundary(canvas.getWidth(), x) && isYNeighbourWithinCanvasBoundary(canvas.getHeight(), y);
    }

    private boolean isYNeighbourWithinCanvasBoundary(int yLength, int neighbourY) {
        return (neighbourY >= 0) && (neighbourY < yLength);
    }

    private boolean isXNeighbourWithinCanvasBoundary(int xLength, int neighbourX) {
        return (neighbourX >= 0) && (neighbourX < xLength);
    }
}
