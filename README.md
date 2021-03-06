# tutorialspoint_design_patterns

1.디자인 패턴 책 중에 내게 맞는 책이 없어서 만듬.
1.1.서점에 있는 책들은 디자인 패턴이 어떨때 쓰는지 인지 하기 쉽게 내용을 써낸 책이 없음.

https://www.journaldev.com/1827/java-design-patterns-example-tutorial#behavioral-patterns
에서 내용을 구글 자동번역의 내용을 기초로 함.



내 생각에는 만들어진 운영 시스템 개발자(SM) 이지만 디자인 패턴을 공부 하려는 사람은 아래와 같이 일반적인 학습 방법을 거꾸로 해야 한다 생각한다.
그래야 바로 실무에 구현 되어 있는 소스를 조합 하여 쓸수 있다.
대부분의 운영 시스템은 기초가 되는 여러 기능들은 대부분은 구현 되어 있다.

1.행동 디자인 패턴
2.구조적 디자인 패턴
3.생성 디자인 패턴


1.행동 디자인 패턴
행동 패턴은 개체 간의 더 나은 상호 작용을 위한 솔루션과 쉽게 확장할 수 있는 결합 및 유연성을 제공하는 방법을 제공합니다.


    1. 템플릿 메소드 패턴
    템플릿 메서드는 행동 디자인 패턴이며 메서드 스텁을 만들고 일부 구현 단계를 하위 클래스로 연기하는 데 사용됩니다. 템플릿 메서드는 알고리즘을 실행하는 단계를 정의하고 모든 또는 일부 하위 클래스에 공통적일 수 있는 기본 구현을 제공할 수 있습니다.


    집을 짓는 알고리즘을 제공한다고 가정해 봅시다. 집을 짓기 위해 수행해야 하는 단계는 기초 만들기, 기둥 만들기, 벽 만들기, 창문 만들기입니다. 중요한 점은 기초를 만들기 전에 창을 만들 수 없기 때문에 실행 순서를 변경할 수 없다는 것입니다. 따라서 이 경우 다른 방법을 사용하여 집을 짓는 템플릿 방법을 만들 수 있습니다. 예제 프로그램에 대한 구현 세부 정보는 템플릿 메서드 패턴 게시물을 확인하세요 .
    템플릿 메소드는 행동 디자인 패턴 입니다. 템플릿 메서드 디자인 패턴은 메서드 스텁을 만들고 일부 구현 단계를 하위 클래스로 연기하는 데 사용됩니다.

        템플릿 메소드 디자인 패턴
        템플릿 메서드는 알고리즘을 실행하는 단계를 정의하고 모든 또는 일부 하위 클래스에 공통적일 수 있는 기본 구현을 제공할 수 있습니다.


        예를 들어 이 패턴을 이해하고 집을 짓는 알고리즘을 제공한다고 가정해 보겠습니다. 집을 짓기 위해 수행해야 하는 단계는 기초 만들기, 기둥 만들기, 벽과 창문 만들기입니다. 중요한 점은 기초를 만들기 전에 창을 만들 수 없기 때문에 실행 순서를 변경할 수 없다는 것입니다. 따라서 이 경우 다른 방법을 사용하여 집을 짓는 템플릿 방법을 만들 수 있습니다.

        이제 집의 기초를 짓는 것은 목조 주택이든 유리 주택이든 모든 유형의 집에서 동일합니다. 따라서 이를 위한 기본 구현을 제공할 수 있습니다. 하위 클래스가 이 메서드를 재정의하려는 경우 가능하지만 대부분 모든 유형의 주택에 공통적입니다.

        서브클래스가 템플릿 메서드를 재정의하지 않도록 하려면 최종 메서드로 만들어야 합니다.

        
        템플릿 메서드 추상 클래스
        일부 메소드가 서브클래스에 의해 구현되기를 원하기 때문에 기본 클래스를 추상 클래스 로 만들어야 합니다 .

    2. 중재자 패턴
    중재자 디자인 패턴은 시스템의 서로 다른 개체 간에 중앙 집중식 통신 매체를 제공하는 데 사용됩니다. 중재자 디자인 패턴은 여러 개체가 서로 상호 작용하는 엔터프라이즈 응용 프로그램에서 매우 유용합니다. 개체가 서로 직접 상호 작용하면 시스템 구성 요소가 서로 밀접하게 결합되어 유지 관리 비용이 높아지고 쉽게 확장할 수 없습니다. 중재자 패턴은 통신을 위한 개체 간의 중재자를 제공하고 개체 간의 손실 결합을 구현하는 데 중점을 둡니다.

    항공 교통 관제사는 공항 관제실이 서로 다른 항공편 간의 통신을 위한 중재자 역할을 하는 중재자 패턴의 좋은 예입니다. 중재자는 개체 간의 라우터 역할을 하며 자체 논리를 사용하여 통신 방법을 제공할 수 있습니다. 예제 프로그램으로 구현 세부 사항은 중재자 패턴 게시물을 확인하세요 .

    3. 책임의 사슬 패턴
    책임 체인 패턴은 클라이언트의 요청이 처리하기 위해 객체 체인으로 전달되는 소프트웨어 설계에서 느슨한 결합을 달성하는 데 사용됩니다. 그런 다음 체인의 개체는 요청을 처리할 사람과 요청이 체인의 다음 개체로 전송되어야 하는지 여부를 결정합니다.

    try-catch 블록 코드에 여러 catch 블록이 있을 수 있다는 것을 알고 있습니다. 여기에서 모든 catch 블록은 특정 예외를 처리하는 일종의 프로세서입니다. 따라서 try 블록에서 예외가 발생하면 처리할 첫 번째 catch 블록으로 전송됩니다. catch 블록이 이를 처리할 수 없으면 체인의 다음 개체, 즉 다음 catch 블록으로 요청을 전달합니다. 마지막 catch 블록에서도 처리할 수 없으면 호출 프로그램에 대한 체인 외부에서 예외가 throw됩니다.


    ATM 분배기 로직은 Chain of Responsibility Pattern을 사용하여 구현할 수 있습니다 . 링크된 게시물을 확인하세요.

    4. 관찰자 패턴
    관찰자 디자인 패턴은 개체의 상태에 관심이 있고 변경 사항이 있을 때마다 알림을 받고 싶을 때 유용합니다. 옵저버 패턴에서 다른 객체의 상태를 감시하는 객체를 Observer 라고 하고 감시 중인 객체를 Subject 라고 합니다.

    Java는 java.util.Observable 클래스와 java.util.Observer 인터페이스를 통해 Observer 패턴을 구현하기 위한 내장 플랫폼을 제공합니다. 그러나 구현이 정말 간단하고 대부분의 경우 Java가 클래스에서 다중 상속을 제공하지 않기 때문에 Observer 패턴을 구현하기 위해 클래스를 확장하고 싶지 않기 때문에 널리 사용되지 않습니다.

    JMS(Java Message Service)는 중재자 패턴과 함께 관찰자 패턴을 사용하여 애플리케이션이 데이터를 구독하고 다른 애플리케이션에 게시할 수 있도록 합니다. 구현 세부 정보 및 예제 프로그램은 Observer Pattern 게시물을 확인하세요 .

    5. 전략 패턴
    전략 패턴은 특정 작업에 대해 여러 알고리즘이 있고 클라이언트가 런타임에 실제 구현을 결정할 때 사용됩니다.


    전략 패턴은 정책 패턴이라고도 합니다. 우리는 여러 알고리즘을 정의하고 클라이언트 애플리케이션이 매개변수로 사용할 알고리즘을 전달하도록 합니다. 이 패턴의 가장 좋은 예 중 하나는 Comparator 매개변수를 사용하는 Collections.sort() 메서드입니다. Comparator 인터페이스의 다양한 구현을 기반으로 객체는 다양한 방식으로 정렬됩니다.

    구현 세부 정보 및 예제 프로그램은 전략 패턴 게시물을 확인하세요 .


    6. 명령 패턴
    명령 패턴은 요청-응답 모델에서 결합 손실을 구현하는 데 사용됩니다. 명령 패턴에서 요청은 호출자에게 전송되고 호출자 는 이를 캡슐화된 명령 개체에 전달합니다. Command 개체는 특정 작업을 수행하기 위해 Receiver 의 적절한 메서드에 요청을 전달합니다 .

    파일을 열고 쓰고 닫는 방법이 있는 파일 시스템 유틸리티를 제공하고 Windows 및 Unix와 같은 여러 운영 체제를 지원해야 한다고 가정해 보겠습니다.


    파일 시스템 유틸리티를 구현하려면 먼저 실제로 모든 작업을 수행할 수신기 클래스를 만들어야 합니다. Java 인터페이스 측면에서 코딩하기 때문에 FileSystemReceiver 인터페이스를 가질 수 있으며 Windows, Unix, Solaris 등과 같은 다양한 운영 체제 버전에 대한 구현 클래스입니다 . 예제 프로그램과 함께 구현 세부 사항은 Command Pattern 게시물을 확인하십시오.


    7. 상태 패턴
    상태 디자인 패턴은 개체가 내부 상태에 따라 동작을 변경할 때 사용됩니다.

    상태에 따라 개체의 동작을 변경해야 하는 경우 개체에 상태 변수가 있고 if-else 조건 블록을 사용하여 상태에 따라 다른 작업을 수행할 수 있습니다. 상태 패턴은 컨텍스트 및 상태 구현을 통해 이를 달성하기 위해 체계적이고 느슨하게 결합된 방법을 제공하는 데 사용됩니다.

    예제 프로그램으로 구현 세부 정보는 State Pattern 게시물을 확인하세요 .



    8. 방문자 패턴
    방문자 패턴은 유사한 종류의 개체 그룹에 대해 작업을 수행해야 할 때 사용됩니다. 방문자 패턴의 도움으로 운영 논리를 개체에서 다른 클래스로 이동할 수 있습니다.

    예를 들어, 다른 유형의 항목(요소)을 추가할 수 있는 장바구니를 생각하면 결제 버튼을 클릭하면 지불할 총 금액이 계산됩니다. 이제 항목 클래스에 계산 논리를 사용하거나 방문자 패턴을 사용하여 이 논리를 다른 클래스로 이동할 수 있습니다. 방문자 패턴의 예에서 이것을 구현해 보겠습니다. 구현 세부 정보는 방문자 패턴 게시물을 확인 하세요.

    9. 통역사 패턴
    언어에 대한 문법적 표현을 정의하는 데 사용되며 이 문법을 처리하는 인터프리터를 제공합니다.

    이 패턴의 가장 좋은 예는 자바 소스 코드를 JVM이 이해할 수 있는 바이트 코드로 해석하는 자바 컴파일러입니다. Google 번역기는 입력이 모든 언어로 가능하고 출력을 다른 언어로 해석할 수 있는 인터프리터 패턴의 예이기도 합니다.


    예제 프로그램에 대한 인터프리터 패턴 게시물을 확인하십시오 .


    10. 반복자 패턴
    행동 패턴 중 하나의 반복자 패턴이며 개체 그룹을 순회하는 표준 방법을 제공하는 데 사용됩니다. Iterator 패턴은 Iterator 인터페이스가 컬렉션을 순회하는 메서드를 제공하는 Java Collection Framework 에서 널리 사용됩니다 .

    반복자 패턴은 컬렉션을 순회하는 것뿐만 아니라 요구 사항에 따라 다양한 종류의 반복자를 제공할 수도 있습니다. 반복자 패턴은 컬렉션을 통한 실제 순회 구현을 숨기고 클라이언트 프로그램은 반복자 메서드만 사용합니다. 예제 프로그램 및 구현 세부 정보는 Iterator Pattern 게시물을 확인 하세요.



    11. 유품 패턴
    메멘토 디자인 패턴은 나중에 복원할 수 있도록 객체의 상태를 저장하고 싶을 때 사용합니다. Memento 패턴은 객체의 저장된 상태 데이터가 객체 외부에서 액세스할 수 없는 방식으로 이를 구현하는 데 사용되며, 이는 저장된 상태 데이터의 무결성을 보호합니다.

    Memento 패턴은 Originator와 Caretaker의 두 객체로 구현됩니다. 발신자는 상태를 저장하고 복원해야 하는 객체이며 내부 클래스를 사용하여 객체의 상태를 저장합니다. 내부 클래스는 Memento라고 하며 private이므로 다른 개체에서 액세스할 수 없습니다.

    샘플 프로그램 및 구현 세부 사항은 Memento Pattern 을 확인 하십시오.


