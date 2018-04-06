package militaryElite.soldiers;

import militaryElite.tasks.Mission;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Commando extends SpecialisedSoldier implements ICommando {
    private List<Mission> missions;

    public Commando(int id, String firstName, String lastName, double salary, String corps) {
        super(id, firstName, lastName, salary, corps);
        this.missions = new ArrayList<>();
    }

    @Override
    public List<Mission> getMissions() {
        return Collections.unmodifiableList(this.missions);
    }

    @Override
    public void addMission(Mission mission) {
        this.missions.add(mission);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append(System.lineSeparator()).append("Missions:");
        List<Mission> currentMissions = this.getMissions();
        for (Mission mission : currentMissions) {
            sb.append(System.lineSeparator()).append(String.format("  %s", mission.toString()));
        }
        return sb.toString();
    }
}
