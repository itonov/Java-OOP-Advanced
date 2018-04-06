package foodShortage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int personsCount = Integer.parseInt(reader.readLine());
        Map<String, Buyer> persons = new HashMap<>();

        for (int i = 0; i < personsCount; i++) {
            String[] tokens = reader.readLine().split(" ");
            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);

            if (tokens.length == 4) {
                String id = tokens[2];
                String birthDate = tokens[3];
                persons.put(name ,new Citizen(name, age, id, birthDate));
            } else {
                String group = tokens[2];
                persons.put(name, new Rebel(name, age, group));
            }
        }

        String buyer = reader.readLine();

        while (!"end".equalsIgnoreCase(buyer)) {
            if (persons.containsKey(buyer)) {
                persons.get(buyer).buyFood();
            }
            buyer = reader.readLine();
        }

        int totalFood = 0;

        for (Map.Entry<String, Buyer> person : persons.entrySet()) {
            Buyer currentBuyer = person.getValue();
            totalFood += currentBuyer.getFood();
        }

        System.out.println(totalFood);
    }
}
