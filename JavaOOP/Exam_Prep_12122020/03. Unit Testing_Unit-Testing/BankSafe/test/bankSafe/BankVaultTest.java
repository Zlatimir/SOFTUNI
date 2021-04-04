package bankSafe;


import org.junit.*;

import javax.naming.OperationNotSupportedException;
import java.util.Map;

import static org.junit.Assert.*;

public class BankVaultTest {

    //TODO: Write your tests here

    private Item testItem;
    private BankVault testVault;

    @Before
    public void setUp() {
        testItem = new Item("testOwner", "testId");
        testVault = new BankVault();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testGetVaultCellsReturnsUnmodifiable() {
        Map<String, Item> cells = testVault.getVaultCells();
        cells.put("A1", testItem);
    }

    @Test
    public void testGetVaultCellsReturnSameSize() {
        Map<String, Item> cells = testVault.getVaultCells();
        assertEquals(12, cells.size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddItemNonExistingCell() {
        try {
            testVault.addItem("ZZ", testItem);
        } catch (OperationNotSupportedException e) {
            e.printStackTrace();
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddItemInTakenCell() {
        try {
            testVault.addItem("A1", testItem);
            testVault.addItem("A1", testItem);
        } catch (OperationNotSupportedException e) {
            e.printStackTrace();
        }
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddItemAlreadyInCell() throws OperationNotSupportedException {
            testVault.addItem("A1", testItem);
            testVault.addItem("B1", testItem);
    }

    @Test
    public void testAddItemSuccessfully() {
        try {
            assertEquals("Item:testId saved successfully!", testVault.addItem("A1", testItem));
        } catch (OperationNotSupportedException e) {
            e.printStackTrace();
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveItemCellThatNotExists() {
        testVault.removeItem("ZZ", testItem);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveItemThatNotExists() {
        try {
            testVault.addItem("A1",testItem);
            testVault.removeItem("A1", new Item("me", "nonExistingItem"));
        } catch (OperationNotSupportedException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testRemoveItemSuccessfully() {
        try {
            testVault.addItem("A1", testItem);
            assertEquals("Remove item:testId successfully!", testVault.removeItem("A1", testItem));
        } catch (OperationNotSupportedException e) {
            e.printStackTrace();
        }
    }

}