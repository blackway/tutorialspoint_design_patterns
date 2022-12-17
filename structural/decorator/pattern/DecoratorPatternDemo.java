package structural.decorator.pattern;

/*
데코레이터 패턴을 사용하면 구조를 변경하지 않고 기존 객체에 새로운 기능을 추가할 수 있습니다. 이러한 유형의 디자인 패턴은 기존 클래스에 대한 래퍼 역할을 하므로 구조적 패턴에 속합니다.

이 패턴은 원래 클래스를 래핑하는 데코레이터 클래스를 만들고 클래스 메서드 서명을 그대로 유지하는 추가 기능을 제공합니다.

우리는 다음 예제를 통해 Decorator 패턴의 사용을 시연하고 있습니다. 이 예제에서는 모양 클래스를 변경하지 않고 일부 색상으로 모양을 장식합니다.

구현
우리는 Shape 인터페이스와 Shape 인터페이스를 구현하는 구체적인 클래스 를 만들 것 입니다. 그런 다음 Shape 인터페이스를 구현하고 Shape 개체를 인스턴스 변수로 갖는 추상 데코레이터 클래스 ShapeDecorator 를 만듭니다.

RedShapeDecorator 는 ShapeDecorator 를 구현하는 구체적인 클래스 입니다.

DecoratorPatternDemo , 데모 클래스는 RedShapeDecorator 를 사용하여 Shape 개체 를 장식 합니다.
 */

public class DecoratorPatternDemo {
    public static void main(String...args) {

        Shape circle = new Circle();

        Shape redCircle = new RedShapeDecorator(new Circle());

        Shape redRectangle = new RedShapeDecorator(new Rectangle());
        System.out.println("Circle with normal border");
        circle.draw();

        System.out.println("\nCircle of red border");
        redCircle.draw();

        System.out.println("\nRectangle of red border");
        redRectangle.draw();
    }
}


interface Shape {
    void draw();
}

class Rectangle implements Shape {

    @Override
    public void draw() {
       System.out.println("Shape: Rectangle");
    }
}

class Circle implements Shape {

    @Override
    public void draw() {
       System.out.println("Shape: Circle"); 
    }
}

abstract class ShapeDecorator implements Shape {
    protected Shape decoratedShape;

    public ShapeDecorator(Shape decoratedShape) {
        this.decoratedShape = decoratedShape;
    }

    public void draw() {
        decoratedShape.draw();
    }
}

class RedShapeDecorator extends ShapeDecorator {

    public RedShapeDecorator(Shape decoratedShape) {
        super(decoratedShape);
    }

    public void draw() {
        decoratedShape.draw();
        setReadDorder(decoratedShape);
    }

    private void setReadDorder(Shape decoratedShape) {
        System.out.println("Border Color: Red");
    }
    
}