기타 디자인 패턴
GoF 디자인 패턴에 포함되지 않는 디자인 패턴이 많이 있습니다. 이러한 인기 있는 디자인 패턴 중 일부를 살펴보겠습니다.



    1. DAO 디자인 패턴
    DAO 디자인 패턴은 데이터 지속성 로직을 별도의 레이어로 분리하는 데 사용됩니다. DAO는 데이터베이스와 함께 작동하도록 시스템을 설계할 때 매우 인기 있는 패턴입니다. 아이디어는 서비스 계층을 데이터 액세스 계층과 분리된 상태로 유지하는 것입니다. 이런 식으로 우리는 애플리케이션에서 로직 분리를 구현합니다.

    자세한 내용과 예제 프로그램은 DAO 패턴을 확인 하세요 .


    2. 의존성 주입 패턴
    종속성 주입을 사용하면 하드 코딩된 종속성을 제거하고 애플리케이션을 느슨하게 연결하고 확장 가능하며 유지 관리할 수 있습니다. 컴파일 타임에서 런타임으로 의존성 해결을 이동하기 위해 자바에서 의존성 주입을 구현할 수 있습니다. Spring 프레임워크는 의존성 주입의 원칙에 따라 구축됩니다.

    Java 애플리케이션에서 구현하는 방법을 이해하려면 종속성 주입 패턴 에 대해 자세히 읽어보세요 .


    3. MVC 패턴
    MVC 패턴은 웹 애플리케이션을 만들기 위한 가장 오래된 아키텍처 패턴 중 하나입니다. MVC는 Model-View-Controller의 약자입니다.

    자세한 내용과 전체 예제 코드는 MVC 패턴을 확인 하세요 .

    이것이 Java의 다양한 디자인 패턴에 대한 것입니다. 이 게시물의 의도는 모두 쉽게 탐색할 수 있는 색인을 제공하는 것입니다. [no_toc]



