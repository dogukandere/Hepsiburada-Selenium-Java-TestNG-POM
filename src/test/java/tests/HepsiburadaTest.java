package tests;

import Pages.HepsiburadaPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.TestBase;

public class HepsiburadaTest extends TestBase {
    HepsiburadaPage hepsiburadaPage;

    private static final String mainUrl = "https://www.hepsiburada.com/";

    @BeforeClass
    public void beforeClass(){

        hepsiburadaPage = new HepsiburadaPage(driver);
    }

    @Test(priority = 1, description = "Check the main page and search product")
    public void searchProduct() {

        navigateToUrl(mainUrl);
        hepsiburadaPage.acceptPopup();
        Assert.assertTrue(hepsiburadaPage.loginButtonCheck());
        Assert.assertTrue(hepsiburadaPage.locationButtonCheck());
        Assert.assertTrue(hepsiburadaPage.logoControl());
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.hepsiburada.com/");
        Assert.assertEquals(driver.getTitle(), "Türkiye'nin En Büyük Online Alışveriş Sitesi Hepsiburada.com");
        hepsiburadaPage.searchProduct("s23");
        hepsiburadaPage.searchClick().productClick().switchToTab();
    }

    @Test(priority = 2, description = "Check the product's price and added to cart")
    public void checkProduct(){

        Assert.assertEquals(hepsiburadaPage.checkThePrice(),"23.488");
        hepsiburadaPage.addToCart().goToBuyPage();
        Assert.assertTrue(hepsiburadaPage.completeTheShoppingButtonCheck());
    }
}
