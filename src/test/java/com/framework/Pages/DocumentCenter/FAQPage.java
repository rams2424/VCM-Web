package com.framework.Pages.DocumentCenter;

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

public class FAQPage extends BasePage{
    
    Logger log = LoggerHelper.getLogger(FAQPage.class);
    WebDriver driver;
    WebDriverWait wait;
    public FAQPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);   
    }
    @FindBy(xpath="//span[text()='FAQs']")
    WebElement faqPagetxt;
    public void verifyFAQPageIsDisplaying(String expected) {
        log.info("Expected"+expected);
        log.info("Actual"+faqPagetxt.getText());
        Assert.assertTrue(expected.equalsIgnoreCase(faqPagetxt.getText()));
    }
    @FindBy(xpath="//*[@id='showing']")
    WebElement ShowingAllFaqs;
    public void ShowAllFaqs(){
        wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.visibilityOf(ShowingAllFaqs));
        this.clickOnButton(ShowingAllFaqs);
    }
    
    @FindBy(xpath="//*[@id='refId0']")
    WebElement UsingVCM;
    public void UsingVCM(){
        this.elementVisible(UsingVCM);
    }
    
    
    @FindBy(xpath="//*[@id='refId1']")
    WebElement RegistrationAndAccount;
    public void RegistrationAndAccount(){
        this.elementVisible(RegistrationAndAccount);
    }
    
    @FindBy(xpath="//*[@id='refId2']")
    WebElement Investing;
    public void Investing(){
        this.elementVisible(Investing);
    }
    @FindBy(xpath="//*[@id='bread-crum-link-home']")
    WebElement homePage;
    public void  navigateToHomePage() throws InterruptedException {	 
        wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.elementToBeClickable(homePage));
        this.clickOnButtonUsingJs(homePage);
        
    }
}
