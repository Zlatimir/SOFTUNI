package store;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class StoreTests {
    //TODO: Test Store class
    private static Store testStore;
    private static Product testProduct;

    @Before
    public void setUp() {
        testStore = new Store();
        testProduct = new Product("testProduct", 10, 20);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddProductCanNotBeNull() {
        testStore.addProduct(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddProductNegativeQuantity() {
        testStore.addProduct(new Product("testProduct", 0, 1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testBuyProductCanNotBeNull(){
        testStore.addProduct(testProduct);
        testStore.buyProduct("name", 5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testBuyProductCanNotBeMoreThanQuantityInTheStore(){
        testStore.addProduct(testProduct);
        testStore.buyProduct("name", 15);
    }

    @Test
    public void testBuyProductReturnsCorrectPrice() {
        testStore.addProduct(testProduct);
        double price = testStore.buyProduct("testProduct", 5);
        assertEquals(100, price, 0);
    }

    @Test
    public void testBuyProductReducesProductQuantity() {
        testStore.addProduct(testProduct);
        int before = testProduct.getQuantity();
        testStore.buyProduct("testProduct", 5);
        assertEquals(before - 5, testProduct.getQuantity());
    }

    @Test
    public void testGetMostExpensiveReturnCorrectProduct() {
        for (int i = 0; i < 10; i++) {
            testStore.addProduct(new Product("test" + i, 100, 10 + i));
        }
        Product result = testStore.getTheMostExpensiveProduct();
        assertEquals(19, result.getPrice(),0);
    }

    @Test
    public void testGetCount() {
        testStore.addProduct(testProduct);
        assertEquals(1, testStore.getCount());
    }

    @Test
    public void testGetProductsReturnsCorrectCount() {
        testStore.addProduct(testProduct);
        List<Product> products = testStore.getProducts();
        assertEquals(1, products.size());
    }
}