구조적 디자인 패턴
구조 패턴은 클래스 구조를 만드는 다양한 방법을 제공합니다. 예를 들어 상속 및 구성을 사용하여 작은 개체에서 큰 개체를 만드는 것과 같은 방법입니다.


    1. 어댑터 패턴
    어댑터 디자인 패턴은 구조적 디자인 패턴 중 하나로 관련이 없는 두 개의 인터페이스가 함께 작동할 수 있도록 하기 위해 사용됩니다. 이러한 관련 없는 인터페이스를 결합하는 개체를 어댑터라고 합니다. 실제 사례로 모바일 충전기를 어댑터로 생각할 수 있습니다. 모바일 배터리는 충전하는 데 3볼트가 필요하지만 일반 소켓은 120V(미국) 또는 240V(인도)를 생성하기 때문입니다. 따라서 모바일 충전기는 모바일 충전 소켓과 벽면 소켓 사이의 어댑터 역할을 합니다. 예제 프로그램과 Java에서의 사용법에 대한 어댑터 패턴 을 확인하십시오 .

    1. 복합 패턴
    복합 패턴은 구조적 디자인 패턴 중 하나로 부분-전체 계층 구조를 표현해야 할 때 사용됩니다. 구조의 객체를 동일한 방식으로 처리해야 하는 방식으로 구조를 생성해야 하는 경우 복합 디자인 패턴을 적용할 수 있습니다.


    실생활의 예를 들어 이해해보자 - 다이어그램은 Circle, Lines, Triangle 등과 같은 Object로 구성된 구조이며, 도면을 색상(예: Red)으로 채울 때 Object에도 동일한 색상이 적용됩니다. 도면에서. 여기서 도면은 서로 다른 부분으로 구성되며 모두 동일한 작업을 수행합니다. 복합 패턴 및 예제 프로그램의 다른 구성 요소에 대한 복합 패턴 기사를 확인하십시오 .

    1. 프록시 패턴
    프록시 패턴의 의도는 "다른 개체가 액세스를 제어할 수 있도록 대리 또는 자리 표시자를 제공"하는 것입니다. 정의 자체는 매우 명확하며 기능에 대한 제어된 액세스를 제공하려는 경우 프록시 패턴이 사용됩니다.

    시스템에서 일부 명령을 실행할 수 있는 클래스가 있다고 가정해 보겠습니다. 이제 우리가 그것을 사용한다면 문제가 없지만 이 프로그램을 클라이언트 응용 프로그램에 제공하려는 경우 클라이언트 프로그램이 일부 시스템 파일을 삭제하거나 원하지 않는 일부 설정을 변경하는 명령을 실행할 수 있기 때문에 심각한 문제가 발생할 수 있습니다. . 구현 세부 정보가 포함된 예제 프로그램에 대한 프록시 패턴 게시물을 확인 하세요.


    1. 플라이웨이트 패턴
    플라이웨이트 디자인 패턴은 클래스의 많은 객체를 생성해야 할 때 사용됩니다. 모든 객체는 모바일 기기나 임베디드 시스템과 같이 메모리가 부족한 기기에 매우 중요한 메모리 공간을 사용하므로, 객체 공유를 통해 메모리 부하를 줄이기 위해 플라이웨이트 설계 패턴을 적용할 수 있습니다. 자바에서의 스트링 풀 구현은 플라이웨이트 패턴 구현의 가장 좋은 예 중 하나이다. 샘플 프로그램 및 구현 프로세스는 플라이웨이트 패턴 문서를 확인하세요 .


    1. 외관 패턴
    Facade Pattern은 클라이언트 애플리케이션이 시스템과 쉽게 상호 작용할 수 있도록 돕는 데 사용됩니다. MySql/Oracle 데이터베이스를 사용하고 HTML 보고서, PDF 보고서 등과 같은 다양한 유형의 보고서를 생성하기 위한 인터페이스 세트가 있는 애플리케이션이 있다고 가정합니다. 따라서 다른 유형의 데이터베이스와 작업하기 위한 다른 인터페이스 세트가 있습니다 . 이제 클라이언트 응용 프로그램은 이러한 인터페이스를 사용하여 필요한 데이터베이스 연결을 얻고 보고서를 생성할 수 있습니다. 그러나 복잡성이 증가하거나 인터페이스 동작 이름이 혼동되면 클라이언트 응용 프로그램에서 이를 관리하기가 어렵습니다. 그래서 우리는 여기에 Facade 패턴을 적용하고 클라이언트 애플리케이션을 돕기 위해 기존 인터페이스 위에 래퍼 인터페이스를 제공할 수 있습니다. 구현 세부 정보 및 샘플 프로그램은 Facade Pattern 게시물을 확인하세요 .


    1. 브리지 패턴
    인터페이스와 구현 모두에 인터페이스 계층이 있는 경우 브리지 디자인 패턴을 사용하여 인터페이스를 구현에서 분리하고 클라이언트 프로그램에서 구현 세부 정보를 숨깁니다. 어댑터 패턴과 마찬가지로 구조적 디자인 패턴 중 하나입니다.

    브리지 디자인 패턴의 구현은 상속보다 구성을 선호한다는 개념을 따릅니다. 구현 세부 정보 및 샘플 프로그램은 Bridge Pattern 게시물을 확인하세요 .

    1. 데코레이터 패턴
    데코레이터 디자인 패턴은 런타임에 개체의 기능을 수정하는 데 사용됩니다. 동시에 같은 클래스의 다른 인스턴스는 이것의 영향을 받지 않으므로 개별 개체는 수정된 동작을 얻습니다. 데코레이터 디자인 패턴은 구조적 디자인 패턴(예: 어댑터 패턴, 브리지 패턴, 복합 패턴) 중 하나로 추상 클래스를 사용하거나 컴포지션과의 인터페이스를 사용하여 구현합니다.


    상속이나 구성을 사용하여 개체의 동작을 확장하지만 이것은 컴파일 타임에 수행되며 클래스의 모든 인스턴스에 적용할 수 있습니다. 런타임에 기존 동작을 제거하기 위해 새로운 기능을 추가할 수 없습니다. 바로 이 때 Decorator 패턴이 나타납니다. 샘플 프로그램 및 구현 세부 정보는 데코레이터 패턴 게시물을 확인 하세요.



