package rpg_tests;

import org.junit.Assert;
import org.junit.Test;
import rpg_lab.Axe;
import rpg_lab.Hero;

/**
 * Created by Zlatimir Ivanov on 23.3.2021 г..
 */

public class test01 {

    @Test
    public void testHeroExpirience() {
        Hero hero = new Hero("Zlati");
        int experience = hero.getExperience();

        Assert.assertEquals(0, experience);

    }

    @Test
    public void testAxeConstructor() {
        Axe axe = new Axe(10, 20);
        Assert.assertTrue(axe.getAttackPoints() == 10 && axe.getDurabilityPoints() == 20);
    }
}
