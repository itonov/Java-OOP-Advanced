package cresla.models.modules;

import cresla.interfaces.EnergyModule;

public abstract class AbstractEnergyModule extends AbstractModule implements EnergyModule {
    private int energyOutput;

    AbstractEnergyModule(int id, int additionalParameter) {
        super(id);
        this.energyOutput = additionalParameter;
    }

    @Override
    public int getEnergyOutput() {
        return this.energyOutput;
    }
}
