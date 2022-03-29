package com.framework.Pages;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.framework.Helper.ProjectLevelFilePath;
import com.framework.Helper.Logger.LoggerHelper;
import com.framework.Hook.DriverFactory;


public class BasePage {
    public static String currentVal;
    Logger log = LoggerHelper.getLogger(BasePage.class);
    WebDriverWait wait;
    public void sendKeys(WebElement element,String value) {
        log.info("Locator : " + element + " Value : " + value);
        element.sendKeys(value);
    }
    public void clearAndSendKeys(WebElement element,String value) {
        element.sendKeys(Keys.CONTROL, "a", Keys.DELETE);
        element.clear();
        element.sendKeys(value);
        log.info(value);
    }
    public Actions getActionClass() {
        return new Actions(DriverFactory.getInstance().getDriver());
    }
    
    public void clickOnElement(WebElement element) {
        this.getActionClass().click().build().perform();
    }
    public Object executeScript(String script) {
        log.info(script);
        JavascriptExecutor exe =(JavascriptExecutor)DriverFactory.getInstance().getDriver();
        return exe.executeScript(script);
    }
    
    public Object executeScript(String script, Object... args) {
        JavascriptExecutor exe = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
        log.info(script);
        return exe.executeScript(script, args);
    }
    public void scrollToElement(WebElement element) {
        executeScript("window.scrollTo(arguments[0],arguments[1])",
                element.getLocation().x, element.getLocation().y);
    }
    
    
    public void scrollToElementAndClick(WebElement element) {
        scrollToElement(element);
        element.click();  
    }
    
    public void scrollIntoView(WebElement element) {
    	 wait = new WebDriverWait(DriverFactory.getInstance().getDriver(), 40);
    	 wait.until(ExpectedConditions.elementToBeClickable(element));
        executeScript("arguments[0].scrollIntoView()", element);
        log.info(element);
    }
    
    public void scrollIntoViewAndClick(WebElement element) {
        wait = new WebDriverWait(DriverFactory.getInstance().getDriver(), 40);
        scrollIntoView(element);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        this.clickOnelement(element);
    }
    
