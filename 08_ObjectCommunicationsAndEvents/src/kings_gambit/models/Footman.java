package kings_gambit.models;

import kings_gambit.interfaces.Killable;

public class Footman extends AbstractUnit implements Killable {
    public Footman(String name) {
        super(name);
    }

    @Override
    public void respondToEvent() {
        System.out.println(String.format("Footman %s is panicking!", super.getName()));
    }
}
