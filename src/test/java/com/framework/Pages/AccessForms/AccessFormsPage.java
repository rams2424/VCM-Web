package com.framework.Pages.AccessForms;

import java.util.Iterator;
import java.util.Set;

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

public class AccessFormsPage extends BasePage {
    
    WebDriver driver;
    WebDriverWait wait;
    Logger log = LoggerHelper.getLogger(AccessFormsPage.class);
    public AccessFormsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath="//h3[contains(text(),'Forms')]")
    WebElement accessFormTitle;
    public void verifyAccessFormTxt(String expected) {
        log.info("Expected"+expected);
        log.info("Actual"+accessFormTitle.getText());
        Assert.assertTrue(expected.equalsIgnoreCase(accessFormTitle.getText()));
    }
    @FindBy(xpath="//*[contains(text(),'Adobe Reader')]")
    WebElement adobeReaderLink;
    public void verifyAdobeReadrelInkIsDisplaying() {
        Assert.assertTrue(adobeReaderLink.isDisplayed());
    }
    @FindBy(xpath="//button[contains(text(),'Frequently ')]")
    WebElement frequentlyTab;
    
    public void verifyFrequentlyUsedTab() {
        Assert.assertTrue(frequentlyTab.isDisplayed());
    }
    @FindBy(xpath="//button[contains(text(),'All')]")
    WebElement allFormsTab;
    
    public void verifyAllFormsTab() {
        Assert.assertTrue(allFormsTab.isDisplayed()); 
    }
    public void clickOnAllFormsTab() throws InterruptedException {
        this.verifyPageIsLoaded();
        wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(allFormsTab));
        this.clickOnButton(allFormsTab);
    }
    public void clickOnFrequentlyUsedTab() throws InterruptedException {
        this.verifyPageIsLoaded();
        wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(frequentlyTab));
        this.clickOnElement(frequentlyTab);
    }

    @FindBy(xpath="//button[contains(text(),'Frequently Used')]")
      WebElement frequentlyUsedtxt;
  
    public void verifyFrequentlyTxt() {
        Assert.assertTrue(frequentlyUsedtxt.isDisplayed());
    }
    @FindBy(xpath="//*[contains(text(),'Form ID')]")
    WebElement verifyFormIdTxt;
    public void verifyFormId() {
        Assert.assertTrue(verifyFormIdTxt.isDisplayed());
    }
    @FindBy(xpath="//*[contains(text(),'Category')]")
    WebElement verifycategoryName;
    public void verifyCategoryName() {
        Assert.assertTrue(verifycategoryName.isDisplayed());
    }
    @FindBy(xpath="//*[text()='Form']")
    WebElement verifyformName;
    public void verifyFormName() {
        Assert.assertTrue(verifyformName.isDisplayed());
    }
    
    @FindBy(xpath="//*[@data-testid='form-list']//div[@data-testid='data-test-id-form-0']//div[3]//a")
    WebElement documentLink;
    public void verifyDocumentOpenInNewTab() throws InterruptedException {
        wait = new WebDriverWait(driver, 40);
        this.verifyPageIsLoaded();
        String parentWindow = driver.getWindowHandle();
        wait.until(ExpectedConditions.visibilityOf(documentLink));
        documentLink.click();
        Set<String>list = driver.getWindowHandles();
        Iterator<String> I1= list.iterator();
        while(I1.hasNext()) {
            String child_window=I1.next();
            if(!parentWindow.equals(child_window))  {
                driver.switchTo().window(child_window);
                log.info(driver.getCurrentUrl());
                Assert.assertTrue(driver.getCurrentUrl().contains("blob:https:"));
                driver.close();
            }
        }
        driver.switchTo().window(parentWindow);   
    }
    @FindBy(xpath="//ul//li//a[@href='/accountholder']")
    WebElement homeLink;
    public void clickOnHomeLink() {
        wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(homeLink));
        this.clickOnButtonUsingJs(homeLink);
        
    }
}
