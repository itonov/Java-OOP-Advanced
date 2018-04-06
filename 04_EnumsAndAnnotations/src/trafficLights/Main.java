package trafficLights;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] inputLights = reader.readLine().split(" ");
        List<Light> lights = new ArrayList<>();

        for (String light : inputLights) {
            lights.add(Enum.valueOf(Light.class, light));
        }

        int rotations = Integer.parseInt(reader.readLine());

        for (int i = 0; i < rotations; i++) {
            for (int j = 0; j < lights.size(); j++) {
                Light light = lights.get(j);
                switch (light.name()) {
                    case "RED":
                        lights.set(j, Enum.valueOf(Light.class, "GREEN"));
                        break;
                    case "GREEN":
                        lights.set(j, Enum.valueOf(Light.class, "YELLOW"));
                        break;
                    case "YELLOW":
                        lights.set(j, Enum.valueOf(Light.class, "RED"));
                        break;
                    default:
                        break;
                }
            }

            lights.forEach(s -> System.out.print(s.name() + " "));
            System.out.println();
        }
    }
}
