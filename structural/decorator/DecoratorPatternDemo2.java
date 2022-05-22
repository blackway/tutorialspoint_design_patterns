package structural.decorator;

public class DecoratorPatternDemo2 {
    public static void main(String...args) {
        
        Shape circle = new DecoratorPatternDemo2.Circle();

        System.out.println("Circle with normal border");
        circle.draw();
    }
    
    public interface Shape {
        void draw();
    }

    public static class Circle implements DecoratorPatternDemo2.Shape {

        @Override
        public void draw() {
           System.out.println("Shape: Circle"); 
        }

    }
}




