package structural.proxy;
/**
 *프록시 패턴
프록시 패턴에서 클래스는 다른 클래스의 기능을 나타냅니다. 이러한 유형의 디자인 패턴은 구조적 패턴에 속합니다.

프록시 패턴에서 우리는 기능을 외부 세계와 인터페이스하기 위해 원래 개체를 가진 개체를 만듭니다.

구현
Image 인터페이스와 Image 인터페이스를 구현하는 구체적인 클래스 를 만들 것 입니다. ProxyImage 는 RealImage 객체 로딩의 메모리 공간을 줄이기 위한 프록시 클래스입니다.

ProxyPatternDemo , 데모 클래스는 ProxyImage 를 사용하여 필요에 따라 이미지 개체를 로드하고 표시합니다.

 
 */
public class ProxyPatternDemo {

    public static void main(String... args) {
        Image image = new ProxyImage("test_10mb.jpg");

        //image will be loaded form disk
        image.display();
        System.out.println("");
        //image will not be loaded from disk
        image.display();;
    }

}

interface Image {
    void display();
}

class RealImage implements Image {

    private String fileName;

    public RealImage(String fileName) {
        this.fileName = fileName;
        loadFromDisk(fileName);
    }

    private void loadFromDisk(String fileName) {
        System.out.println("Loading " + fileName);
    }

    @Override
    public void display() {
        System.out.println("Displaying " + fileName);
    }

}

class ProxyImage implements Image {

    private RealImage realImage;
    private String fileName;

    public ProxyImage(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(fileName);
        }
        realImage.display();
    }
}
