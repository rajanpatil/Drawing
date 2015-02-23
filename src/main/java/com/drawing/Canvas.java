package com.drawing;

/**
 * Created by ee on 18/2/15.
 */
public class Canvas {

    private final int height;
    private final int width;
    private char[][] canvasArea;

    public Canvas(int height, int width) {
        this.height = height;
        this.width = width;
        initialize();
    }

    public int getHeight() {
        return this.height;
    }

    public int getWidth() {
        return this.width ;
    }

    public void setPixel(int x, int y, char ch) {
        canvasArea[y][x] = ch;
    }

    public char getPixel(int x, int y) {
        return canvasArea[y][x];
    }

    public String draw() {
        StringBuffer canvasAsString = new StringBuffer("");
        for(int i = 0;i<width+2;i++){
            canvasAsString.append("-");
        }
        canvasAsString.append("\n");
        for (int i = 0; i < height ; i++) {
            canvasAsString.append("|");
            for (int j = 0; j < width ; j++) {
               canvasAsString.append(canvasArea[i][j]);
            }
            canvasAsString.append("|\n");
        }
        for(int i = 0;i<width+2;i++){
            canvasAsString.append("-");
        }
        canvasAsString.append("\n");
        return canvasAsString.toString();
    }

    private void initialize() {
        int x1 = 0, x2 = width , y1 = 0, y2 = height;
        this.canvasArea = new char[y2][x2];

        for (int i = y1; i < y2; i++) {
            for (int j = x1; j < x2; j++) {
                   canvasArea[i][j] = ' ';
            }
        }
    }
}
