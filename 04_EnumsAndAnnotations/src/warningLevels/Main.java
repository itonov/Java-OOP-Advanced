package warningLevels;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String initialImportance = reader.readLine();
        Logger log = new Logger(initialImportance);
        String line = reader.readLine();

        while (!"end".equalsIgnoreCase(line)) {
            String[] tokens = line.split(": ");
            String importance = tokens[0];
            String message = tokens[1];
            log.addMessage(new Message(message, Enum.valueOf(Importance.class, importance)));
            line = reader.readLine();
        }

        Iterable<Message> result = log.getMessages();
        for (Message message : result) {
            System.out.println(message);
        }
    }
}
