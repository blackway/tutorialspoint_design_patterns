package structural.facade;

/*
외관 패턴
Facade 패턴은 시스템의 복잡성을 숨기고 클라이언트가 시스템에 액세스할 수 있는 인터페이스를 클라이언트에 제공합니다. 이러한 유형의 디자인 패턴은 구조적 패턴에 속합니다. 이 패턴은 복잡성을 숨기기 위해 기존 시스템에 인터페이스를 추가하기 때문입니다.

이 패턴에는 클라이언트에 필요한 단순화된 메서드를 제공하고 기존 시스템 클래스 메서드에 대한 호출을 위임하는 단일 클래스가 포함됩니다.

구현
우리는 Shape 인터페이스와 Shape 인터페이스를 구현하는 구체적인 클래스 를 만들 것 입니다. 외관 클래스 ShapeMaker 는 다음 단계로 정의됩니다.

ShapeMaker 클래스는 구체적인 클래스를 사용하여 사용자 호출을 이러한 클래스에 위임합니다. FacadePatternDemo , 데모 클래스는 ShapeMaker 클래스를 사용하여 결과를 보여줍니다.
t pus */
public class FacadePaternDemo {
    
    public static void main(String...args) {
        ShapeMaker shapeMaker = new ShapeMaker();
        shapeMaker.drawCircle();
        shapeMaker.drawRectangle();
        shapeMaker.drawSquare();
    }
}

interface Shape {
    void draw();
}

class Rectangle implements Shape {
    @Override
    public void draw() {
       System.out.println("Rectangle::draw()"); 
    }
}

class Square implements Shape {
    @Override
    public void draw() {
       System.out.println("Square::draw()"); 
    }
}

class Circle implements Shape {
    @Override
    public void draw() {
       System.out.println("Circle::draw()"); 
    }
}

class ShapeMaker {
    private Shape circle;
    private Shape rectalgle;
    private Shape square;

    public ShapeMaker() {
        circle = new Circle();
        rectalgle = new Rectangle();
        square = new Square();
    }

    public void drawSquare() {
        square.draw();
    }

    public void drawCircle() {
        circle.draw();
    }

    public void drawRectangle() {
        rectalgle.draw();
    }
}
