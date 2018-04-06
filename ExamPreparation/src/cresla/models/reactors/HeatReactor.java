package cresla.models.reactors;

import cresla.interfaces.AbsorbingModule;
import cresla.interfaces.Container;
import cresla.interfaces.EnergyModule;

public class HeatReactor extends AbstractReactor {

    public HeatReactor(int id, int additionalParameter, Container container) {
        super(id, additionalParameter, container);
    }

    @Override
    public long getTotalEnergyOutput() {
        if (super.getTotalEnergyOutput() > super.getTotalHeatAbsorbing() + super.getAdditionalParameter()) {
            return 0;
        }

        return super.getTotalEnergyOutput();
    }

    @Override
    public long getTotalHeatAbsorbing() {
        return super.getTotalHeatAbsorbing() + super.getAdditionalParameter();
    }

    @Override
    public int getModuleCount() {
        return super.getModuleCount();
    }

    @Override
    public void addEnergyModule(EnergyModule energyModule) {
        super.addEnergyModule(energyModule);
    }

    @Override
    public void addAbsorbingModule(AbsorbingModule absorbingModule) {
        super.addAbsorbingModule(absorbingModule);
    }

    @Override
    public String toString() {
        return String.format("HeatReactor - %d", super.getId()) + System.lineSeparator() +
                String.format("Energy Output: %d", this.getTotalEnergyOutput()) + System.lineSeparator() +
                String.format("Heat Absorbing: %d", this.getTotalHeatAbsorbing()) + System.lineSeparator() +
                String.format("Modules: %d", super.getModuleCount());
    }
}
