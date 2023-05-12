package Pages;

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

    private final String TEXT_CONTROL_ELEMENT = "//span[@data-bind=\"markupText:'currentPriceBeforePoint'\"]";
    private final String ADD_CART_BUTTON = "//button[@id='addToCart']";
    private final String GO_TO_CART_BUTTON = "//button[normalize-space()='Sepete git']";

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
