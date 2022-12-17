package behavioral.strategy;

/*
전략 패턴
전략 패턴에서 클래스 동작 또는 해당 알고리즘은 런타임에 변경할 수 있습니다. 이러한 유형의 디자인 패턴은 동작 패턴에 속합니다.

전략 패턴에서는 다양한 전략을 나타내는 개체와 전략 개체에 따라 동작이 달라지는 컨텍스트 개체를 만듭니다. 전략 개체는 컨텍스트 개체의 실행 알고리즘을 변경합니다.

구현
액션을 정의하는 Strategy 인터페이스와 Strategy 인터페이스를 구현하는 구체적인 전략 클래스 를 생성할 것 입니다. 컨텍스트 는 전략을 사용하는 클래스입니다.

StrategyPatternDemo , 데모 클래스는 Context 및 전략 개체를 사용하여 배포하거나 사용하는 전략을 기반으로 Context 행동의 변화를 보여줍니다.
 */

public class StrategyPatternDemo {
    public static void main(String... args) {
        Context context = new Context(new OprationAdd());
        System.out.println("10 + 5 = " + context.executeStrategy(10, 5));
        context = new Context(new OprationSubstract());
        System.out.println("10 - 5 = " + context.executeStrategy(10, 5));
        context = new Context(new OprationMultiply());
        System.out.println("10 * 5 = " + context.executeStrategy(10, 5));
    }

}

class Context {
    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public int executeStrategy(int num1, int num2) {
        return strategy.doOperation(num1, num2);
    }
}

interface Strategy {
    public int doOperation(int num1, int num2);
}

class OprationAdd implements Strategy {

    @Override
    public int doOperation(int num1, int num2) {
        return num1 + num2;
    }
}

class OprationSubstract implements Strategy {

    @Override
    public int doOperation(int num1, int num2) {
        return num1 - num2;
    }
}

class OprationMultiply implements Strategy {

    @Override
    public int doOperation(int num1, int num2) {
        return num1 * num2;
    }

}