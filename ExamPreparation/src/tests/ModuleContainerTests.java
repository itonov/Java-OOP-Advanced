package tests;

import cresla.entities.containers.ModuleContainer;
import cresla.interfaces.AbsorbingModule;
import cresla.interfaces.Container;
import cresla.interfaces.EnergyModule;
import cresla.interfaces.Module;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.Map;

public class ModuleContainerTests {
    private static final int INITIAL_MODULE_CAPACITY = 5;
    private static final int EXPECTED_MODULE_COUNT = 1;
    private static final int EXPECTED_TOTAL_ENERGY_OUTPUT = 10;
    private static final int EXPECTED_TOTAL_HEAT_OUTPUT = 10;

    private Container container;

    @Before
    public void init() {
        this.container = new ModuleContainer(INITIAL_MODULE_CAPACITY);
    }

    @Test
    @SuppressWarnings("unchecked")
    public void removeOldestModuleRemovesEnergyModule() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        this.container.addEnergyModule(new EnergyModule() {
            @Override
            public int getEnergyOutput() {
                return 0;
            }

            @Override
            public int getId() {
                return 1;
            }
        });
        Class moduleContainer = ModuleContainer.class;
        Method method = moduleContainer.getDeclaredMethods()[4];
        method.setAccessible(true);
        method.invoke(this.container);
        Field field = moduleContainer.getDeclaredFields()[2];
        field.setAccessible(true);
        Assert.assertEquals("Remove module method isn't working", 0,
                ((Map<Integer, Module>)field.get(this.container)).size());
    }

    @Test
    @SuppressWarnings("unchecked")
    public void addEnergyModuleShouldAddModule() throws IllegalAccessException {
        this.container.addEnergyModule(new EnergyModule() {
            @Override
            public int getEnergyOutput() {
                return 0;
            }

            @Override
            public int getId() {
                return 0;
            }
        });
        Class moduleContainer = ModuleContainer.class;
        Field field = moduleContainer.getDeclaredFields()[1];
        field.setAccessible(true);
        Assert.assertEquals("AddEnergyModule isn't adding new module", EXPECTED_MODULE_COUNT,
                ((LinkedList<Module>) field.get(this.container)).size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void addEnergyModuleShouldntAddNullElement() {
        this.container.addEnergyModule(null);
    }

    @Test
    @SuppressWarnings("unchecked")
    public void addAbsorbingModuleShouldAddModule() throws IllegalAccessException {
        this.container.addAbsorbingModule(new AbsorbingModule() {
            @Override
            public int getId() {
                return 0;
            }

            @Override
            public int getHeatAbsorbing() {
                return 0;
            }
        });
        Class moduleContainer = ModuleContainer.class;
        Field field = moduleContainer.getDeclaredFields()[1];
        field.setAccessible(true);
        Assert.assertEquals("AddEnergyModule isn't adding new module", EXPECTED_MODULE_COUNT,
                ((LinkedList<Module>) field.get(this.container)).size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void addAbsorbingModuleShouldntAddNullElement() {
        this.container.addAbsorbingModule(null);
    }

    @Test
    public void getTotalEnergyOutputReturnsCorrectValue() {
        this.container.addEnergyModule(new EnergyModule() {
            @Override
            public int getEnergyOutput() {
                return EXPECTED_TOTAL_ENERGY_OUTPUT;
            }

            @Override
            public int getId() {
                return 0;
            }
        });

        Assert.assertEquals("GetTotalEnergyOutput isn't working correctly", EXPECTED_TOTAL_ENERGY_OUTPUT,
                this.container.getTotalEnergyOutput());
    }

    @Test
    public void getTotalHeatAbsorbingReturnsCorrectValue() {
        this.container.addAbsorbingModule(new AbsorbingModule() {
            @Override
            public int getHeatAbsorbing() {
                return EXPECTED_TOTAL_HEAT_OUTPUT;
            }

            @Override
            public int getId() {
                return 0;
            }
        });

        Assert.assertEquals("GetTotalHeatAbsorbing isn't working correctly", EXPECTED_TOTAL_HEAT_OUTPUT,
                this.container.getTotalHeatAbsorbing());
    }

}
