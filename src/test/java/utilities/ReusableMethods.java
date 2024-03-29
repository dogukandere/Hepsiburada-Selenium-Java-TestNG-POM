package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static java.lang.Math.abs;
import static utilities.DriverFactory.driver;

public class ReusableMethods {

    public void rightClick(WebElement element){
        Actions action = new Actions(driver);
        action.contextClick(element).perform();
    }

    public void doubleClick(WebElement element){
        Actions action = new Actions(driver);
        action.doubleClick(element).perform();
    }

    public void screenShot() throws IOException{
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("/Users/dogukandere/Downloads/POM-hepsiburada/src/screenshots/photo.jpg"));
    }

    public ReusableMethods waitFor(int sec){
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }

    public void scrollDown(int pixels){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0, " + abs(pixels) + ");", "");
    }

    public void scrollIntoView(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView(false);", element);
    }

    public void hover(WebElement element){
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    public void hoverOverMenu(List<WebElement> list){
        Actions action = new Actions(driver);
        for(WebElement menus :list ){
            action.moveToElement(menus).perform();
            waitFor(1);
            System.out.println(menus.getText());
        }
    }

    public void getPageUrl() {
        System.out.println(driver.getCurrentUrl());
    }

    public void getPageTitle() {
        System.out.println(driver.getTitle());
    }

    public void navigateRefresh(){driver.navigate().refresh(); }

    public void navigateBack(){driver.navigate().back(); }

    public void navigateForward(){driver.navigate().forward(); }

    public void deleteCookies(){driver.manage().deleteAllCookies(); }

    public void findAllCookies(){
        Set <Cookie> cookies = driver.manage().getCookies();
        for(Cookie cookie:cookies){
            System.out.println(cookie.getName()+":"+cookie.getValue());
        }
        System.out.println("Total cookies:"+cookies.size());
    }

    public void switchToTab(){
        Set<String> tabs = driver.getWindowHandles(); //Used to switch to a new tab that opens
        for(String actual: tabs) {
            driver.switchTo().window(actual);
        }
    }

    public ReusableMethods switchToWindow(String targetTitle) {
        String origin = driver.getWindowHandle();
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
            if (driver.getTitle().equals(targetTitle)) {
                return this;
            }
        }
        driver.switchTo().window(origin);
        return null;
    }

    public void dropDownSelectByValue(WebElement element,String value){
        Select Value = new Select(element);
        Value.selectByValue(value);
    }

    public void dropDownSelectByIndex(WebElement element,int value){
        Select index = new Select(element);
        index.selectByIndex(value);
    }

    public void dropDownSelectByText(WebElement element,String value){
        Select VisibleText = new Select (element);
        VisibleText.selectByVisibleText(value);
    }

    public void getElementSize(WebElement element){
        System.out.println(element.getSize());
    }

    public void getElementLocation(WebElement element) {
        System.out.println(element.getLocation());
    }

    public void waitUntilElementIsVisible(WebElement element , int time){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitUntilElementIsLocated(By by, int time){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public void waitUntilElementIsClickable(WebElement element , int time){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void dragToElement(By by1, By by2){
        Actions action = new Actions(driver);
        WebElement element1 = driver.findElement(by1);
        WebElement element2 = driver.findElement(by2);
        action.dragAndDrop(element1,element2).build().perform();
    }

    public void dragThisCoordinate(By by, int x, int y){
        Actions action = new Actions(driver);
        WebElement element = driver.findElement(by);
        action.dragAndDropBy(element,x,y).perform();
    }

    public ReusableMethods getElementsText(List<WebElement> list) {
        List<String> elemTexts = new ArrayList<>();
        for (WebElement el : list) {
            if (!el.getText().isEmpty()) {
                System.out.println(elemTexts.add(el.getText()));
            }
        }
        return this;
    }

    public void elementContains(WebElement element, String word){
        String x= element.getText();
        Assert.assertTrue(word.contains(x));
    }

    public void findAllLinks(){
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("Total link number "+ links.size());
        for(int i=0;i<links.size();i++)
        {
            System.out.println("Link url: "+links.get(i).getAttribute("href"));
            System.out.println("Link name:"+links.get(i).getText());
        }
    }

    public void copyPasteText(By by1, By by2){
        WebElement element = driver.findElement(by1);
        WebElement element2 = driver.findElement(by2);
        element.sendKeys(Keys.COMMAND + "a");
        element.sendKeys(Keys.COMMAND + "c");
        element2.sendKeys(Keys.COMMAND + "v");
    }

    public boolean isDisplayed(By by){
        WebElement element = driver.findElement(by);
        return element.isDisplayed();
    }

    public boolean isElementDisplayed(By by){
        try{
            WebElement element = driver.findElement(by);
            return element.isDisplayed();
        }
        catch (Exception e){
            return false;
        }
    }

    public boolean isClickable(By by){
        WebElement element = driver.findElement(by);
        return element.isEnabled();
    }

    public void click(By by){
        WebElement element = driver.findElement(by);
        element.click();
    }

    public void sendKeys(By by, String value){
        WebElement element = driver.findElement(by);
        element.sendKeys(value);
    }

    public void sendNumber(By key, int number){
        driver.findElement(key).sendKeys(String.valueOf(number));
    }

    public void sendNumber2(By by, int number){
        Actions action = new Actions(driver);
        WebElement element = driver.findElement(by);
        action.sendKeys(String.valueOf(number)).perform();
    }

    public String getTextOfElement(By by) {
        return driver.findElement(by).getText();
    }

    public void checkText(By key , String text){
        if (!driver.findElement(key).getText().equals(text)) {
            Assert.fail("The text on the expected screen is incorrect.");
        }
    }

    public ReusableMethods clearElement(By by){
        WebElement element = driver.findElement(by);
        element.clear();
        return this;
    }

    public ReusableMethods checkElementNotExist(By by){
        try{
            if (isDisplayed(by)){
                Assert.fail("Element displayed");
            }
        }
        catch (Exception e){
            Assert.assertTrue(true);
        }
        return this;
    }

    public void holdTheElement(By by){
        Actions action = new Actions(driver);
        WebElement element = driver.findElement(by);
        action.clickAndHold(element).perform();
    }

    public void releaseTheElement(By by){
        Actions action = new Actions(driver);
        WebElement element = driver.findElement(by);
        action.release(element).perform();
    }

    public void holdAndRelease(By by, int time){
        Actions action = new Actions(driver);
        WebElement element = driver.findElement(by);
        action.clickAndHold(element).perform();
        waitFor(time);
        action.release(element).perform();
    }

    public int getNumberOfElements(By locator) {
        List<WebElement> elements = driver.findElements(locator);
        return elements.size();
    }

    public ReusableMethods acceptAlert (){
        driver.switchTo().alert().accept();
        return this;
    }
}
