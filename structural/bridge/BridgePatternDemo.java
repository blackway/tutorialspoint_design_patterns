package structural.bridge;


/*
브리지 패턴
Bridge는 구현에서 추상화를 분리하여 둘이 독립적으로 변경될 수 있도록 하는 데 사용됩니다. 이 유형의 디자인 패턴은 구현 클래스와 추상 클래스 사이에 브리지 구조를 제공하여 분리하므로 구조적 패턴에 속합니다.

이 패턴에는 구체적인 클래스의 기능을 인터페이스 구현자 클래스와 독립적으로 만드는 다리 역할을 하는 인터페이스가 포함됩니다. 두 유형의 클래스는 서로 영향을 주지 않고 구조적으로 변경할 수 있습니다.

우리는 동일한 추상 클래스 메서드를 사용하지만 다른 브리지 구현자 클래스를 사용하여 다른 색상으로 원을 그릴 수 있는 다음 예제를 통해 브리지 패턴의 사용을 시연하고 있습니다.

구현
브리지 구현자 역할을 하는 인터페이스 DrawAPI 인터페이스와 DrawAPI 인터페이스를 구현하는 구체적인 클래스 RedCircle , GreenCircle 이 있습니다. Shape 는 추상 클래스이며 DrawAPI 객체를 사용합니다 . BridgePatternDemo , 데모 클래스는 Shape 클래스를 사용하여 다른 색상의 원을 그립니다.
 */
public class BridgePatternDemo {
    public static void main(String...args) {
        Shape redCircle = new Circle(100, 100, 10, new RedCircle());
        Shape greenCircle = new Circle(100, 100, 10, new GreenCircle());

        redCircle.draw();
        greenCircle.draw();
    }
}

interface DrawAPI {
    public void drawCircle(int radius, int x, int y);
}

class RedCircle implements DrawAPI {

    @Override
    public void drawCircle(int radius, int x, int y) {
       System.out.println("Drawing Circle [ color: red, radius: " + radius + ", x: " + x + ", y: " + y); 
    }
}

class GreenCircle implements DrawAPI {

    @Override
    public void drawCircle(int radius, int x, int y) {
       System.out.println("Drawing Circle [ color: green, radius: " + radius + ", x: " + x + ", y: " + y); 
    }
}

abstract class Shape {
    protected DrawAPI drawAPI;

    protected Shape(DrawAPI drawAPI){
        this.drawAPI = drawAPI;
    }
    public abstract void draw();
}

class Circle extends Shape {
    private int x, y, radius;

    public Circle(int x, int y, int radius, DrawAPI drawAPI) {
        super(drawAPI);
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    @Override
    public void draw() {
        drawAPI.drawCircle(radius, x, y);
    }

}