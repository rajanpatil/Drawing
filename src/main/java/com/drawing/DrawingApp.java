package com.drawing;

import com.drawing.command.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by ee on 18/2/15.
 */
public class DrawingApp {
    private final Map<String, Command> commandsMap = new HashMap<String, Command>();

    public DrawingApp() {
        commandsMap.put("C", new CanvasCommand());
        commandsMap.put("L", new LineCommand());
        commandsMap.put("R", new RectangleCommand());
        commandsMap.put("B", new BucketFillCommand());
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
        String[] params = command.split(" ");
        return commandsMap.get(params[0]).execute(canvas, command);
    }
}
