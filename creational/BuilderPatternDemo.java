package creational;

import java.util.ArrayList;
import java.util.List;


/*
빌더 패턴
빌더 패턴은 간단한 객체를 사용하고 단계별 접근 방식을 사용하여 복잡한 객체를 빌드합니다. 이 유형의 디자인 패턴은 객체를 생성하는 가장 좋은 방법 중 하나를 제공하므로 생성 패턴에 속합니다.

Builder 클래스는 최종 개체를 단계별로 빌드합니다. 이 빌더는 다른 개체와 독립적입니다.

구현
일반적인 식사가 버거와 차가운 음료가 될 수 있는 패스트푸드점의 비즈니스 사례를 고려했습니다. 버거는 채식 버거 또는 치킨 버거일 수 있으며 포장지로 포장됩니다. 차가운 음료는 콜라나 펩시가 될 수 있으며 병에 포장됩니다.

우리는 햄버거와 차가운 음료수와 같은 식품 항목을 나타내는 항목 인터페이스와 항목 인터페이스를 구현하는 구체적인 클래스 , 음식 항목 의 패키징을 나타내는 Packing 인터페이스 및 햄버거가 래퍼와 콜드에 포장될 때 Packing 인터페이스를 구현 하는 구체적인 클래스를 만들 것입니다. 음료는 병으로 포장됩니다.

그런 다음 Item 의 ArrayList 와 MealBuilder 를 갖는 Meal 클래스를 생성하여 Item 을 결합 하여 다양한 유형의 Meal 객체 를 빌드합니다 . BuilderPatternDemo , 데모 클래스는 MealBuilder 를 사용하여 Meal 을 빌드합니다 .
*/

public class BuilderPatternDemo {
    public static void main(String...args) {
        MealBuilder mealBuilder = new MealBuilder();

        Meal vegMeal = mealBuilder.prepareVegMeal();
        System.out.println("Veg Meal");
        vegMeal.showItems();
        System.out.println("Toal Cost: " + vegMeal.getCost());
    }
}

interface Item {
    public String name();
    public Packing packing();
    public float price();
}

interface Packing {
    public String pack();
}

class Wrapper implements Packing {

    @Override
    public String pack() {
        return "Wrapper";
    }
}

class Bottle implements Packing {

   @Override
   public String pack() {
      return "Bottle";
   }
}

abstract class Burger implements Item {

    @Override
    public Packing packing() {
        return new Wrapper();
    }

    @Override
    public abstract float price();
}

abstract class ColdDrink implements Item {

    @Override
    public Packing packing() {
        return new Bottle();
    }

    @Override
    public abstract float price();
}

class VegBurger extends Burger {

    @Override
    public float price() {
        return 25.0f;
    }

    @Override
    public String name() {
        return "Veg Burder";
    }
}

class Coke extends ColdDrink {

   @Override
   public float price() {
      return 30.0f;
   }

   @Override
   public String name() {
      return "Coke";
   }
}


class Meal {
    private List<Item> items = new ArrayList<Item>();

    public void addItem(Item item) {
        items.add(item);
    }

    public float getCost() {
        float cost = 0.0f;
        
        for(Item item: items){
            cost += item.price();
        }
        return cost;
    }

    public void showItems() {
        for(Item item: items) {
            System.out.println("Item : "+item.name());
            System.out.println(", Packing : " +item.packing().pack());
            System.out.println(", Price : "+item.price());
        }
    }

}

class MealBuilder {
    public Meal prepareVegMeal() {
        Meal meal = new Meal();
        meal.addItem(new VegBurger());
        meal.addItem(new Coke());
        return meal;
    }
}

