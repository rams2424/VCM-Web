package com.framework.Pages.AccountOpening;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.framework.Helper.Logger.LoggerHelper;
import com.framework.Pages.BasePage;

public class ConfirmAccountOpeningPage extends BasePage{
    
    WebDriverWait wait;
    WebDriver driver;
    Logger log = LoggerHelper.getLogger(ConfirmAccountOpeningPage.class);
    public ConfirmAccountOpeningPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath="//*[contains(text(),'Congratulations ')]")
    WebElement congrasTxt;
    
    public void verifyConfirmationTxt(String expected) {
        wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.visibilityOf(congrasTxt));
        log.info("Expected"+expected);
        log.info("Actual" +congrasTxt.getText());
        Assert.assertTrue(expected.equalsIgnoreCase(congrasTxt.getText()));
    }
    @FindBy(xpath="//*[@class='confirmationMsg']//span[2]")
    WebElement accountNo;
    public String  getAccountNo() {
        log.info("Account No"+accountNo.getText());
        return accountNo.getText();
    }
    @FindBy(css="button[buttontext='Ok']")
    WebElement okBtn;
    public void clickOnOkBtn() {
        wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.elementToBeClickable(okBtn));
        okBtn.click();
    }
    public void verifyAccountNo() {
        this.elementVisible(accountNo);
    }
    
}
