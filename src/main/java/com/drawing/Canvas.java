package com.drawing;

/**
 * Created by ee on 18/2/15.
 */
public class Canvas {

    private char[][] canvasArea;

    private Canvas(int height, int width) {
        initialize(height, width);
    }


    public static Canvas newCanvas(int height, int width) {
        return new Canvas(height, width);
    }


    public void draw() {
        for (int i = 0; i < canvasArea.length; i++) {
            for (int j = 0; j < canvasArea[0].length; j++) {
                System.out.print(canvasArea[i][j]);
            }
            System.out.println();
        }
    }

    public char[][] getCanvasArea() {
        return this.canvasArea;
    }

    private void initialize(int width, int height) {
        int x1 = 0, x2 = width + 2, y1 = 0, y2 = height + 2;
        this.canvasArea = new char[y2][x2];

        for (int i = y1; i < y2; i++) {
            for (int j = x1; j < x2; j++) {
                if (y1 == i || y2 - 1 == i || x1 == j || x2 - 1 == j)
                    canvasArea[i][j] = '-';
                else
                    canvasArea[i][j] = ' ';
            }
        }
    }
}
