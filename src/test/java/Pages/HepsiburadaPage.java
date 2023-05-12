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
}
