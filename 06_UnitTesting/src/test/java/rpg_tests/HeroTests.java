package rpg_tests;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import rpg_lab.Hero;
import rpg_lab.interfaces.Target;
import rpg_lab.interfaces.Weapon;

public class HeroTests {
    private static final int TARGET_EXPERIENCE = 13;
    private static final String HERO_NAME = "Gosho";

    @Test
    public void attackGainsExperienceIfTargetIsDead() {
        Target targetMock = Mockito.mock(Target.class);
        Mockito.when(targetMock.isDead()).thenReturn(true);
        Mockito.when(targetMock.giveExperience()).thenReturn(TARGET_EXPERIENCE);
        Weapon weaponMock = Mockito.mock(Weapon.class);

        Hero hero = new Hero(HERO_NAME, weaponMock);
        hero.attack(targetMock);
        Assert.assertEquals("Wrong experience", TARGET_EXPERIENCE, hero.getExperience());
    }
}
