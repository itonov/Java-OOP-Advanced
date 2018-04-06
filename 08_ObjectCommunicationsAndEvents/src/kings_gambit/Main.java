package kings_gambit;

import kings_gambit.interfaces.Attackable;
import kings_gambit.models.Footman;
import kings_gambit.models.King;
import kings_gambit.models.RoyalGuard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Attackable king = new King(reader.readLine());
        String[] guardsNames = reader.readLine().split("\\s+");
        String[] footmansNames = reader.readLine().split("\\s+");

        for (String name : guardsNames) {
            king.addUnit(name, new RoyalGuard(name));
        }

        for (String name : footmansNames) {
            king.addUnit(name, new Footman(name));
        }

        String input = reader.readLine();
        while (!"end".equalsIgnoreCase(input)) {
            String[] tokens = input.split("\\s+");

            switch (tokens[0]) {
                case "Attack":
                    king.respond();
                    break;
                case "Kill":
                    king.removeUnit(tokens[1]);
                    break;
                default:
                    break;
            }
            input = reader.readLine();
        }
    }
}
