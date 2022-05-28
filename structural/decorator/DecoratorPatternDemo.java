package structural.decorator;

<<<<<<< HEAD


public class DecoratorPatternDemo {
    public static void main(String...args){

        Shape circle = new Circle();

        System.out.println("Ciecle with normal border");
        circle.draw();
    }
}
=======
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
>>>>>>> 12837f2da8ec4e84f7ed829b62970498a2360d7a
