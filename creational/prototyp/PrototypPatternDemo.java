package creational.prototyp;

import java.util.Hashtable;

public class PrototypPatternDemo {
    public static void main(String... args) {
        ShapeCache.loadCache();

        Shape clonedShape = (Shape) ShapeCache.getShape("1");
        System.out.println("Shape: " + clonedShape.getType());
        Shape clonedShape2 = (Shape) ShapeCache.getShape("2");
        System.out.println("Shape: " + clonedShape2.getType());
        Shape clonedShape3 = (Shape) ShapeCache.getShape("3");
        System.out.println("Shape: " + clonedShape3.getType());

        Shape r1 =  (Shape) ShapeCache.getShape("3");
        r1.setStrNm("a");
        System.out.println("r1.setStrNm: " + r1.getStrNm());

        Shape r2 =  (Shape) ShapeCache.getShape("3");
        System.out.println("r2.setStrNm: " + r2.getStrNm());

    }

    class ShapeCache {
        private static Hashtable<String, Shape> shapeMap = new Hashtable<String, Shape>();

        public static Shape getShape(String shapeId) {
            Shape cschedShape = shapeMap.get(shapeId);
            return (Shape) cschedShape.clone();
        }

        //for each shape run database query and create shape
        //shapeMap.put(shapeKey, shape);
        //for example, we are adding three shapes

        public static void loadCache() {
            Circle circle = new PrototypPatternDemo().new Circle();
            circle.setId("1");
            shapeMap.put(circle.getId(), circle);
            Square square = new PrototypPatternDemo().new Square();
            square.setId("2");
            shapeMap.put(square.getId(), square);
            Rectangle rectangle = new PrototypPatternDemo().new Rectangle();
            rectangle.setId("3");
            shapeMap.put(rectangle.getId(), rectangle);
        }

    }

    abstract class Shape implements Cloneable {
        private String id;
        protected String type;
        private String strNm;

        public String getStrNm() {
            return strNm;
        }

        public void setStrNm(String strNm) {
            this.strNm = strNm;
        }

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

        public Object clone() {
            Object clone = null;

            try {
                clone = super.clone();
            } catch (CloneNotSupportedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            return clone;
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
            System.out.println("Inside Square::draw() method.");
        }
    }
}
