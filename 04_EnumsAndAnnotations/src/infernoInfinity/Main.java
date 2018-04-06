package infernoInfinity;

import infernoInfinity.sockets.Socket;
import infernoInfinity.weapons.Axe;
import infernoInfinity.weapons.BaseWeapon;
import infernoInfinity.weapons.Knife;
import infernoInfinity.weapons.Sword;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        List<BaseWeapon> weapons = new ArrayList<>();

        while (!"end".equalsIgnoreCase(input)) {
            String[] tokens = input.split(";");
            String action = tokens[0];

            switch (action) {
                case "Create":
                    String type = tokens[1];
                    String name = tokens[2];

                    switch (type) {
                        case "AXE":
                            weapons.add(new Axe(name));
                            break;
                        case "SWORD":
                            weapons.add(new Sword(name));
                            break;
                        case "KNIFE":
                            weapons.add(new Knife(name));
                            break;
                        default:
                            break;
                    }
                    break;
                case "Add":
                    name = tokens[1];
                    int socketIndex = Integer.parseInt(tokens[2]);
                    Socket gem = Enum.valueOf(Socket.class, tokens[3]);
                    for (BaseWeapon weapon : weapons) {
                        if (weapon.getName().equals(name)) {
                            weapon.addSocket(gem, socketIndex);
                            break;
                        }
                    }
                    break;
                case "Remove":
                    name = tokens[1];
                    socketIndex = Integer.parseInt(tokens[2]);
                    for (BaseWeapon weapon : weapons) {
                        if (weapon.getName().equals(name)) {
                            weapon.removeSocket(socketIndex);
                            break;
                        }
                    }
                    break;
                case "Print":
                    name = tokens[1];
                    for (BaseWeapon weapon : weapons) {
                        if (weapon.getName().equals(name)) {
                            System.out.println(weapon.toString());
                            break;
                        }
                    }
                    break;
                default:
                    break;
            }
            input = reader.readLine();
        }
    }
}
