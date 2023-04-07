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

    @FindBy(xpath = "//input[@placeholder='Ürün, kategori veya marka ara']")
    private WebElement searchBox;

    @FindBy(xpath = "//div[@class='searchBoxOld-yDJzsIfi_S5gVgoapx6f']")
    private WebElement searchButton;

    @FindBy(xpath = "//*[@id=\"onetrust-accept-btn-handler\"]")
    private WebElement popup;

    @FindBy(xpath = "//a[@title='Hepsiburada']//*[name()='svg']//*[name()='path' and contains(@fill,'#FF6000')]")
    private WebElement logo;

    @FindBy(xpath = "//span[@title='Giriş Yap']")
    private WebElement loginButton;

    @FindBy(xpath = "//span[@id='shoppingCart']")
    private WebElement cartButton;

    @FindBy(xpath = "//button[@id='addToCart']")
    private WebElement addCartButton;

    @FindBy(xpath = "//a[@title='Samsung Galaxy S23 256 GB 8 GB Ram (Samsung Türkiye Garantili)']//h3[@type='comfort']")
    private WebElement product;

    @FindBy(xpath = "//span[@data-bind=\"markupText:'currentPriceBeforePoint'\"]")
    private WebElement textControlElement;

    @FindBy(xpath = "//span[@class='checkoutui-ProductOnBasketHeader-nOvp_U8bHbLzgKbSUFaz']")
    private WebElement productCheckElement;

    @FindBy(xpath = "//button[normalize-space()='Sepete git']")
    private WebElement goToCartButton;

    @FindBy(xpath = "//button[@id='continue_step_btn']")
    private WebElement shoppingButton;


    public void navigateToPage(String url) {
        driver.navigate().to(url);
    }

    public void acceptPopup(){
        if(popup.isDisplayed()){
            popup.click();
        }
        else{
            System.out.println("Popup is already accepted");
        }
    }

    public void buttonCheck(){
        isDisplayed(loginButton);
        isDisplayed(cartButton);
    }

    public void linkLogoTitleCheck(){
        isDisplayed(logo);
        Assert.assertEquals("https://www.hepsiburada.com/",driver.getCurrentUrl());
        Assert.assertEquals("Türkiye'nin En Büyük Online Alışveriş Sitesi Hepsiburada.com",driver.getTitle());
    }

    public void searchProduct(String productname){
        SendKeys(searchBox,productname);
    }

    public void searchClick(){
        Click(searchButton);
    }

    public void productClick(){
        Click(product);
    }

    public void priceCheck(String fiyat){
        Assert.assertEquals(textControlElement.getText(),fiyat);
    }

    public void addToCart(){
        Click(addCartButton);
    }

    public void productInCartCheck(){
        waitUntilElementIsVisible(productCheckElement,10);
        Assert.assertEquals(productCheckElement.getText(),"Ürün sepetinizde");
    }

    public void goToBuyPage(){
        Click(goToCartButton);
    }

    public void shoppingButtonCheck(){
        isDisplayed(shoppingButton);
        isClickable(shoppingButton);
    }

}
