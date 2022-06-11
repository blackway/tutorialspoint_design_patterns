package behavioral;

import java.util.ArrayList;
import java.util.List;

interface Order {
    void exeucte();
}

class BuyStock implements Order {
    private Stock stock;

    public BuyStock(Stock stock) {
        this.stock = stock;
    }

    @Override
    public void exeucte() {
       stock.buy(); 
    }
}

class SellStock implements Order {
    private Stock stock;

    public SellStock(Stock stock) {
        this.stock = stock;
    }

    @Override
    public void exeucte() {
       stock.sell(); 
    }
}

class Broker {
    private List<Order> orderList = new ArrayList<Order>();

    public void takeOrder(Order order) {
        orderList.add(order);
    }

    public void placeOrders() {
        for(Order order: orderList) {
            order.exeucte();
        }
        orderList.clear();
    }
}

class Stock {
    private String name = "ABC";
    private int quantity = 10;

    public void buy() {
        System.out.println("Stock [ Name: "+name+", Quantity: "+quantity+" ] bought");
    }

    public void sell() {
        System.out.println("Stock [ Name: "+name+", Quantity: "+quantity+" ] sold");
    }
}




public class CommandPattern {
    public static void main(String...args) {
        System.out.println("hello world! CommandPattern");

        Stock stock = new Stock();


        BuyStock buyStockOrder = new BuyStock(stock);
        SellStock sellStockOrder = new SellStock(stock);

        Broker broker = new Broker();
        broker.takeOrder(buyStockOrder);
        broker.takeOrder(sellStockOrder);

        broker.placeOrders();

    }

}
