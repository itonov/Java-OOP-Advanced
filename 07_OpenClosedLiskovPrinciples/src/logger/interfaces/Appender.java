package logger.interfaces;

import logger.ReportLevel;

public interface Appender {
    void append(String log);

    void setLevel(ReportLevel level);
}
