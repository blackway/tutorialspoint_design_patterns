package structural.chain;

/**
 * 책임 사슬 패턴
 * 이름에서 알 수 있듯이 책임 체인 패턴은 요청에 대한 수신자 개체 체인을 생성합니다. 이 패턴은 요청 유형에 따라 요청의 발신자와 수신자를
 * 분리합니다. 이 패턴은 행동 패턴에 속합니다.
 * 
 * 이 패턴에서 일반적으로 각 수신자는 다른 수신자에 대한 참조를 포함합니다. 한 객체가 요청을 처리할 수 없으면 다음 수신자에게 동일한
 * 요청을 전달하는 식입니다.
 * 
 * 구현
 * 우리는 로깅 수준을 가진 AbstractLogger 추상 클래스를 만들었습니다. 그런 다음 AbstractLogger 를 확장하는 세 가지
 * 유형의 로거를 만들었습니다 . 각 로거는 메시지 수준을 해당 수준으로 확인하고 그에 따라 인쇄합니다. 그렇지 않으면 메시지를 인쇄하지 않고
 * 다음 로거로 전달합니다.
 * 
 * 
 */
public class ChainPatternDemo {
    public static void main(String... args) {
        AbstractLogger loggerChain = getChainOfLoggers();

        loggerChain.logMessage(AbstractLogger.INFO, "This is an information.");
        loggerChain.logMessage(AbstractLogger.DEBUG, "This is an debug level information.");
        loggerChain.logMessage(AbstractLogger.ERROR, "This is an error information.");
    }

    private static AbstractLogger getChainOfLoggers() {
        AbstractLogger errorLogger = new ErrorLogger(AbstractLogger.ERROR);
        AbstractLogger fileLogger = new FileLogger(AbstractLogger.DEBUG);
        AbstractLogger consoleLogger = new ConsoleLogger(AbstractLogger.INFO);

        errorLogger.setNextLogger(fileLogger);
        fileLogger.setNextLogger(consoleLogger);

        return errorLogger;
    }
}

abstract class AbstractLogger {
    public static int INFO = 1;
    public static int DEBUG = 2;
    public static int ERROR = 3;

    protected int level;

    // next element in chin or reponsibility
    protected AbstractLogger nextLogger;

    public void setNextLogger(AbstractLogger nextLogger) {
        this.nextLogger = nextLogger;
    }

    public void logMessage(int level, String message) {
        if (this.level <= level) {
            write(message);
        }
        if (nextLogger != null) {
            nextLogger.logMessage(level, message);
        }
    }

    abstract protected void write(String message);
}

class ConsoleLogger extends AbstractLogger {

    public ConsoleLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("Standard Console::Logger: " + message);
    }
}

class ErrorLogger extends AbstractLogger {

    public ErrorLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("Error Console::Logger: " + message);
    }
}

class FileLogger extends AbstractLogger {

    public FileLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("File::Logger: " + message);
    }
}
