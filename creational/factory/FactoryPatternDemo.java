package creational.factory;

public class FactoryPatternDemo {
    public static void main(String...args) {
        ShapeFactory shapeFactory = new ShapeFactory();

        //get an object of Circle and call its draw method.
        Shape shape1 = shapeFactory.getShape("CIRCLE");
        //class draw method of Circle
        shape1.draw();

        //get an object of Rectangle and call its draw metohd.
        Shape shape2 = shapeFactory.getShape("RECTANGLE");
        //call draw method of Rectangle
        shape2.draw();;
    }

    interface Shape {
        void draw();
    }

    static class Circle implements Shape {

        @Override
        public void draw() {
            System.out.println("Inside Circle::draw() method.");
        }
    }
    static class Rectangle implements Shape {

        @Override
        public void draw() {
            System.out.println("Inside Rectangle::draw() method.");
        }
    }
    static class Square implements Shape {

        @Override
        public void draw() {
            System.out.println("Inside Square::draw() method.");
        }
    }

    static class ShapeFactory {

        public Shape getShape(String shapeType) {

            if(shapeType == null) {
                return null;
            }

            if(shapeType.equalsIgnoreCase("CIRCLE")){
                return new Circle();
            } else if(shapeType.equalsIgnoreCase("RECTANGLE")){
                return new Rectangle();
            } else if(shapeType.equalsIgnoreCase("SQUARE")){
                return new Square();
            }

            return null;
        }
    }
}