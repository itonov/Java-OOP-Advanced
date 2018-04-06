package militaryElite.soldiers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LeutenantGeneral extends Private implements ILeutenantGeneral{
    private List<Private> privates;

    public LeutenantGeneral(int id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName, salary);
        this.privates = new ArrayList<>();
    }

    @Override
    public List<Private> getPrivates() {
        return Collections.unmodifiableList(this.privates);
    }

    @Override
    public void addPrivate(Private soldier) {
        this.privates.add(soldier);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append(System.lineSeparator()).append("Privates:");
        List<Private> privates = this.getPrivates();
        privates = privates.stream().sorted(Comparator.comparingInt(Soldier::getId).reversed()).collect(Collectors.toList());

        for (Private commandedPrivate: privates){
            sb.append(System.lineSeparator()).append(String.format("  %s", commandedPrivate.toString()));
        }
        return sb.toString();
    }
}
