package com.framework.Pages.DocumentCenter;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.framework.Helper.Logger.LoggerHelper;
import com.framework.Pages.BasePage;

//import junit.framework.Assert;


public class DocumentPreferencesPage extends BasePage {
    
    WebDriverWait wait;
    WebDriver driver;
    public  DocumentPreferencesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    Logger log = LoggerHelper.getLogger(DocumentPreferencesPage.class);
    
    @FindBy(xpath="//*[text()='General Account Preferences']")
    WebElement AccountPreferences;
    public void VerifyAccountPreference(){
        wait = new WebDriverWait(driver, 40);
        //wait.until(ExpectedConditions.visibilityOf(AccountPreferences));
        Assert.assertTrue(AccountPreferences.isDisplayed());
    }
    
    @FindBy(xpath="//*[@id='docReceptionQOnline']")
    WebElement Online;
    @FindBy(xpath="//*[@id='button']")
    WebElement Submit;
    public void ClickonOnline(){
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", Online);
        this.clickOnButton(Submit);
    }
    @FindBy(xpath="//*[@id='docReceptionQPaper']")
    WebElement Paper;
    public void ClickonPaper(){
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", Paper);
        this.clickOnButton(Submit);		
    }
    @FindBy(xpath="//*[text()='Profile and Preferences']")
    WebElement ProfileAndPreferences;
    public ProfileAndPreferencesPage  navigateToProfileAndPreferences() {
        this.clickOnElement(ProfileAndPreferences);
        return new ProfileAndPreferencesPage(driver);
    }
    @FindBy(xpath="//BUTTON[@id='statusMsgClose']")
    WebElement Close;
    public void closepopup(){
       // Close.click();
    }
}
