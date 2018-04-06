package kings_gambit.interfaces;

public interface Attackable {
    void addUnit(String name, Killable unit);

    void removeUnit(String name);

    void respond();
}
