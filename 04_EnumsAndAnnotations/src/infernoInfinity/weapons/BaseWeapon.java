package infernoInfinity.weapons;

import infernoInfinity.sockets.Socket;

import java.util.Arrays;

public abstract class BaseWeapon {
    private String name;
    private int minDamage;
    private int maxDamage;
    private Socket[] sockets;

    public BaseWeapon(String name, int minDamage, int maxDamage, int sockets) {
        this.name = name;
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
        this.sockets = new Socket[sockets];
    }

    public String getName() {
        return this.name;
    }

    public void addSocket(Socket socket, int index) {
        if (index >= 0 && index < this.sockets.length) {
            this.sockets[index] = socket;
        }
    }

    public void removeSocket(int index) {
        if (index >= 0 && index < this.sockets.length && this.sockets[index] != null) {
            this.sockets[index] = null;
        }
    }

    private int getTotalStrength() {
        int result = 0;
        for (Socket socket : this.sockets) {
            if (socket != null) {
                result += socket.getStrength();
            }
        }

        return result;
    }

    private int getTotalAgility() {
        int result = 0;
        for (Socket socket : this.sockets) {
            if (socket != null) {
                result += socket.getAgility();
            }
        }

        return result;
    }

    private int getTotalVitality() {
        int result = 0;
        for (Socket socket : this.sockets) {
            if (socket != null) {
                result += socket.getVitality();
            }
        }

        return result;
    }

    public int calcMaxDamage() {
        return this.maxDamage + (this.getTotalStrength() * 3) + (this.getTotalAgility() * 4);
    }

    public int calcMinDamage() {
        return this.minDamage + (this.getTotalStrength() * 2) + this.getTotalAgility();
    }

    @Override
    public String toString() {
        return String.format("%s: %d-%d Damage, +%d Strength, +%d Agility, +%d Vitality",
                this.getName(), this.calcMinDamage(), this.calcMaxDamage(),
                this.getTotalStrength(), this.getTotalAgility(), this.getTotalVitality());
    }
}
