package creational.fectory;


/*
공장 패턴
팩토리 패턴은 Java에서 가장 많이 사용되는 디자인 패턴 중 하나입니다. 이 유형의 디자인 패턴은 객체를 생성하는 가장 좋은 방법 중 하나를 제공하므로 생성 패턴에 속합니다.

Factory 패턴에서는 생성 로직을 클라이언트에 노출하지 않고 객체를 생성하고 공통 인터페이스를 사용하여 새로 생성된 객체를 참조합니다.

구현
우리는 Shape 인터페이스와 Shape 인터페이스를 구현하는 구체적인 클래스 를 만들 것 입니다. 팩토리 클래스 ShapeFactory 는 다음 단계로 정의됩니다.

FactoryPatternDemo , 데모 클래스는 ShapeFactory 를 사용하여 Shape 개체 를 가져옵니다 . 정보( CIRCLE / RECTANGLE / SQUARE )를 ShapeFactory 에 전달하여 필요한 객체 유형을 가져옵니다. 
 */
public class FactoryPatternDemo {
    public static void main(String...args) {
        ShapeFactory shapeFactory = new ShapeFactory();

        //get an object of Circle and call its draw method.
        Shape shape1 = shapeFactory.getShape("CIRCLE");

        //call  draw method of Circle
        shape1.draw();

        //get an object of Rectangle and call its draw method.
        Shape shape2 = shapeFactory.getShape("RECTANGLE");

        //call draw method of Rectangle
        shape2.draw();

        //get an object of Square and call its draw method.
        Shape shape3 = shapeFactory.getShape("SQUARE");

        //call draw method of square
        shape3.draw();
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

class ShapeFactory {
    //use getShape method to get object of type shape
    public Shape getShape(String shapeType) {
        if(shapeType == null){
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



