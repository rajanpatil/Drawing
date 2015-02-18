package com.drawing.shape;

/**
 * Created by ee on 18/2/15.
 */
public enum ShapeEnum {
    L("Line"), R("Rectangle"), B("BucketFill");
    private String shape;
    ShapeEnum(String shape){
        this.shape = shape;
    }
}
