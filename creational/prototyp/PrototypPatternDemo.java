package creational.prototyp;

public class PrototypPatternDemo {
    public static void main(String... args) {
        ShapeCache.loadCache();

        Shape clonedShape = (Shape) ShapeCache.getShape("1");
        System.out.println("Shape: " + clonedShape.getType());
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

    public class Rectangle extends Shape {
        public Rectangle() {
            type = "Rectangle";
        }

        @Override
        void draw() {
            System.out.println("Inside Rectangle::draw() method.");
        }
    }
    public class Square extends Shape {
        public Square() {
            type = "Square";
        }

        @Override
        void draw() {
            System.out.println("Inside Square::draw() method.");
        }
    }
    public class Circle extends Shape {
        public Circle() {
            type = "Square";
        }

        @Override
        void draw() {
            System.out.println("Inside Square::draw() method.");
        }
    }
}
