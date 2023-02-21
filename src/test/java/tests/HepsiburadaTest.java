package tests;

import Pages.HepsiburadaPage;
import org.testng.annotations.Test;
import utilities.TestBase;

public class HepsiburadaTest extends TestBase {
    HepsiburadaPage hepsiburadaPage;

    @Test(priority = 1, description = "Check the main page and search product")
    public void test01() throws Exception {
        hepsiburadaPage = new HepsiburadaPage(driver); //Creating a new object
        hepsiburadaPage.navigateToPage("https://www.hepsiburada.com/");
        hepsiburadaPage.acceptPopup();
        hepsiburadaPage.screenShot();
        hepsiburadaPage.findAllLinks();
        hepsiburadaPage.buttonCheck();
        hepsiburadaPage.linkLogoTitleCheck();
        hepsiburadaPage.searchProduct("s23");
        hepsiburadaPage.searchClick();
        hepsiburadaPage.productClick();
        hepsiburadaPage.switchToTab();
    }

    @Test(priority = 2, description = "Check the product's price and added to cart")
    public void test02(){
        hepsiburadaPage = new HepsiburadaPage(driver);
        hepsiburadaPage.priceCheck("23.996");
        hepsiburadaPage.addToCart();
        hepsiburadaPage.productInCartCheck();
        hepsiburadaPage.goToBuyPage();
        hepsiburadaPage.shoppingButtonCheck();
    }
}
