package cresla.models.reactors;

import cresla.interfaces.AbsorbingModule;
import cresla.interfaces.Container;
import cresla.interfaces.EnergyModule;

public class CryoReactor extends AbstractReactor {

    public CryoReactor(int id, int additionalParameter, Container container) {
        super(id, additionalParameter, container);
    }

    @Override
    public long getTotalEnergyOutput() {
        if (super.getTotalEnergyOutput() * super.getAdditionalParameter() > this.getTotalHeatAbsorbing()) {
            return 0;
        }

        return super.getTotalEnergyOutput() * super.getAdditionalParameter();
    }

    @Override
    public long getTotalHeatAbsorbing() {
        return super.getTotalHeatAbsorbing();
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
        return String.format("CryoReactor - %d", super.getId()) + System.lineSeparator() +
                String.format("Energy Output: %d", this.getTotalEnergyOutput()) + System.lineSeparator() +
                String.format("Heat Absorbing: %d", this.getTotalHeatAbsorbing()) + System.lineSeparator() +
                String.format("Modules: %d", super.getModuleCount());
    }
}
