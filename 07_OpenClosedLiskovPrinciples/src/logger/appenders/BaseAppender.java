package logger.appenders;

import logger.ReportLevel;
import logger.interfaces.Layout;

public abstract class BaseAppender {
    private Layout layout;
    private ReportLevel level;
    private int messagesCount;

    protected BaseAppender(Layout layout) {
        this.layout = layout;
        this.level = Enum.valueOf(ReportLevel.class, "INFO");
        this.messagesCount = 0;
    }

    protected Layout getLayout() {
        return this.layout;
    }

    protected void setLevel(ReportLevel level) {
        this.level = level;
    }

    protected ReportLevel getLevel() {
        return this.level;
    }

    protected int getMessagesCount() {
        return this.messagesCount;
    }

    protected void increaseMessages() {
        this.messagesCount++;
    }
}
