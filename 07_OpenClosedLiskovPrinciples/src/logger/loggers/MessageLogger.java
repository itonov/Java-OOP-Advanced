package logger.loggers;

import logger.interfaces.Appender;
import logger.interfaces.Logger;

import java.util.ArrayList;
import java.util.List;

public class MessageLogger implements Logger {
    private List<Appender> appenders;
    private List<String> messages;

    public MessageLogger() {
        this.appenders = new ArrayList<>();
        this.messages = new ArrayList<>();
    }

    @Override
    public void addAppender(Appender appender) {
        this.appenders.add(appender);
    }

    @Override
    public void logMessage(String message) {
        for (Appender appender : this.appenders) {
            appender.append(message);
        }
    }

    @Override
    public void appendMessages() {
        for (String message : this.messages) {
            for (Appender appender : this.appenders) {
                appender.append(message);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Logger info\r\n");
        for (Appender appender : this.appenders) {
            result.append(appender.toString()).append(System.lineSeparator());
        }

        return result.toString();
    }
}
