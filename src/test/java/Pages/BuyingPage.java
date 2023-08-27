package Pages;

import org.openqa.selenium.By;
import utilities.ReusableMethods;

public class BuyingPage extends ReusableMethods {

    private static final By COMPLETE_SHOPPING_BUTTON = By.xpath("//button[@id='continue_step_btn']");

    public boolean completeTheShoppingButtonCheck(){

        return isDisplayed(COMPLETE_SHOPPING_BUTTON);
    }
}
