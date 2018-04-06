package logger.appenders;

import logger.ReportLevel;
import logger.interfaces.Appender;
import logger.interfaces.File;
import logger.interfaces.Layout;

public class FileAppender extends BaseAppender implements Appender {
    private File file;

    public FileAppender(Layout layout, File file) {
        super(layout);
        this.file = file;
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
                this.file.write(super.getLayout().convertMessage(message));
            }
        } else {
            super.increaseMessages();
            this.file.write(super.getLayout().convertMessage(message));
        }
    }

    @Override
    public String toString() {
        return String.format("Appender type: FileAppender, Layout type: %s, Report level: %s, Messages appended: %d" +
                        ", File size: %d", super.getLayout().getClass().getSimpleName(), super.getLevel().name(),
                super.getMessagesCount(), this.file.getSize());
    }
}
