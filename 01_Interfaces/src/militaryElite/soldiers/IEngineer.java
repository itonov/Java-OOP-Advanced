package militaryElite.soldiers;

import militaryElite.tasks.Repair;

import java.util.List;

public interface IEngineer {
    List<Repair> getRepairs();
    void addRepair(Repair repair);
}
