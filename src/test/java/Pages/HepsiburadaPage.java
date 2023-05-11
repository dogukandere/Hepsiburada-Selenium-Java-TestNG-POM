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
    private final String CONTINUE_SHOPPING_ELEMENT = "//*[@id=\"AddToCart_f8b336f5-0615-4f2b-7793-96cee90b3a72\"]/div/div/div/div/div/div[1]/div/div[1]/div/div[2]/button[2]";
    private final String GO_TO_CART_BUTTON = "//*[@id=\"AddToCart_99c2abed-beb7-4b77-813a-eb0c55a9b0f9\"]/div/div/div/div/div/div[1]/div/div[1]/div/div[2]/button[1]";
    private final String LIVE_SUPPORT_POPUP = "//*[@id=\"Embed\"]/div/div/div/div/div/div/header/div/button[2]/svg";
    private final String SHOPPING_BUTTON = "//button[@id='continue_step_btn']";

    public void acceptPopup(){
            click(POPUP);
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

    public void searchProduct(String productname){

        sendKeys(SEARCH_BOX,productname);
    }

    public void searchClick(){

        click(SEARCH_BUTTON);
    }

    public void productClick(){

        click(PRODUCT);
    }

    public String checkThePrice(){

        return getTextOfElement(TEXT_CONTROL_ELEMENT);
    }

    public void addToCart(){

        click(ADD_CART_BUTTON);
    }

    public boolean continueShoppingButtonCheck(){

        return isDisplayed(CONTINUE_SHOPPING_ELEMENT);
    }

    public void closeLiveSupportPopup(){

        click(LIVE_SUPPORT_POPUP);
    }

    public void goToBuyPage(){

        click(GO_TO_CART_BUTTON);
    }

    public boolean shoppingButtonCheck(){

        return isDisplayed(SHOPPING_BUTTON);
    }

}
