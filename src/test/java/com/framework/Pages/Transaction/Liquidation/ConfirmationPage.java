package com.framework.Pages.Transaction.Liquidation;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.framework.Helper.Logger.LoggerHelper;
import com.framework.Hook.Hooks;
import com.framework.Pages.HomePage;

public class ConfirmationPage{
    
    Logger log = LoggerHelper.getLogger(ConfirmationPage.class);
    WebDriver driver;
    private Hooks hook;
    public ConfirmationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }  
    @FindBy(css="div[data-test='confirmationHeading']")
    WebElement confirmationTxt;
    
    public void verifyConfirmationTxt(String expectedTxt) {
        log.info("Expected Text"+expectedTxt);
        log.info("Actual text"+confirmationTxt.getText());
        Assert.assertEquals(confirmationTxt.getText(), expectedTxt);
    }
    @FindBy(css="p[data-test='confirmationMessage']")
    WebElement confirmationMsg;
    
    public void verifyConfirmationMsg(String expected) {
        log.info("Confirmation Message"+confirmationMsg.getText());
        log.info("Expected"+expected);
        log.info(expected.equalsIgnoreCase(confirmationMsg.getText()));
        Assert.assertTrue(expected.equalsIgnoreCase(confirmationMsg.getText()));
    }
    @FindBy(xpath="//a[text()='Home']")
    WebElement homeLink;
    public HomePage navigateToHomePage() {
        homeLink.click();
        return new HomePage(driver);	
    }
}
