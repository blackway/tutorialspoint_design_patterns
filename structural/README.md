# tutorialspoint_design_patterns
데코레이터 패턴을 사용하면 구조를 변경하지 않고 기존 객체에 새로운 기능을 추가할 수 있습니다. 이러한 유형의 디자인 패턴은 이 패턴이 기존 클래스에 대한 래퍼 역할을 하기 때문에 구조적 패턴에 속합니다.

이 패턴은 원래 클래스를 래핑하고 클래스 메서드 서명을 그대로 유지하는 추가 기능을 제공하는 데코레이터 클래스를 만듭니다.

우리는 모양 클래스를 변경하지 않고 모양을 일부 색상으로 장식하는 다음 예제를 통해 데코레이터 패턴의 사용을 시연하고 있습니다.

구현
우리는 Shape 인터페이스와 Shape 인터페이스를 구현하는 구체 클래스 를 만들 것 입니다. 그런 다음 Shape 인터페이스를 구현 하고 인스턴스 변수로 Shape 객체를 갖는 추상 데코레이터 클래스 ShapeDecorator 를 생성합니다.

RedShapeDecorator 는 ShapeDecorator 를 구현하는 구체적인 클래스 입니다.

DecoratorPatternDemo , 데모 클래스는 RedShapeDecorator 를 사용하여 Shape 개체 를 장식 합니다.


![데코레이터 패턴](structural/decorator/decorator_pattern_uml_diagram.jpg)

