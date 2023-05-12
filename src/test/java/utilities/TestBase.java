package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public abstract class TestBase {
    protected WebDriver driver;

    @BeforeClass
    public void before(){

        System.setProperty("webdriver.http.factory", "jdk-http-client");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public void navigateToUrl(String url) {

        driver.navigate().to(url);
    }

    @AfterClass
    public void tearDown(){

        driver.quit();
    }

}
