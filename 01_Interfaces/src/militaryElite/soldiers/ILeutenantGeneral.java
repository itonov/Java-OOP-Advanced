package militaryElite.soldiers;

import java.util.List;

public interface ILeutenantGeneral {
    List<Private> getPrivates();
    void addPrivate(Private soldier);
}
