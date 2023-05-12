package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
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
    private final String LOCATION_BUTTON = "//div[@class='shipping-src-universal-partials-ShippingLocation-components-locationSelector-button-ShippingLocationSelectorButton__locationLabel']";
    private final String ADD_CART_BUTTON = "//button[@id='addToCart']";
    private final String PRODUCT = "//a[@title='Samsung Galaxy S23 256 GB 8 GB Ram (Samsung Türkiye Garantili)']//h3[@type='comfort']";
    private final String TEXT_CONTROL_ELEMENT = "//span[@data-bind=\"markupText:'currentPriceBeforePoint'\"]";
    private final String GO_TO_CART_BUTTON = "//button[normalize-space()='Sepete git']";
    private final String LIVE_SUPPORT_POPUP = "//*[@id=\"Embed\"]/div/div/div/div/div/div/header/div/button[2]/svg";
    private final String COMPLETE_SHOPPING_BUTTON = "//button[@id='continue_step_btn']";

    public HepsiburadaPage acceptPopup(){

        click(POPUP);
        return this;
    }

    public boolean loginButtonCheck(){

        return isDisplayed(LOGIN_BUTTON);
    }

    public boolean locationButtonCheck(){

        return isDisplayed(LOCATION_BUTTON);
    }

    public boolean logoControl(){

        return isDisplayed(LOGO);
    }

    public HepsiburadaPage searchProduct(String productname){

        sendKeys(SEARCH_BOX,productname);
        return this;
    }

    public HepsiburadaPage searchClick(){

        click(SEARCH_BUTTON);
        return this;
    }

    public HepsiburadaPage productClick(){

        click(PRODUCT);
        return this;
    }

    public String checkThePrice(){

        return getTextOfElement(TEXT_CONTROL_ELEMENT);
    }

    public HepsiburadaPage addToCart(){

        scrollDown(200);
        click(ADD_CART_BUTTON);
        return this;
    }

    public HepsiburadaPage closeLiveSupportPopup(){

        click(LIVE_SUPPORT_POPUP);
        return this;
    }

    public HepsiburadaPage goToBuyPage(){

        click(GO_TO_CART_BUTTON);
        return this;
    }

    public boolean completeTheShoppingButtonCheck(){

        return isDisplayed(COMPLETE_SHOPPING_BUTTON);
    }

}
