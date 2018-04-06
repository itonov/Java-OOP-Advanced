package logger.appenders;

import logger.ReportLevel;
import logger.interfaces.Appender;
import logger.interfaces.Layout;

public class ConsoleAppender extends BaseAppender implements Appender {
    public ConsoleAppender(Layout layout) {
        super(layout);
    }

    @Override
    public void setLevel(ReportLevel level) {
        super.setLevel(level);
    }

    @Override
    public void append(String message) {
        if (super.getLevel() != null) {
            ReportLevel messageLevel = Enum.valueOf(ReportLevel.class, message.split("\\|")[0]);
            if (super.getLevel().ordinal() <= messageLevel.ordinal()) {
                super.increaseMessages();
                System.out.println(super.getLayout().convertMessage(message));
            }
        } else {
            super.increaseMessages();
            System.out.println(super.getLayout().convertMessage(message));
        }
    }

    @Override
    public String toString() {
        return String.format("Appender type: ConsoleAppender, Layout type: %s, Report level: %s, Messages appended: %d",
                super.getLayout().getClass().getSimpleName(), super.getLevel().name(), super.getMessagesCount());
    }
}