    public void scrollToTopOfPage() {
        executeScript("window.scrollTo(0, 0);");
    }
    public void clickOnelement(WebElement element) {
        executeScript("arguments[0].click();", element);
    }
    public void clickOnButton(WebElement element) {
        Assert.assertTrue(element.isDisplayed());
        wait = new WebDriverWait(DriverFactory.getInstance().getDriver(), 40);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        try{ 
            element.click();
            log.info("Locator : " + element + " is clicked");
        }
        catch(Exception e){
            log.error("Locator : " + element + " is having error "+ e.getMessage());
            Assert.assertTrue(false);
        }
    }
    public boolean isSelectedCheckBox(WebElement element) {
        if(element.isSelected()) {
            log.info(element.isSelected()); 
            return true;
        }
        else {
            log.info(element.isSelected());
            return false;
        }
    }
    public boolean isUnselectedCheckBox(WebElement element) {
        if(!element.isSelected())
            return true;
        else 
            return false;
    }
    public void selectCheckBox(WebElement element) {
        log.info("Inside Select CheckBox");
        element.click();
    }
    public void unSelectCheckBox(WebElement element) {
        if(isSelectedCheckBox(element)) {
            log.info("Inside Unselect CheckBox");
            element.click();
        }
    }
    public void elementVisible(WebElement element){
        wait = new WebDriverWait(DriverFactory.getInstance().getDriver(), 40);
        try{
            wait.until(ExpectedConditions.visibilityOf(element));
            if(element.isDisplayed()) {
                Assert.assertTrue(element.isDisplayed());
            }
            else {          
                log.info(element.isDisplayed());
            }
        }   
        catch(Exception e){
            log.info("Having exception "+ e.getMessage());
            Assert.assertTrue(false);
        }
    }
    public boolean ElementEnable(WebElement element) {
        boolean flag=false;
        wait = new WebDriverWait(DriverFactory.getInstance().getDriver(), 40);
        wait.until(ExpectedConditions.visibilityOf(element));
        try{
            if(element.isEnabled()){
                log.info("Locator : " + element + " is Enabled");
                flag = true; 
                Assert.assertTrue(flag);
            }
            else {
                log.info("Locator : " + element + " is not Enabled");
                flag = false; 
                Assert.assertTrue(flag);
            }
        }
        catch(Exception e){
            log.info("Locator : " + element + " is having exception "+ e.getMessage()); 
        }
        return flag;
    }
    public boolean isElementSelected(WebElement element) {
        boolean flag =false;
        wait = new WebDriverWait(DriverFactory.getInstance().getDriver(), 40);
        wait.until(ExpectedConditions.visibilityOf(element));
        if(element.isSelected()) {
            log.info(flag);
            flag =true;
            Assert.assertTrue(flag);
        }
        log.info(flag);
        return flag;
    }
    
    
    public boolean VerifyElementIsDisable(WebElement element) {
        boolean flag =false;
        wait = new WebDriverWait(DriverFactory.getInstance().getDriver(), 40);
        log.info(flag);
        wait.until(ExpectedConditions.visibilityOf(element));
        if(!element.isEnabled()) {
            flag = true;
            log.info(flag);
            Assert.assertTrue(flag);
        }
        return flag;
    }
    public boolean isElementPresent(By by) {
        boolean isPresent = true;
        try {
            DriverFactory.getInstance().getDriver().findElement(by);
        } catch (Exception e) {
            isPresent = false;
        }
        return isPresent;
    }
    public boolean isElementDisplayed(WebElement element) {
        boolean flag=false;
        wait = new WebDriverWait(DriverFactory.getInstance().getDriver(), 40);
        wait.until(ExpectedConditions.visibilityOf(element));
        if(element.isDisplayed()) {
            log.info("Locator : " + element + " is Visible");
            Assert.assertTrue(element.isDisplayed());
            log.info(element.isDisplayed());
        }
        else {
            log.info("Locator : " + element + " is not Visible");
            Assert.assertTrue(element.isDisplayed());
            log.info(element.isDisplayed());
        }
        return flag;
    }
    public void verifyPageIsLoaded() {
        try {
        if(this.isElementPresent(By.xpath("//*[@class='example vcmSpinner']")) && DriverFactory.getInstance().getDriver().findElement(By.xpath("//*[@class='example vcmSpinner']")).isDisplayed()) {
        	log.info("Found Spinner");
        	WebElement spinner=DriverFactory.getInstance().getDriver().findElement(By.xpath("//*[@class='example vcmSpinner']"));
            wait = new WebDriverWait(DriverFactory.getInstance().getDriver(), 40);
            wait.until(ExpectedConditions.invisibilityOf(spinner));
            log.info("Page Loaded");
        }
            }
        catch(Exception ex)
        	{
        	log.info("Exception caught  = >"+ex);
            }
    	}
    public boolean isElementPresent1(WebElement element) {
        boolean flag = false;
        try {
            flag = true;        
        } catch (NoSuchElementException e) {
            flag = false;
        }
        return flag;
    }
    @FindBy(xpath="//*[contains(text(),'Back')]")
    WebElement backBtn;
    
    public void clickOnBackBtn() {
        this.clickOnelement(backBtn);
    }
    public void verifyBackButtonIsDisplayed() {
        Assert.assertTrue(backBtn.isDisplayed());
    }
    public void waitForPageLoaded() {
        WebDriver driver = DriverFactory.getInstance().getDriver();
        ExpectedCondition<Boolean> expectation = new
                ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor)driver).executeScript("return document.readyState").toString().equals("complete");
            }
        };
        try {
            WebDriverWait wait = new WebDriverWait(driver, 40);
            wait.until(expectation);
        } catch (Throwable error) {
            // Assert.fail("Timeout waiting for Page Load Request to complete.");
        }
    }
    public void clickOnButtonUsingJs(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor)DriverFactory.getInstance().getDriver();
        js.executeScript("arguments[0].click();", element);
    }
    @FindBy(xpath="//span[text()='Next']")
    WebElement nextBtn;
    public void clickOnNext() {
        this.verifyPageIsLoaded();
        wait = new WebDriverWait(DriverFactory.getInstance().getDriver(), 40);
        wait.until(ExpectedConditions.elementToBeClickable(nextBtn));
        this.clickOnButtonUsingJs(nextBtn);
    }
    public  void takeSnapShot(WebDriver webdriver,String fileWithPath) throws Exception{
        TakesScreenshot scrShot =((TakesScreenshot)webdriver);
        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
        File DestFile=new File(fileWithPath);
        String fileName  = DestFile+".png";
        FileUtils.copyFile(SrcFile, new File(fileName));   
    }
    public String getScreenShotFilePath() {
        String path =  ProjectLevelFilePath.getProjectPath()+"src//main//resources//ScreenShots//";
        log.info("File Path"+path);
        return path;
    }
    
    public void ExplicitWaitTimeout(WebDriver driver, int timeOut) {
        wait = new WebDriverWait(driver, timeOut);
    }
}
