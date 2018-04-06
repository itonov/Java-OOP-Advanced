package cresla;

import cresla.entities.containers.ModuleContainer;
import cresla.interfaces.Module;
import cresla.interfaces.Reactor;
import cresla.models.modules.CooldownSystem;
import cresla.models.modules.CryogenRod;
import cresla.models.modules.HeatProcessor;
import cresla.models.reactors.CryoReactor;
import cresla.models.reactors.HeatReactor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    private static int INITIALIZE_ID = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        Map<Integer, Reactor> reactors = new LinkedHashMap<>();
        Map<Integer, Module> modules = new LinkedHashMap<>();

        int totalCryoReactors = 0;
        int totalHeatReactors = 0;
        int totalEnergyModules = 0;
        int totalAbsorbingModules = 0;

        while (!"exit".equalsIgnoreCase(input)) {
            String[] tokens = input.split("\\s+");
            String parameter = tokens[0];
            switch (parameter) {
                case "Reactor":
                    String type = tokens[1];
                    int additionalParam = Integer.parseInt(tokens[2]);
                    int moduleCapacity = Integer.parseInt(tokens[3]);

                    switch (type) {
                        case "Cryo":
                            int id = ++INITIALIZE_ID;
                            reactors.put(id, new CryoReactor(id, additionalParam, new ModuleContainer(moduleCapacity)));
                            totalCryoReactors++;
                            System.out.println(String.format("Created %s Reactor - %d",type, id));
                            break;
                        case "Heat":
                            id = ++INITIALIZE_ID;
                            reactors.put(id, new HeatReactor(id, additionalParam, new ModuleContainer(moduleCapacity)));
                            totalHeatReactors++;
                            System.out.println(String.format("Created %s Reactor - %d",type, id));
                            break;
                        default:
                            break;
                    }
                    break;
                case "Module":
                    int reactorId = Integer.parseInt(tokens[1]);
                    type = tokens[2];
                    additionalParam = Integer.parseInt(tokens[3]);
                    switch (type) {
                        case "CryogenRod":
                            int id = ++INITIALIZE_ID;
                            CryogenRod rodToAdd = new CryogenRod(id, additionalParam);
                            reactors.get(reactorId).addEnergyModule(rodToAdd);
                            modules.put(id, rodToAdd);
                            totalEnergyModules++;
                            System.out.println(String.format("Added %s - %d to Reactor - %d", type, id, reactorId));
                            break;
                        case "HeatProcessor":
                            id = ++INITIALIZE_ID;
                            HeatProcessor processorToAdd = new HeatProcessor(id, additionalParam);
                            reactors.get(reactorId).addAbsorbingModule(processorToAdd);
                            modules.put(id, processorToAdd);
                            totalAbsorbingModules++;
                            System.out.println(String.format("Added %s - %d to Reactor - %d", type, id, reactorId));
                            break;
                        case "CooldownSystem":
                            id = ++INITIALIZE_ID;
                            CooldownSystem systemToAdd = new CooldownSystem(id, additionalParam);
                            reactors.get(reactorId).addAbsorbingModule(systemToAdd);
                            modules.put(id, systemToAdd);
                            totalAbsorbingModules++;
                            System.out.println(String.format("Added %s - %d to Reactor - %d", type, id, reactorId));
                            break;
                        default:
                            break;
                    }
                    break;
                case "Report":
                    int idToReport = Integer.parseInt(tokens[1]);
                    if (reactors.containsKey(idToReport)) {
                        System.out.println(reactors.get(idToReport).toString());
                    } else if (modules.containsKey(idToReport)) {
                        System.out.println(modules.get(idToReport).toString());
                    }
                    break;
                default:
                    break;
            }
            input = reader.readLine();
        }

        long totalEnergyOutput = reactors.values().stream().mapToLong(Reactor::getTotalEnergyOutput).sum();
        long totalHeatAbsorbing = reactors.values().stream().mapToLong(Reactor::getTotalHeatAbsorbing).sum();

        String result = String.format("Cryo Reactors: %d", totalCryoReactors) + System.lineSeparator() +
                String.format("Heat Reactors: %d", totalHeatReactors) + System.lineSeparator() +
                String.format("Energy Modules: %d", totalEnergyModules) + System.lineSeparator() +
                String.format("Absorbing Modules: %d", totalAbsorbingModules) + System.lineSeparator() +
                String.format("Total Energy Output: %d", totalEnergyOutput) + System.lineSeparator() +
                String.format("Total Heat Absorbing: %d", totalHeatAbsorbing);

        System.out.println(result);
    }
}
