package structural.decorator;



public class DecoratorPatternDemo {
    public static void main(String...args){

        Shape circle = new Circle();

        System.out.println("Ciecle with normal border");
        circle.draw();
    }
}