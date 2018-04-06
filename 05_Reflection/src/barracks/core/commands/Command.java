package barracks.core.commands;

import barracks.contracts.Executable;
import barracks.contracts.Repository;
import barracks.contracts.UnitFactory;

public abstract class Command implements Executable {
    private String[] data;
    private Repository repository;
    private UnitFactory factory;

    protected Command(String[] data, Repository repository, UnitFactory factory) {
        this.data = data;
        this.repository = repository;
        this.factory = factory;
    }

    protected String[] getData() {
        return this.data;
    }

    protected Repository getRepository() {
        return this.repository;
    }

    protected UnitFactory getFactory() {
        return this.factory;
    }
}
