package tests;

import Pages.BuyingPage;
import Pages.HepsiburadaPage;
import Pages.ProductListPage;
import Pages.ProductPage;
import org.testng.Assert;
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
        Assert.assertTrue(hepsiburadaPage.loginButtonCheck());
        Assert.assertTrue(hepsiburadaPage.locationButtonCheck());
        Assert.assertTrue(hepsiburadaPage.logoControl());
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.hepsiburada.com/");
        Assert.assertEquals(driver.getTitle(), "Türkiye'nin En Büyük Online Alışveriş Sitesi Hepsiburada.com");
        hepsiburadaPage.searchProduct("s23").searchClick();

        productListPage.productClick().switchToTab();
    }

    @Test(priority = 2, description = "Check the product's price and added to cart")
    public void checkProduct(){

        Assert.assertEquals(productPage.checkThePrice(),"27.370");
        productPage.addToCart().goToBuyPage();
        Assert.assertTrue(buyingPage.completeTheShoppingButtonCheck());
    }
}
