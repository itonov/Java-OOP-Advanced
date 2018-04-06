package logger;

import logger.appenders.ConsoleAppender;
import logger.appenders.FileAppender;
import logger.interfaces.Appender;
import logger.interfaces.File;
import logger.interfaces.Layout;
import logger.layouts.SimpleLayout;
import logger.layouts.XmlLayout;
import logger.loggers.MessageLogger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        MessageLogger logger = new MessageLogger();
        int appendersCount = Integer.parseInt(reader.readLine());

        for (int i = 0; i < appendersCount; i++) {
            String[] inputTokens = reader.readLine().split(" ");
            Appender appender = null;
            Layout layout = null;
            if (inputTokens[1].equals("SimpleLayout")) {
                layout = new SimpleLayout();
            } else {
                layout = new XmlLayout();
            }

            switch (inputTokens[0]) {
                case "ConsoleAppender":
                    appender = new ConsoleAppender(layout);
                    if (inputTokens.length == 3) {
                        appender.setLevel(Enum.valueOf(ReportLevel.class, inputTokens[2]));
                    }
                    logger.addAppender(appender);
                    break;
                case "FileAppender":
                    File file = new LogFile();
                    appender = new FileAppender(layout, file);
                    if (inputTokens.length == 3) {
                        appender.setLevel(Enum.valueOf(ReportLevel.class, inputTokens[2]));
                    }
                    logger.addAppender(appender);
                    break;
                default:
                    break;
            }
        }

        String message = reader.readLine();

        while (!"end".equalsIgnoreCase(message)) {
            logger.logMessage(message);
            message = reader.readLine();
        }

        logger.appendMessages();
        System.out.println(logger.toString());
    }
}
