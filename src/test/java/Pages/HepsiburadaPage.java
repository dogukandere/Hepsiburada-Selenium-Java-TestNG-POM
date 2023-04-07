package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utilities.ReusableMethods;

public class HepsiburadaPage extends ReusableMethods {
    WebDriver driver;

    public HepsiburadaPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    private final String SEARCH_BOX = "//input[@placeholder='Ürün, kategori veya marka ara']";
    private final String SEARCH_BUTTON = "//div[@class='searchBoxOld-yDJzsIfi_S5gVgoapx6f']";
    private final String POPUP = "//*[@id=\"onetrust-accept-btn-handler\"]";
    private final String LOGO = "//a[@title='Hepsiburada']//*[name()='svg']//*[name()='path' and contains(@fill,'#FF6000')]";
    private final String LOGIN_BUTTON = "//span[@title='Giriş Yap']";
    private final String CART_BUTTON = "//span[@id='shoppingCart']";
    private final String ADD_CART_BUTTON = "//button[@id='addToCart']";
    private final String PRODUCT = "//a[@title='Samsung Galaxy S23 256 GB 8 GB Ram (Samsung Türkiye Garantili)']//h3[@type='comfort']";
    private final String TEXT_CONTROL_ELEMENT = "//span[@data-bind=\"markupText:'currentPriceBeforePoint'\"]";
    private final String PRODUCT_CHECK_ELEMENT = "//span[@class='checkoutui-ProductOnBasketHeader-nOvp_U8bHbLzgKbSUFaz']";
    private final String GO_TO_CART_BUTTON = "//button[normalize-space()='Sepete git']";
    private final String SHOPPING_BUTTON = "//button[@id='continue_step_btn']";


    public void navigateToPage(String url) {
        driver.navigate().to(url);
    }

    public void acceptPopup(){
            Click(POPUP);
    }

    public void buttonCheck(){
        isDisplayed(LOGIN_BUTTON);
        isDisplayed(CART_BUTTON);
    }

    public void linkLogoTitleCheck(){
        isDisplayed(LOGO);
        Assert.assertEquals("https://www.hepsiburada.com/",driver.getCurrentUrl());
        Assert.assertEquals("Türkiye'nin En Büyük Online Alışveriş Sitesi Hepsiburada.com",driver.getTitle());
    }

    public void searchProduct(String productname){
        SendKeys(SEARCH_BOX,productname);
    }

    public void searchClick(){
        Click(SEARCH_BUTTON);
    }

    public void productClick(){
        Click(PRODUCT);
    }

    public void priceCheck(String fiyat){
        Assert.assertEquals(TEXT_CONTROL_ELEMENT.getText(),fiyat);
    }

    public void addToCart(){
        Click(ADD_CART_BUTTON);
    }

    public void productInCartCheck(){
        waitUntilElementIsVisible(PRODUCT_CHECK_ELEMENT,10);
        Assert.assertEquals(PRODUCT_CHECK_ELEMENT.getText(),"Ürün sepetinizde");
    }

    public void goToBuyPage(){
        Click(GO_TO_CART_BUTTON);
    }

    public void shoppingButtonCheck(){
        isDisplayed(SHOPPING_BUTTON);
        isClickable(SHOPPING_BUTTON);
    }

}
