package tests;

import Pages.BuyingPage;
import Pages.HepsiburadaPage;
import Pages.ProductListPage;
import Pages.ProductPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.TestBase;

public class HepsiburadaTest extends TestBase {

    HepsiburadaPage hepsiburadaPage;
    ProductListPage productListPage;
    ProductPage productPage;
    BuyingPage buyingPage;

    private static final String mainUrl = "https://www.hepsiburada.com/";

    @BeforeClass
    public void beforeClass(){

        hepsiburadaPage = new HepsiburadaPage(driver);
        productListPage = new ProductListPage(driver);
        productPage = new ProductPage(driver);
        buyingPage = new BuyingPage(driver);
    }

    @Test(priority = 1, description = "Check the main page and search product")
    public void searchProduct(){

        navigateToUrl(mainUrl);
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
