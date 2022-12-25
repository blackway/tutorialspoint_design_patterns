package behavioral.interpreter;

/**
통역사 패턴
인터프리터 패턴은 언어 문법이나 표현을 평가하는 방법을 제공합니다. 이러한 유형의 패턴은 행동 패턴에 속합니다. 이 패턴에는 특정 컨텍스트를 해석하도록 지시하는 표현식 인터페이스 구현이 포함됩니다. 이 패턴은 SQL 구문 분석, 기호 처리 엔진 등에 사용됩니다.

구현
Expression 인터페이스와 Expression 인터페이스를 구현하는 구체적인 클래스 를 만들 것 입니다. 해당 컨텍스트의 주요 해석기 역할을 하는 TerminalExpression 클래스 가 정의됩니다. 다른 클래스 OrExpression , AndExpression 은 조합식을 만드는 데 사용됩니다.

InterpreterPatternDemo , 데모 클래스는 Expression 클래스를 사용하여 규칙을 만들고 표현식 구문 분석을 시연합니다.


 */
public class InterpreterPatternDemo {
    public static void main(String...args) {
        Expression isMale = getMaleExpression();
        Expression isMarriedWoman = getMarriedWomanExpression();

        System.out.println("John is male? " + isMale.interpret("John"));
        System.out.println("Julie is a arried women? " + isMarriedWoman.interpret("Married Julie"));
    }

    //Rule: Robert and John are male
    private static Expression getMaleExpression() {
        Expression robert = new TerminalExpression("Robert");
        Expression john = new TerminalExpression("John");
        return new OrExpression(robert, john);
    }
    
    //Rule: Julie is a married women
    private static Expression getMarriedWomanExpression() {
        Expression julie = new TerminalExpression("Julie");
        Expression married = new TerminalExpression("Married");
        return new AndExpression(julie, married);
    }

}

interface Expression {
    public boolean interpret(String context);
}

class TerminalExpression implements Expression {
    private String data;

    public TerminalExpression(String data) {
        this.data = data;
    }

    @Override
    public boolean interpret(String context) {
        System.out.println("context : " + context + ", data : "+data);
        if(context.contains(data)) {
            return true;
        }
        return false;
    }
}

class OrExpression implements Expression {
    public OrExpression(Expression expr1, Expression expr2) {
        this.expr1 = expr1;
        this.expr2 = expr2;
    }


    private Expression expr1, expr2;


    @Override
    public boolean interpret(String context) {
        return expr1.interpret(context) || expr2.interpret(context);
    }
}

class AndExpression implements Expression {
    public AndExpression(Expression expr1, Expression expr2) {
        this.expr1 = expr1;
        this.expr2 = expr2;
    }


    private Expression expr1, expr2;

    @Override
    public boolean interpret(String context) {
        return expr1.interpret(context) && expr2.interpret(context);
    }
}
