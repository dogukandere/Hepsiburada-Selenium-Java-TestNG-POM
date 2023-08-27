package Pages;

import org.openqa.selenium.By;
import utilities.ReusableMethods;

public class ProductListPage extends ReusableMethods {

    private static final By PRODUCT = By.xpath("//a[@title='Samsung Galaxy S23 256 GB 8 GB Ram (Samsung Türkiye Garantili)']//h3[@type='comfort']");

    public ProductListPage productClick(){

        click(PRODUCT);
        return this;
    }
}
