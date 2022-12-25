package behavioral.state;

/**
상태 패턴
상태 패턴에서 클래스 동작은 상태에 따라 변경됩니다. 이러한 유형의 디자인 패턴은 동작 패턴에 속합니다.

상태 패턴에서는 다양한 상태를 나타내는 개체와 상태 개체가 변경됨에 따라 동작이 달라지는 컨텍스트 개체를 만듭니다.

구현
동작을 정의하는 State 인터페이스와 State 인터페이스를 구현하는 구체적인 상태 클래스 를 만들 것 입니다. 컨텍스트 는 상태를 전달하는 클래스입니다.

StaePatternDemo , 데모 클래스는 Context 및 상태 개체를 사용하여 상태 유형에 따라 Context 동작의 변화를 보여줍니다.
 */

public class StatePatternDemo {
    public static void main(String...args) {
        Context context = new Context();

        StartState startState = new StartState();
        startState.doAction(context);

        System.out.println(context.getState().toString());

        StopState stopState = new StopState();
        stopState.doAction(context);

        System.out.println(context.getState().toString());

        stopState = new StopState();
        stopState.doAction(context);

        System.out.println(context.getState().toString());
    }    
}

interface State {
    public void doAction(Context context);
}

class StartState implements State {

    @Override
    public void doAction(Context context) {
       System.out.println("Player is in start state"); 
       context.setState(this);
    }

    public String toString() {
        return "Start State";
    }

}

class StopState implements State {

    @Override
    public void doAction(Context context) {
       System.out.println("Player is in stop state"); 
       context.setState(this);
    }

    public String toString() {
        return "Stop State";
    }

}


class Context {
    private State state;

    public Context() {
        state = null;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}