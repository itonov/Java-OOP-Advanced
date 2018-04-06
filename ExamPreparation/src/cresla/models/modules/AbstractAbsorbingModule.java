package cresla.models.modules;

import cresla.interfaces.AbsorbingModule;

public abstract class AbstractAbsorbingModule extends AbstractModule implements AbsorbingModule {
    private int heatAbsorbing;

    AbstractAbsorbingModule(int id, int additionalParameter) {
        super(id);
        this.heatAbsorbing = additionalParameter;
    }

    @Override
    public int getHeatAbsorbing() {
        return this.heatAbsorbing;
    }
}
