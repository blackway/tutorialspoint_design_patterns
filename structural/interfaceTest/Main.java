package structural.interfaceTest;

public class Main implements InterfaceTest, 인터페이스 {

    public static void main(String...args){
        InterfaceTest inter = new Main();
        inter.methodInterFace1();
    }
    @Override
    public void methodInterFace1() {
        System.out.println("implement method");
    }
    @Override
    public void methodInterface() {
        // TODO Auto-generated method stub
        
    }

}
