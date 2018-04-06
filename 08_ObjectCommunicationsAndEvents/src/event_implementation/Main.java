package event_implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Dispatcher dispatcher = new Dispatcher();
        Handler handler = new Handler();
        dispatcher.addNameChangeListener(handler);

        String inputName = reader.readLine();

        while (!"end".equalsIgnoreCase(inputName)) {
            NameChange nameChange = new NameChange(inputName);
            dispatcher.fireNameChangeListeners(nameChange);

            inputName = reader.readLine();
        }
    }
}
