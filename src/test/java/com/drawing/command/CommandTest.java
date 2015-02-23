package com.drawing.command;

import com.drawing.Canvas;
import com.drawing.CanvasCreator;
import com.drawing.shape.BucketFill;
import com.drawing.shape.Line;
import com.drawing.shape.Rectangle;
import com.drawing.shape.ShapeFactory;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Created by ee on 19/2/15.
 */
public class CommandTest {

    @Test
    public void itShouldExecuteCanvasCommand() {
        CanvasCreator creator = mock(CanvasCreator.class);
        Canvas canvas = new Canvas(20, 10);
        when(creator.createCanvas(20, 10)).thenReturn(canvas);
        CanvasCommand canvasCommand = new CanvasCommand(creator);
        Canvas actualCanvas = canvasCommand.execute(null, "C 20 10");
        assertEquals(canvas, actualCanvas);
        verify(creator).createCanvas(20, 10);
    }

    @Test
    public void itShouldExecuteLineCommand() {
        ShapeFactory mockShapeFactory = mock(ShapeFactory.class);
        Line mockLine = mock(Line.class);
        Canvas canvas = new CanvasCreator().createCanvas(20, 10);
        when(mockShapeFactory.createLine(10, 1, 10, 10)).thenReturn(mockLine);
        LineCommand lineCommand = new LineCommand(mockShapeFactory);
        lineCommand.execute(canvas, "L 10 1 10 10");
        verify(mockShapeFactory).createLine(10, 1, 10, 10);
        verify(mockLine).draw(canvas);
    }

    @Test
    public void itShouldExecuteRectangleCommand() {
        ShapeFactory mockShapeFactory = mock(ShapeFactory.class);
        Rectangle mockRectangle = mock(Rectangle.class);
        Canvas canvas = new CanvasCreator().createCanvas(20, 10);
        when(mockShapeFactory.createRectangle(2, 2, 8, 8)).thenReturn(mockRectangle);
        RectangleCommand rectangleCommand = new RectangleCommand(mockShapeFactory);
        rectangleCommand.execute(canvas, "R 2 2 8 8");
        verify(mockShapeFactory).createRectangle(2, 2, 8, 8);
        verify(mockRectangle).draw(canvas);
    }

    @Test
    public void itShouldExecuteBucketFillCommand() {
        ShapeFactory mockShapeFactory = mock(ShapeFactory.class);
        BucketFill mockBucketFill = mock(BucketFill.class);
        Canvas canvas = new CanvasCreator().createCanvas(20, 10);
        when(mockShapeFactory.createBucketFill(3, 3, 'o')).thenReturn(mockBucketFill);
        BucketFillCommand bucketFillCommand = new BucketFillCommand(mockShapeFactory);
        bucketFillCommand.execute(canvas, "B 3 3 o");
        verify(mockShapeFactory).createBucketFill(3, 3, 'o');
        verify(mockBucketFill).draw(canvas);
    }
}
