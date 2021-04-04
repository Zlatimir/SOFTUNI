package blueOrigin;

import org.junit.Test;

import static org.junit.Assert.*;

public class SpaceshipTests {

    @Test(expected = NullPointerException.class)
    public void testNameIsNull() {
        Spaceship spaceship = new Spaceship("", 20);
    }

    @Test(expected = NullPointerException.class)
    public void testNameIsEmpty() {
        Spaceship spaceship = new Spaceship("  ", 20);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCapacityLessZero() {
        Spaceship spaceship = new Spaceship("Name", -2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddWhenIsFull() {
        Spaceship spaceship = new Spaceship("Name", 1);
        spaceship.add(new Astronaut("asd", 100));
        spaceship.add(new Astronaut("qwe", 100));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddingSameGuyTwice() {
        Spaceship spaceship = new Spaceship("Name", 5);
        spaceship.add(new Astronaut("asd", 100));
        spaceship.add(new Astronaut("asd", 100));
    }

    @Test
    public void testRemoveWhenTrue() {
        Spaceship spaceship = new Spaceship("Name", 20);
        spaceship.add(new Astronaut("asd", 50));
        assertTrue(spaceship.remove("asd"));
    }

    @Test
    public void testRemoveWhenNotTrue() {
        Spaceship spaceship = new Spaceship("Name", 20);
        spaceship.add(new Astronaut("asd", 50));
        assertFalse(spaceship.remove("zxc"));
    }
}
