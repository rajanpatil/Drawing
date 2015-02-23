package com.drawing;

import com.drawing.command.*;
import com.drawing.shape.ShapeFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by ee on 18/2/15.
 */
public class DrawingApp {
    private final Map<String, Command> commandsMap = new HashMap<String, Command>();

    public DrawingApp() {
        commandsMap.put("C", new CanvasCommand(new CanvasCreator()));
        commandsMap.put("L", new LineCommand(new ShapeFactory()));
        commandsMap.put("R", new RectangleCommand(new ShapeFactory()));
        commandsMap.put("B", new BucketFillCommand(new ShapeFactory()));
    }

    public static void main(String[] args) {
        DrawingApp drawing = new DrawingApp();
        drawing.start();
    }

    public void start() {
        Canvas canvas = null;
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.print("Enter command:");
            String command = in.nextLine();

            if (command.split(" ")[0].equals("Q")) {
                break;
            }

            canvas = perform(canvas, command);
        }
    }

    public Canvas perform(Canvas canvas, String command) {
        Canvas currentCanvas = getCommand(command).execute(canvas, command);
        System.out.println(currentCanvas.draw());
        return currentCanvas;
    }

    public Command getCommand(String command) {
        return commandsMap.get(command.split(" ")[0]);
    }
}
