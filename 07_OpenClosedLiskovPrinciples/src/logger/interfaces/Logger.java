package logger.interfaces;

public interface Logger {
    void addAppender(Appender appender);

    void logMessage(String message);

    void appendMessages();
}
