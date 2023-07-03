package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utilities.ReusableMethods;

public class ProductPage extends ReusableMethods {
    WebDriver driver;

    public ProductPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    private static final By TEXT_CONTROL_ELEMENT = By.xpath("//span[@data-bind=\"markupText:'currentPriceBeforePoint'\"]");
    private static final By ADD_CART_BUTTON = By.xpath("//button[@id='addToCart']");
    private static final By GO_TO_CART_BUTTON = By.xpath("//button[normalize-space()='Sepete git']");

    public String checkThePrice(){

        return getTextOfElement(TEXT_CONTROL_ELEMENT);
    }

    public ProductPage addToCart(){

        click(ADD_CART_BUTTON);
        return this;
    }

    public ProductPage goToBuyPage(){

        click(GO_TO_CART_BUTTON);
        return this;
    }
}
