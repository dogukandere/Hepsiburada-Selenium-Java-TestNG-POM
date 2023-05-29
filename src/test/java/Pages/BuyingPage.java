package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utilities.ReusableMethods;

public class BuyingPage extends ReusableMethods {
    WebDriver driver;

    public BuyingPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    private final By COMPLETE_SHOPPING_BUTTON = By.xpath("//button[@id='continue_step_btn']");

    public boolean completeTheShoppingButtonCheck(){

        return isDisplayed(COMPLETE_SHOPPING_BUTTON);
    }
}
