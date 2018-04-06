package militaryElite.soldiers;

import militaryElite.tasks.Mission;

import java.util.List;

public interface ICommando {
    List<Mission> getMissions();
    void addMission(Mission mission);
}
