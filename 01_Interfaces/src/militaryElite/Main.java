package militaryElite;

import militaryElite.soldiers.*;
import militaryElite.tasks.Mission;
import militaryElite.tasks.Repair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        Map<Integer, Soldier> soldiers = new LinkedHashMap<>();
        Map<Integer, Private> privates = new HashMap<>();

        while (!"end".equalsIgnoreCase(input)) {
            String[] tokens = input.split(" ");
            String soldierType = tokens[0];
            int id = Integer.parseInt(tokens[1]);
            String firstName = tokens[2];
            String lastName = tokens[3];

            switch (soldierType) {
                case "Private":
                    double salary = Double.parseDouble(tokens[4]);
                    soldiers.put(id, new Private(id, firstName, lastName, salary));
                    privates.put(id, new Private(id, firstName, lastName, salary));
                    break;
                case "LeutenantGeneral":
                    salary = Double.parseDouble(tokens[4]);
                    LeutenantGeneral leutenantGeneral = new LeutenantGeneral(id, firstName, lastName, salary);
                    for (int i = 5; i < tokens.length; i++) {
                        leutenantGeneral.addPrivate(privates.get(Integer.parseInt(tokens[i])));
                    }
                    soldiers.put(id, leutenantGeneral);
                    break;
                case "Engineer":
                    salary = Double.parseDouble(tokens[4]);
                    String corps = tokens[5];
                    if (corps.equals("Airforces") || corps.equals("Marines")) {
                        Engineer engineer = new Engineer(id, firstName, lastName, salary, corps);
                        for (int i = 6; i < tokens.length; i += 2) {
                            Repair repair = new Repair(tokens[i], Integer.parseInt(tokens[i + 1]));
                            engineer.addRepair(repair);
                        }
                        soldiers.put(id, engineer);
                    }
                    break;
                case "Commando":
                    salary = Double.parseDouble(tokens[4]);
                    corps = tokens[5];
                    if (corps.equals("Airforces") || corps.equals("Marines")) {
                        Commando commando = new Commando(id, firstName, lastName, salary, corps);
                        for (int i = 6; i < tokens.length; i += 2) {
                            String missionName = tokens[i];
                            String missionState = tokens[i + 1];
                            if (missionState.equals("inProgress") || missionState.equals("Finished")) {
                                commando.addMission(new Mission(missionName, missionState));
                            }
                        }
                        soldiers.put(id, commando);
                    }
                    break;
                case "Spy":
                    int codeNum = Integer.parseInt(tokens[4]);
                    soldiers.put(id, new Spy(id, firstName, lastName, codeNum));
                    break;
                default:
                    break;
            }
            input = reader.readLine();
        }

        for (Map.Entry<Integer, Soldier> kvp : soldiers.entrySet()) {
            System.out.println(kvp.getValue().toString());
        }
    }
}
