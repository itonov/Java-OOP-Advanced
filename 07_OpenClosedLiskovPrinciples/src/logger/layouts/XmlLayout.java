package logger.layouts;

import logger.interfaces.Layout;

public class XmlLayout implements Layout {

    @Override
    public String convertMessage(String message) {
        StringBuilder sb = new StringBuilder();
        String[] tokens = message.split("\\|");
        String level = tokens[0];
        String date = tokens[1];
        String messageText = tokens[2];
        sb.append("<log>").append(System.lineSeparator())
                .append("\t").append(String.format("<date>%s</date>", date)).append(System.lineSeparator())
                .append("\t").append(String.format("<level>%s</level>", level)).append(System.lineSeparator())
                .append("\t").append(String.format("<message>%s</message>", messageText)).append(System.lineSeparator())
                .append("</log>");
        return sb.toString();
    }
}
