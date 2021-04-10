package aquarium;

import org.junit.Assert;
import org.junit.Test;


public class AquariumTests {
    //TODO: TEST ALL THE FUNCTIONALITY OF THE PROVIDED CLASS Aquarium

    @Test
    public void testGetName() {
        Aquarium aquarium = new Aquarium("Aqua", 10);
        Assert.assertEquals("Aqua", aquarium.getName());
    }

    @Test(expected = NullPointerException.class)
    public void testNullName() {
        Aquarium aquarium = new Aquarium(null, 10);
    }

    @Test(expected = NullPointerException.class)
    public void testEmptyName() {
        Aquarium aquarium = new Aquarium("   ", 10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCapacityLessZero() {
        Aquarium aquarium = new Aquarium("Aqua", -5);
    }

    @Test
    public void testGetCount() {
        Aquarium aquarium = new Aquarium("Aqua", 5);
        aquarium.add(new Fish("Fish"));
        Assert.assertEquals(1, aquarium.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddMoreThanCapacity() {
        Aquarium aquarium = new Aquarium("Aqua", 1);
        aquarium.add(new Fish("Fish1"));
        aquarium.add(new Fish("Fish2"));
    }

    @Test
    public void testRemove() {
        Aquarium aquarium = new Aquarium("Aqua", 2);
        aquarium.add(new Fish("Fish1"));
        aquarium.remove("Fish1");
        Assert.assertEquals(0, aquarium.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveNotExisting() {
        Aquarium aquarium = new Aquarium("Aqua", 2);
        aquarium.add(new Fish("Fish1"));
        aquarium.remove("Fis");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSellFishNotExists() {
        Aquarium aquarium = new Aquarium("Aqua", 2);
        aquarium.add(new Fish("Fish1"));
        aquarium.sellFish("FFF");
    }

    @Test
    public void testSellReturnsCorrect() {
        Aquarium aquarium = new Aquarium("Aqua", 2);
        Fish fish = new Fish("Fish1");
        aquarium.add(fish);
        Assert.assertEquals(fish, aquarium.sellFish("Fish1"));
    }

    @Test
    public void testSellAvailableFalse() {
        Aquarium aquarium = new Aquarium("Aqua", 2);
        Fish fish = new Fish("Fish1");
        aquarium.add(fish);
        aquarium.sellFish("Fish1");
        Assert.assertFalse(fish.isAvailable());
    }

    @Test
    public void testReport() {
        Aquarium aquarium = new Aquarium("Aqua", 2);
        Fish fish = new Fish("Fish1");
        aquarium.add(fish);
        Assert.assertEquals("Fish available at Aqua: Fish1", aquarium.report());
    }

    @Test
    public void testGetCapacity() {
        Aquarium aquarium = new Aquarium("Aqua", 2);
        Assert.assertEquals(2, aquarium.getCapacity());
    }

    @Test
    public void testReport2() {
        Aquarium aquarium = new Aquarium("Aqua", 2);
        Fish fish = new Fish("Fish1");
        aquarium.add(fish);
        fish = new Fish("Fish2");
        aquarium.add(fish);
        Assert.assertEquals("Fish available at Aqua: Fish1, Fish2", aquarium.report());
    }
}

