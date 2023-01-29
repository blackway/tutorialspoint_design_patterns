package creational.abstractfactory;

/*
디자인 패턴 - 추상 팩토리 패턴
추상 팩토리 패턴은 다른 팩토리를 생성하는 슈퍼 팩토리 주변에서 작동합니다. 이 공장은 공장 중의 공장이라고도 합니다. 이 유형의 디자인 패턴은 객체를 생성하는 가장 좋은 방법 중 하나를 제공하므로 생성 패턴에 속합니다.

추상 팩토리 패턴에서 인터페이스는 클래스를 명시적으로 지정하지 않고 관련 객체의 팩토리를 생성하는 역할을 합니다. 생성된 각 팩토리는 팩토리 패턴에 따라 객체를 제공할 수 있습니다.

구현
우리는 Shape 인터페이스와 이를 구현하는 구체적인 클래스를 만들 것입니다. 다음 단계로 추상 팩토리 클래스인 AbstractFactory를 생성합니다. AbstractFactory를 확장하는 팩토리 클래스 ShapeFactory가 정의됩니다. 팩토리 생성기/생성기 클래스 FactoryProducer가 생성됩니다.

AbstractFactoryPatternDemo, 데모 클래스는 FactoryProducer를 사용하여 AbstractFactory 개체를 가져옵니다. 필요한 객체 유형을 얻기 위해 AbstractFactory에 정보(모양에 대한 CIRCLE / RECTANGLE / SQUARE)를 전달합니다.


 */
public class AbstractFactoryPatternDemo {
    public static void main(String...args) {
      //get shape factory
      AbstractFactory shapeFactory = FactoryProducer.getFactory(false);
      //get an object of Shape Rectangle
      Shape shape1 = shapeFactory.getShape("RECTANGLE");
      //call draw method of Shape Rectangle
      shape1.draw();
      //get an object of Shape Square 
      Shape shape2 = shapeFactory.getShape("SQUARE");
      //call draw method of Shape Square
      shape2.draw();
      //get shape factory
      AbstractFactory shapeFactory1 = FactoryProducer.getFactory(true);
      //get an object of Shape Rectangle
      Shape shape3 = shapeFactory1.getShape("RECTANGLE");
      //call draw method of Shape Rectangle
      shape3.draw();
      //get an object of Shape Square 
      Shape shape4 = shapeFactory1.getShape("SQUARE");
      //call draw method of Shape Square
      shape4.draw();
    }
}

interface Shape {
    void draw();
}

class Rectangle implements Shape {

    @Override
    public void draw() {
       System.out.println("Inside Rectangle::draw() method"); 
    }
}

class Square implements Shape {

    @Override
    public void draw() {
       System.out.println("Inside Square::draw() method"); 
    }
}

class Circle implements Shape {

    @Override
    public void draw() {
       System.out.println("Inside Circle::draw() method"); 
    }
}

class RoundedRectangle implements Shape {

    @Override
    public void draw() {
       System.out.println("Inside RoundedRectangle::draw() method"); 
    }
}

class RoundedSquare implements Shape {

    @Override
    public void draw() {
       System.out.println("Inside RoundedSquare::draw() method"); 
    }
}

abstract class AbstractFactory {
    abstract Shape getShape(String shapeType);
}

class ShapeFactory extends AbstractFactory {

    @Override
    Shape getShape(String shapeType) {
        if(shapeType.equalsIgnoreCase("RECTANGLE")){
            return new Rectangle();
        } else if(shapeType.equalsIgnoreCase("SQUARE")) {
            return new Square();
        }
        return null;
    }
}

class RoundedShapeFactory extends AbstractFactory {

    @Override
    Shape getShape(String shapeType) {
        if(shapeType.equalsIgnoreCase("RECTANGLE")){
            return new RoundedRectangle();
        } else if(shapeType.equalsIgnoreCase("SQUARE")) {
            return new RoundedSquare();
        }
        return null;
    }
}

class FactoryProducer {
    public static AbstractFactory getFactory(boolean rounded) {
        if(rounded) {
            return new RoundedShapeFactory();
        } else {
            return new ShapeFactory();
        }
    }
}




