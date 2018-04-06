package logger;

import logger.interfaces.File;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogFile implements File {
    private static final String PATTERN_TO_MATCH_MESSAGE = "[a-z]|[A-Z]";

    private StringBuilder message;

    public LogFile() {
        this.message = new StringBuilder();
    }

    @Override
    public void write(String message) {
        this.message.append(message);
    }

    @Override
    public int getSize() {
        Pattern pattern = Pattern.compile(PATTERN_TO_MATCH_MESSAGE);
        String message = this.message.toString();
        Matcher matcher = pattern.matcher(message);
        int size = 0;
        while (matcher.find()) {
            char[] neededMessageParts = matcher.group().toCharArray();
            for (char letter : neededMessageParts) {
                size += letter;
            }
        }

        return size;
    }
}
