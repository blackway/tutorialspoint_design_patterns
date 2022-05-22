package structural.decorator;

public class DecoratorPatternDemo {
    public static void main(String... strings) {
        Shape circle = new Circle();

        Shape redCircle = new RedShapeDecorator(new Circle());

        Shape redRectangle = new RedShapeDecorator(new Rectangle());

        System.out.println("\nCiecle with normal border");
        circle.draw();

        System.out.println("\nCiecle of red border");
        redCircle.draw();

        System.out.println("\nRectangle of red border");
        redRectangle.draw();
        
    }

}
