package logger.layouts;

import logger.interfaces.Layout;

public class SimpleLayout implements Layout {

    @Override
    public String convertMessage(String message) {
        String[] tokens = message.split("\\|");
        String reportLevel = tokens[0];
        String date = tokens[1];
        String messageText = tokens[2];
        return date + " - " + reportLevel + " - " + messageText;
    }
}
