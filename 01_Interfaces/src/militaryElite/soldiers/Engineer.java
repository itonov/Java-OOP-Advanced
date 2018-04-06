package militaryElite.soldiers;

import militaryElite.tasks.Repair;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Engineer extends SpecialisedSoldier implements IEngineer {
    private List<Repair> repairs;

    public Engineer(int id, String firstName, String lastName, double salary, String corps) {
        super(id, firstName, lastName, salary, corps);
        this.repairs = new ArrayList<>();
    }

    @Override
    public List<Repair> getRepairs() {
        return Collections.unmodifiableList(this.repairs);
    }

    @Override
    public void addRepair(Repair repair) {
        this.repairs.add(repair);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append(System.lineSeparator()).append("Repairs:");
        List<Repair> currentRepairs = this.getRepairs();
        for (Repair repair : currentRepairs) {
            sb.append(System.lineSeparator()).append(String.format("  %s", repair.toString()));
        }
        return sb.toString();
    }
}
