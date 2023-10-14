package creational.prototyp;

import java.util.Hashtable;

public class PrototypePatternDemo {

    public static void main(String...args) throws CloneNotSupportedException {
        ShapeCache.loadCache();

        Shape clonedShape = (Shape) ShapeCache.getShpae("1");
        System.out.println("Shape: " + clonedShape.getType());
        Shape clonedShape2 = (Shape) ShapeCache.getShpae("2");
        System.out.println("Shape: " + clonedShape2.getType());
        Shape clonedShape3 = (Shape) ShapeCache.getShpae("3");
        System.out.println("Shape: " + clonedShape3.getType());
    }

    class ShapeCache {
        private static Hashtable<String, Shape> shapeMap = new Hashtable<>();
        
        public static Shape getShpae(String shapeId) throws CloneNotSupportedException {
            Shape cachedShape = shapeMap.get(shapeId);
            return (Shape) cachedShape.clone();
        }

        //for each shape run database query and crate shape
        //shapemap.put(shapeKey, shape);
        //for example, we are adding three shapes
        public static void loadCache() {
            Circle circle = new PrototypePatternDemo().new Circle();
            circle.setId("1");
            shapeMap.put(circle.getId(), circle);

            Square square = new PrototypePatternDemo().new Square();
            square.setId("2");
            shapeMap.put(square.getId(), square);

            Rectangle rectangle = new PrototypePatternDemo().new Rectangle();
            rectangle.setId("3");
            shapeMap.put(rectangle.getId(), rectangle);

        }
        
    }

    abstract class Shape implements Cloneable {
        private String id;
        protected String type;

        abstract void draw();

        public String getType() {
            return type;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }

    class Rectangle extends Shape {
        public Rectangle() {
            type = "Rectangle";
        }
        
        @Override
        void draw() {
            System.out.println("Inside Rectangle::draw() method.");
        }
    }

    class Square extends Shape {
        public Square() {
            type = "Square";
        }
        
        @Override
        void draw() {
            System.out.println("Inside Square::draw() method.");
        }
    }

    class Circle extends Shape {
        public Circle() {
            type = "Circle";
        }
        
        @Override
        void draw() {
            System.out.println("Inside Circle::draw() method.");
        }
    }
}