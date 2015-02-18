package com.drawing;

import com.drawing.command.CanvasCommand;
import com.drawing.command.Command;
import com.drawing.command.ShapeCommand;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by ee on 18/2/15.
 */
public class Drawing {
    private static final Map<String, Command> commandsMap = new HashMap<String, Command>();

    public Drawing() {
        commandsMap.put("C", new CanvasCommand());
        commandsMap.put("L", new ShapeCommand());
        commandsMap.put("R", new ShapeCommand());
        commandsMap.put("B", new ShapeCommand());
    }

    public static void main(String[] args) {
        Drawing drawing = new Drawing();
        Canvas canvas = null;
        while (true) {
            System.out.print("Enter command:");
            Scanner in = new Scanner(System.in);
            String command = in.nextLine();

            if (command.split(" ")[0].equals("Q")) {
                break;
            }

            canvas = drawing.perform(canvas, command);
        }
    }

    public Canvas perform(Canvas canvas, String command) {
        return commandsMap.get(command.split(" ")[0]).execute(canvas, command);
    }
}
