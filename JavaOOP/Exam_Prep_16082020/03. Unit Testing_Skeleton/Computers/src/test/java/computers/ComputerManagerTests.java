package computers;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class ComputerManagerTests {
    // TODO: Test ComputerManager
    private ComputerManager computerManager;

    @Before
    public void setUp() {
        ComputerManager computerManager = new ComputerManager();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddCompNullComp() {
        ComputerManager computerManager = new ComputerManager();
        computerManager.addComputer(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddCompExists() {
        ComputerManager computerManager = new ComputerManager();
        Computer computer1 = new Computer("AA", "BB", 100.);
        Computer computer2 = new Computer("AA", "BB", 50.);
        computerManager.addComputer(computer1);
        computerManager.addComputer(computer2);
    }

    @Test
    public void testAddCompWorks() {
        ComputerManager computerManager = new ComputerManager();
        Computer computer1 = new Computer("AA", "B", 100.);
        Computer computer2 = new Computer("BA", "BB", 50.);
        computerManager.addComputer(computer1);
        computerManager.addComputer(computer2);
        Assert.assertEquals(2, computerManager.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetCompNullManufacturer() {
        ComputerManager computerManager = new ComputerManager();
        Computer computer1 = new Computer("AA", "B", 100.);
        computerManager.addComputer(computer1);
        computerManager.getComputer(null, "B");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetCompNullModel() {
        ComputerManager computerManager = new ComputerManager();
        Computer computer1 = new Computer("AA", "B", 100.);
        computerManager.addComputer(computer1);
        computerManager.getComputer("AA", null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetCompNoSuchModel() {
        ComputerManager computerManager = new ComputerManager();
        Computer computer1 = new Computer("AA", "B", 100.);
        computerManager.addComputer(computer1);
        computerManager.getComputer("A", "N");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetCompByManufacturerNullValue() {
        ComputerManager computerManager = new ComputerManager();
        Computer computer1 = new Computer("AA", "B", 100.);
        computerManager.addComputer(computer1);
        computerManager.getComputersByManufacturer(null);
    }

    @Test
    public void testGetCompByManufacturerWorks() {
        ComputerManager computerManager = new ComputerManager();
        Computer computer1 = new Computer("AA", "B", 100.);
        Computer computer2 = new Computer("AA", "BB", 50.);
        computerManager.addComputer(computer1);
        computerManager.addComputer(computer2);
        List<Computer> list = computerManager.getComputersByManufacturer("AA");
        Assert.assertEquals(2, list.size());
    }

    @Test
    public void testRemoveCompWorks() {
        ComputerManager computerManager = new ComputerManager();
        Computer computer1 = new Computer("AA", "B", 100.);
        computerManager.addComputer(computer1);
        Computer computer = computerManager.removeComputer("AA", "B");
        Assert.assertEquals(computer1, computer);
    }

    @Test
    public void testGetComputersReturnsList() {
        ComputerManager computerManager = new ComputerManager();
        Computer computer1 = new Computer("AA", "B", 100.);
        Computer computer2 = new Computer("AA", "BB", 50.);
        computerManager.addComputer(computer1);
        computerManager.addComputer(computer2);
        List<Computer> list = computerManager.getComputers();
        Assert.assertEquals(2, list.size());
    }
}