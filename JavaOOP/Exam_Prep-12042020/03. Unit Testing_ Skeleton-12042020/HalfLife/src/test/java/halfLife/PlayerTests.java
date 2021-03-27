package halfLife;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static junit.framework.TestCase.*;

public class PlayerTests {
    private Player testPlayer;
    private Gun testGun;
    //TODO: TEST ALL THE FUNCTIONALITY OF THE PROVIDED CLASS Player

    @Before
    public void setUp() {
        testPlayer = new Player("TestName", 100);
        testGun = new Gun("Pistol", 10);
    }

    @Test(expected = NullPointerException.class)
    public void testNullNameThrowException() {
        Player player = new Player(null, 100);
    }

    @Test(expected = NullPointerException.class)
    public void testEmptyNameThrowException() {
        Player player = new Player("", 100);
    }

    @Test
    public void testValidName() {
        assertEquals("TestName", testPlayer.getUsername());
    }

    @Test
    public void testCorrectHealth() {
        assertEquals(100, testPlayer.getHealth());
    }

    @Test
    public void testTakeDamage_PlayerHealthSetToZeroWhenDamageGreaterThanHealth() {
        Player player = new Player("TestName", 20);
        player.takeDamage(30);
        assertEquals(0, player.getHealth());
    }

    @Test(expected = IllegalStateException.class)
    public void testTakeDamage_PlayerIsDeadWhenHealthIsZero() {
        Player player = new Player("TestName", 0);
        player.takeDamage(10);
    }

    @Test
    public void testTakeDamage_ShouldDecreaseHealt() {
        testPlayer.takeDamage(50);
        assertEquals(50, testPlayer.getHealth());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetHealthLessZeroThrowException() {
        Player player = new Player("TestName", -5);
    }

    @Test(expected = NullPointerException.class)
    public void testAddGun_WhenNullThrowException() {
        testPlayer.addGun(null);
    }

    @Test
    public void testAddGunCorrectly() {
        testPlayer.addGun(testGun);
        List<Gun> guns = testPlayer.getGuns();
        assertEquals("Pistol", guns.get(0).getName());
    }

    @Test
    public void testRemoveGunCorrectly() {
        testPlayer.addGun(testGun);
        assertTrue(testPlayer.removeGun(testGun));
    }

    @Test
    public void testGetGunReturnsCorrectValue() {
        testPlayer.addGun(testGun);
        Gun returnedGun = testPlayer.getGun("Pistol");
        assertEquals(testGun, returnedGun);
    }
}
