package behavioral.mediator;

import java.util.Date;

/**
중재자 패턴
중재자 패턴은 여러 개체 또는 클래스 간의 통신 복잡성을 줄이는 데 사용됩니다. 이 패턴은 일반적으로 서로 다른 클래스 간의 모든 통신을 처리하고 느슨한 결합을 통해 코드를 쉽게 유지 관리할 수 있도록 지원하는 중재자 클래스를 제공합니다. 중재자 패턴은 행동 패턴 범주에 속합니다.

구현
우리는 여러 사용자가 대화방에 메시지를 보낼 수 있는 대화방의 예를 통해 중재자 패턴을 시연하고 있으며 모든 사용자에게 메시지를 표시하는 것은 대화방의 책임입니다. 우리는 ChatRoom 과 User 라는 두 개의 클래스를 만들었습니다 . 사용자 개체는 ChatRoom 메서드를 사용하여 메시지를 공유합니다.

MediatorPatternDemo , 데모 클래스는 User 개체를 사용하여 그들 간의 통신을 보여줍니다.
 */
public class MediatorPatternDemo {
    public static void main(String...args) {
        User robert = new User("Robert");
        User john = new User("John");

        robert.sendMessage("Hi! John!");
        john.sendMessage("Hello! Robert!");
    }
}

class ChatRoom {
    public static void showMessage(User user, String message) {
        System.out.println(new Date().toString() + " [ " + user.getName() + " ] : "+ message);
    }

}

class User {
    public User(String name) {
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void sendMessage(String message) {
        ChatRoom.showMessage(this, message);
    }
}


