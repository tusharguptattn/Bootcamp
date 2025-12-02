package org.example.factoryPattern;

public class    ShapeFactory {

    public static Shape getShape(String shapeType){
        return switch (shapeType){
            case "CIRCLE" -> new Circle();
            case "RECTANGLE" -> new Rectangle();
            default -> null;
        };
    }
}