생성디자인 패턴
생성 디자인 패턴은 특정 상황에 가장 적합한 방법으로 개체를 인스턴스화하는 솔루션을 제공합니다.


    1. 싱글톤 패턴
    싱글톤 패턴은 클래스의 인스턴스화를 제한하고 클래스의 하나의 인스턴스만 Java 가상 머신에 존재하도록 합니다. 아주 단순한 디자인 패턴처럼 보이지만 구현에 있어서는 구현에 대한 고민이 많다. 싱글톤 패턴의 구현은 항상 개발자들 사이에서 논쟁의 여지가 있는 주제였습니다. Singleton 패턴을 구현하는 다양한 방법과 각 방법의 장단점에 대해 알아보려면 Singleton 디자인 패턴 을 확인하세요 . 이것은 가장 많이 논의되는 Java 디자인 패턴 중 하나입니다.


    2. 공장 패턴
    팩토리 디자인 패턴은 여러 하위 클래스가 있는 수퍼 클래스가 있고 입력에 따라 하위 클래스 중 하나를 반환해야 할 때 사용됩니다. 이 패턴은 클라이언트 프로그램에서 팩토리 클래스로 클래스 인스턴스화의 책임을 집니다. 팩토리 클래스에 싱글톤 패턴을 적용하거나 팩토리 메소드를 정적으로 만들 수 있습니다. 예제 프로그램 및 팩토리 패턴 이점에 대해서는 팩토리 디자인 패턴 을 확인하십시오 . 이것은 가장 널리 사용되는 Java 디자인 패턴 중 하나입니다.


    3. 추상 팩토리 패턴
    Abstract Factory 패턴은 Factory 패턴과 유사하며 팩토리의 팩토리입니다. 자바의 팩토리 디자인 패턴에 익숙하다면 제공된 입력을 기반으로 다른 하위 클래스를 반환하는 단일 팩토리 클래스가 있고 이를 달성하기 위해 팩토리 클래스가 if-else 또는 switch 문을 사용한다는 것을 알 수 있습니다.

    Abstract Factory 패턴에서 우리는 if-else 블록을 제거하고 각 하위 클래스에 대한 팩토리 클래스와 입력 팩토리 클래스를 기반으로 하위 클래스를 반환할 추상 팩토리 클래스를 갖습니다. 이 패턴을 예제 프로그램으로 구현하는 방법을 알아 보려면 추상 팩토리 패턴 을 확인하십시오 .

    4. 빌더 패턴
    이 패턴은 Object가 많은 속성을 포함할 때 Factory 및 Abstract Factory 디자인 패턴의 일부 문제를 해결하기 위해 도입되었습니다. 빌더 패턴은 객체를 단계별로 빌드하는 방법을 제공하고 실제로 최종 객체를 반환하는 메서드를 제공하여 많은 수의 선택적 매개변수와 일관성 없는 상태 문제를 해결합니다. JDK에서 사용되는 예제 프로그램과 클래스는 Builder Pattern 을 확인하세요 .<

    5. 프로토타입 패턴
    프로토타입 패턴은 객체 생성에 비용이 많이 들고 많은 시간과 리소스가 필요하고 유사한 객체가 이미 존재하는 경우에 사용됩니다. 따라서 이 패턴은 원본 개체를 새 개체에 복사한 다음 필요에 따라 수정하는 메커니즘을 제공합니다. 이 패턴은 자바 복제를 사용하여 객체를 복사합니다.

    프로토타입 디자인 패턴은 복사하려는 개체가 복사 기능을 제공해야 한다고 규정합니다. 다른 클래스에서 하면 안 됩니다. 그러나 Object 속성의 얕은 복사본을 사용할지 깊은 복사본 을 사용할지 여부 는 요구 사항에 따라 다르며 디자인 결정 사항입니다. 샘플 프로그램은 프로토타입 패턴 을 확인하세요 .




