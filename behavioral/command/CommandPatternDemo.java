package behavioral.command;

import java.util.ArrayList;
import java.util.List;

/**
명령 패턴
명령 패턴은 데이터 기반 설계 패턴이며 동작 패턴 범주에 속합니다. 요청은 개체 아래에 명령으로 래핑되어 호출자 개체로 전달됩니다. 호출자 개체는 이 명령을 처리할 수 있는 적절한 개체를 찾고 해당 개체에 명령을 전달하고 해당 개체가 명령을 실행합니다.

구현
명령 역할을 하는 인터페이스 Order 를 만들었습니다. 요청 역할을 하는 Stock 클래스를 만들었습니다 . 실제 명령 처리를 수행할 주문 인터페이스를 구현하는 구체적인 명령 클래스 BuyStock 및 SellStock 이 있습니다. 호출자 개체 역할을 하는 Broker 클래스 가 생성됩니다. 주문을 받고 주문할 수 있습니다.

브로커 개체는 명령 패턴을 사용하여 명령 유형에 따라 어떤 개체가 어떤 명령을 실행할지 식별합니다. CommandPatternDemo , 데모 클래스는 Broker 클래스를 사용하여 명령 패턴을 시연합니다. 
 */
public class CommandPatternDemo {
    public static void main(String...args) {
        // System.out.println("Hello World!");
        Stock abcStock = new Stock();

        BuyStock buyStockOrder = new BuyStock(abcStock);
        SellStock sellStockOrder = new SellStock(abcStock);

        Broker broker = new Broker();
        broker.takeOrder(buyStockOrder);
        broker.takeOrder(sellStockOrder);

        broker.placeOrder();
    }
}

interface Order {
    void execute();
}

class Stock {
    private String name = "ABC";
    private int quantity = 10;

    public void buy() {
        System.out.println("Stock [ Name: " + name + ", Qyantity: " + quantity + " ] bought");
    }
    public void sell() {
        System.out.println("Stock [ Name: " + name + ", Qyantity: " + quantity + " ] sold");
    }
}

class BuyStock implements Order {
    public BuyStock(Stock abStock) {
        this.abStock = abStock;
    }

    private Stock abStock;

    @Override
    public void execute() {
        abStock.buy();
    }

}

class SellStock implements Order {
    public SellStock(Stock abStock) {
        this.abStock = abStock;
    }

    private Stock abStock;

    @Override
    public void execute() {
        abStock.sell();
    }

}

class Broker {
    private List<Order> orderList = new ArrayList<>();

    public void takeOrder(Order order) {
        orderList.add(order);
    }

    public void placeOrder() {
        for(Order order : orderList) {
            order.execute();
        }

        orderList.clear();
    }
}
