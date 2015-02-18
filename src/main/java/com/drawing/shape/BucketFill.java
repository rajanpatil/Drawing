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
        fillArea(canvas.getCanvasArea(), this.x1, this.y1);
    }

    private void fillArea(char[][] canvas, int x1, int y1) {
        int yLength = canvas.length;
        int xLength = canvas[0].length;

        if (canvas[y1][x1] == ' ') {
            canvas[y1][x1] = fillChar;
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int neighbourX = x1 + neighboursX[i][j];
                int neighbourY = y1 + neighboursY[i][j];
                if ((neighbourX >= 0) && (neighbourX < xLength) && (neighbourY >= 0) && (neighbourY < yLength) && (canvas[neighbourY][neighbourX] == ' ')) {
                    fillArea(canvas, neighbourX, neighbourY);
                }
            }
        }
    }
}
