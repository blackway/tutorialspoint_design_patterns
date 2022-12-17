package creational.prototype;

import java.util.Hashtable;
import java.util.Set;

/*
프로토타입 패턴
프로토타입 패턴은 성능을 염두에 두고 복제 객체를 생성하는 것을 말합니다. 이 유형의 디자인 패턴은 객체를 생성하는 가장 좋은 방법 중 하나를 제공하므로 생성 패턴에 속합니다.

이 패턴에는 현재 개체의 복제본을 만들도록 지시하는 프로토타입 인터페이스 구현이 포함됩니다. 이 패턴은 개체를 직접 생성하는 데 비용이 많이 드는 경우에 사용됩니다. 예를 들어, 비용이 많이 드는 데이터베이스 작업 후에 객체가 생성됩니다. 개체를 캐시하고 다음 요청 시 복제본을 반환하며 필요할 때마다 데이터베이스를 업데이트하여 데이터베이스 호출을 줄일 수 있습니다.

구현
추상 클래스인 Shape 와 Shape 클래스를 확장하는 구체적인 클래스 를 만들 것 입니다. ShapeCache 클래스 는 셰이프 개체를 Hashtable 에 저장 하고 요청 시 복제본을 반환하는 다음 단계로 정의됩니다.

PrototypPatternDemo , 데모 클래스는 ShapeCache 클래스를 사용하여 Shape 개체 를 가져옵니다 .
 */

public class PrototypePatternDemo {
    public static void main(String... args) {
        ShapeCache.loadCache();

        // Shape clonedShape = (Shape) ShapeCache.getShape("1");
        // System.out.println("Shape : " + clonedShape.getType());
        // clonedShape.draw();

        Hashtable<String, Shape> shapeMap = ShapeCache.getShapeMap();
        Set<String> keys = shapeMap.keySet();

        keys.stream().forEach(shapeId -> {

            Shape clonedShape = (Shape) ShapeCache.getShape(shapeId);
            System.out.println("Shape : " + clonedShape.getType());
            clonedShape.draw();
        });

    }
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

class Rectangle extends Shape {

    public Rectangle() {
        type = "Rectangle";
    }

    @Override
    void draw() {
        System.out.println("Inside rectangle::draw() method.");
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
        System.out.println("Inside Circle::draw() method.");
    }
}

class ShapeCache {

    private static Hashtable<String, Shape> shapeMap = new Hashtable<>();

    public static Hashtable<String, Shape> getShapeMap() {
        return shapeMap;
    }

    public static Shape getShape(String shapeId) {
        Shape cachedShape = shapeMap.get(shapeId);
        System.out.println("ShapeCache.getShape : " + cachedShape.type.toString());
        return (Shape) cachedShape.clone();
    }

    // for each shape run database query and create shape
    // shapeMap.put(shapeKey, shape);
    // for example, we are adding three shapes
    public static void loadCache() {
        System.out.println("loadCache start");
        Circle circle = new Circle();
        circle.setId("1");
        shapeMap.put(circle.getId(), circle);

        Square square = new Square();
        square.setId("2");
        shapeMap.put(square.getId(), square);

        Rectangle rectangle = new Rectangle();
        rectangle.setId("3");
        shapeMap.put(rectangle.getId(), rectangle);
        System.out.println("loadCache end");
    }

}