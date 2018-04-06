package kings_gambit.models;

import kings_gambit.interfaces.Killable;

public class RoyalGuard extends AbstractUnit implements Killable {
    public RoyalGuard(String name) {
        super(name);
    }

    @Override
    public void respondToEvent() {
        System.out.println(String.format("Royal Guard %s is defending!", super.getName()));
    }
}
