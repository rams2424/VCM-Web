package com.framework.Pages.AccountOpening.GeneralInvestmentAccount;

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
import com.framework.Pages.AccountOpening.PersonalInfoPage;

public class GeneralInvestmentAccountPage extends BasePage{
    
    WebDriver driver;
    Logger log = LoggerHelper.getLogger(GeneralInvestmentAccountPage.class);
    WebDriverWait wait;
    public GeneralInvestmentAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }	
    @FindBy(xpath="//h3[contains(text(),'in Entirety')]")
    WebElement jointwithEntirety;
    
    public void verifyjointEntiertyAccount(String expected) {
        log.info("Expected"+expected);
        log.info(jointwithEntirety.isDisplayed());
        log.info("Actual"+jointwithEntirety.getText());	
        Assert.assertTrue(expected.equalsIgnoreCase(jointwithEntirety.getText()));
    }
    
    @FindBy(xpath="//h3[contains(text(),' in Common')]")
    WebElement jointWithCommon;
    
    public void verifyjointCommonAccount(String expected) {
        log.info("Expected"+expected);
        log.info(jointWithCommon.isDisplayed());
        log.info("Actual"+jointWithCommon.getText());	
        Assert.assertTrue(expected.equalsIgnoreCase(jointWithCommon.getText()));
    }	
    
    public void clickOnIndividualAccount() {
        wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.elementToBeClickable(indAccount));
        this.clickOnButton(indAccount);
    }
    public void clickOnJointTetantAccount() {
        wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.elementToBeClickable(jointTetant));
        this.clickOnButton(jointTetant);
    }
    public void clickOnJointCommonAccount() {
        wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.elementToBeClickable(jointWithCommon));
        this.clickOnButton(jointWithCommon);
    }
    public void clickOnJointEntiertyAccount() {
        wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.elementToBeClickable(jointwithEntirety));
        this.clickOnButton(jointwithEntirety);
    }
    
    @FindBy(xpath="//h3[contains(text(),'Right of Survivorship')]")
    WebElement jointTetant;
    
    public void verifyjointTetantAccount(String expected) {
        log.info("Expected"+expected);
        log.info(jointTetant.isDisplayed());
        log.info("Actual"+jointTetant.getText());
        Assert.assertTrue(expected.equalsIgnoreCase(jointTetant.getText()));
    }
    @FindBy(xpath="//h3[contains(text(),'Ind')]")
    WebElement indAccount;
    public void verifyindividualAccount(String expected) {
        log.info("Expected"+expected);
        log.info(indAccount.isDisplayed());
        log.info("Actual"+indAccount.getText());	
        Assert.assertTrue(expected.equalsIgnoreCase(indAccount.getText()));
    }
    
    public PersonalInfoPage redirectToPersonalInfoPage() {
        return new PersonalInfoPage(driver);
    }
    public void clickonJointAccount(String accType) {
        log.info("Account Type"+accType);
        switch(accType) {
            case "Joint Tenants With Right":
                this.clickOnJointTetantAccount();
                break;
            case "Joint Tenants in Common":
                this.clickOnJointCommonAccount();
                break;
            case "Joint Tenants in Entirety":
                this.clickOnJointEntiertyAccount();
                break;
        }
    }
   
}
