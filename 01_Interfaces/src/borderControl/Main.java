package borderControl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inputLine = reader.readLine();
        List<Identifiable> entrants = new ArrayList<>();

        while (!"end".equalsIgnoreCase(inputLine)) {
            String[] tokens = inputLine.split(" ");
            String name = tokens[0];

            if (tokens.length == 3) {
                int age = Integer.parseInt(tokens[1]);
                String id = tokens[2];
                entrants.add(new Citizen(name, age, id));
            } else {
                String id = tokens[1];
                entrants.add(new Robot(name, id));
            }
            inputLine = reader.readLine();
        }

        String forbiddenIds = reader.readLine();

        for (Identifiable entrant : entrants) {
            if (entrant.getId().endsWith(forbiddenIds)) {
                System.out.println(entrant.getId());
            }
        }
    }
}
