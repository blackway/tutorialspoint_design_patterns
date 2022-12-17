package creational;

/*
싱글톤 패턴
싱글톤 패턴은 Java에서 가장 간단한 디자인 패턴 중 하나입니다. 이 유형의 디자인 패턴은 객체를 생성하는 가장 좋은 방법 중 하나를 제공하므로 생성 패턴에 속합니다.

이 패턴에는 단일 객체만 생성되도록 하면서 자체 객체를 생성하는 단일 클래스가 포함됩니다. 이 클래스는 클래스의 개체를 인스턴스화할 필요 없이 직접 액세스할 수 있는 유일한 개체에 액세스하는 방법을 제공합니다.

구현
SingleObject 클래스 를 만들 것 입니다. SingleObject 클래스에는 생성자가 private로 있고 정적 인스턴스가 있습니다.

SingleObject 클래스는 정적 인스턴스를 외부 세계로 가져오는 정적 메서드를 제공합니다. SingletonPatternDemo , 데모 클래스는 SingleObject 클래스를 사용하여 SingleObject 객체 를 가져옵니다
 */

public class SignletonPatternDemo {
    public static void main(String...args) {
        //illegal construct
        //Compile Time Error: The constructor SingleObject() is not visible
        //SingleObject object = SingleObject();

        //Get the only object available
        SingleObject object = SingleObject.getInstance();

        //show the message
        object.showMessage();
    }
}


class SingleObject {

    //create an object of SingleObject
    private static SingleObject instance = new SingleObject();

    //make the constructor private so that this class cannot be
    //instantiated
    private SingleObject(){}

    //Get the only object available
    public static SingleObject getInstance() {
        return instance;
    }

    public void showMessage() {
        System.out.println("Hello World!");
    }
}
