package tests;

import Pages.BuyingPage;
import Pages.HepsiburadaPage;
import Pages.ProductListPage;
import Pages.ProductPage;
import static org.testng.Assert.*;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utilities.DriverFactory;

import static utilities.DriverFactory.driver;

public class HepsiburadaTest {

    private static HepsiburadaPage hepsiburadaPage;
    private static ProductListPage productListPage;
    private static ProductPage productPage;
    private static BuyingPage buyingPage;

    private static final String mainUrl = "https://www.hepsiburada.com/";

    @BeforeTest
    public void beforeTest(){
        DriverFactory.getDriver();
        hepsiburadaPage = new HepsiburadaPage();
        productListPage = new ProductListPage();
        productPage = new ProductPage();
        buyingPage = new BuyingPage();
    }

    @Test(priority = 1, description = "Check the main page and search product")
    public void searchProduct(){
        driver.navigate().to(mainUrl);
        hepsiburadaPage.acceptPopup();
        assertTrue(hepsiburadaPage.loginButtonCheck());
        assertTrue(hepsiburadaPage.locationButtonCheck());
        assertTrue(hepsiburadaPage.logoControl());
        assertEquals(driver.getCurrentUrl(), "https://www.hepsiburada.com/");
        assertEquals(driver.getTitle(), "Türkiye'nin En Büyük Online Alışveriş Sitesi Hepsiburada.com");
        hepsiburadaPage.searchProduct("s23").searchClick();

        productListPage.productClick().switchToTab();
    }

    @Test(priority = 2, description = "Check the product's price and added to cart")
    public void checkProduct(){
        assertEquals(productPage.checkThePrice(),"29.143");
        productPage.addToCart().goToBuyPage();
        assertTrue(buyingPage.completeTheShoppingButtonCheck());
    }
}
